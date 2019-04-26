package com.haut.handlers;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.haut.beans.Manage;
import com.haut.service.IManageService;
import com.haut.util.RandomCode;


@Controller
public class PhoneCodeController {
	@Autowired
	@Qualifier("manageService")
	private IManageService service;
	public void setService(IManageService service) {
		this.service = service;
	}
	@RequestMapping(value="/sendSMS.do",method=RequestMethod.POST)
	@ResponseBody
	public Object sendSMS(String manage_phonenumber) throws ClientException{
		System.out.println(manage_phonenumber);
		Manage manage=service.checkphonenumber(manage_phonenumber);
		if(manage==null){
			RandomCode.setNewcode();
	        String code = Integer.toString(RandomCode.getNewcode());
			SendSmsResponse sendSmsResponse = sendCode(manage_phonenumber,code);
			if(sendSmsResponse.getCode().equals("isv.MOBILE_NUMBER_ILLEGAL")){
				return "error_phonenumber";
			}
			else{	
				return code;
			}
		}
		else{
			return "error_registered";
		}
	}
	@RequestMapping(value="/verifyIdentity.do",method=RequestMethod.POST)
	@ResponseBody
	public Object verifyIdentity(String manage_phonenumber) throws ClientException{
		Manage manage=service.checkphonenumber(manage_phonenumber);
		if(manage==null){
			return "error_not_register";
		}
		else{
			RandomCode.setNewcode();
	        String code = Integer.toString(RandomCode.getNewcode());
			SendSmsResponse sendSmsResponse = sendCode(manage_phonenumber,code);
			if(sendSmsResponse.getCode().equals("isv.MOBILE_NUMBER_ILLEGAL")){
				return "error_phonenumber";
			}
			else{	
				return code;
			}	
		}
	}
	public static SendSmsResponse sendCode(String manage_phonenumber,String code)throws ClientException{
		//设置超时时间-可自行调整
		System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
		System.setProperty("sun.net.client.defaultReadTimeout", "10000");
		//初始化ascClient需要的几个参数
		final String product = "Dysmsapi";//短信API产品名称（短信产品名固定，无需修改）
		final String domain = "dysmsapi.aliyuncs.com";//短信API产品域名（接口地址固定，无需修改）
		//替换成你的AK
		final String accessKeyId = "LTAINlG0tBsow7gW";//你的accessKeyId,参考本文档步骤2
		final String accessKeySecret = "UF2zbrMVxIrAemjFoT1PAMypNJRXDb";//你的accessKeySecret，参考本文档步骤2
		//初始化ascClient,暂时不支持多region（请勿修改）
		IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId,
		accessKeySecret);
		DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
		IAcsClient acsClient = new DefaultAcsClient(profile);
		 //组装请求对象
          SendSmsRequest request = new SendSmsRequest();
		 //使用post提交
		//W request.setMethod(MethodType.POST);
		 //必填:待发送手机号。支持以逗号分隔的形式进行批量调用，批量上限为1000个手机号码,批量调用相对于单条调用及时性稍有延迟,验证码类型的短信推荐使用单条调用的方式；发送国际/港澳台消息时，接收号码格式为国际区号+号码，如“85200000000”
		 request.setPhoneNumbers(manage_phonenumber);
		 //必填:短信签名-可在短信控制台中找到
		 request.setSignName("万佛湖水资源管理系统");
		 //必填:短信模板-可在短信控制台中找到，发送国际/港澳台消息时，请使用国际/港澳台短信模版
		  request.setTemplateCode("SMS_162733627");
		  request.setTemplateParam("{\"code\":\"" + code + "\"}");
		  request.setOutId("yourOutId");
		  SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
		  if(sendSmsResponse.getCode()!= null && sendSmsResponse.getCode().equals("OK")){
	            System.out.println("短信发送成功！");
	            System.out.println(code);
	        }else {
	        	System.out.println(sendSmsResponse.getCode());
	            System.out.println("短信发送失败！");
	        }
	        return sendSmsResponse;
	}
}
