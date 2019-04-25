package com.haut.handlers;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.haut.beans.Manage;
import com.haut.common.RandomValidateCode;
import com.haut.constant.Constants;
import com.haut.service.IManageService;

import net.sf.ehcache.pool.sizeof.SizeOf;

@Controller
public class ManageController {
	@Autowired
	@Qualifier("manageService")
	private IManageService service;
	public void setService(IManageService service) {
		this.service = service;
	}
	@Resource
    RandomValidateCode code;
    @RequestMapping("/vcode.do")
    public void vcode(HttpServletRequest request,HttpServletResponse response) {
        code.getRandcode(request, response);
    }
	//登录
	@RequestMapping("/login.do")
	public ModelAndView doLogin(String phonenumber,String password,@RequestParam String vcode,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		ModelAndView mv=new ModelAndView();
		Manage manage=service.manageLogin(phonenumber,password);
		mv.addObject("manage", manage);
		//获取session中的code
        String sessionCode=(String)request.getSession().getAttribute(Constants.RANDOM_CODE_KEY);
        //将随机生成的验证码和用户输入的验证码统一转化成大写或者小写
        vcode=vcode.toLowerCase();
        sessionCode=sessionCode.toLowerCase();
        if(manage!=null){
        	if(vcode.equals(sessionCode)){
        	   session.setAttribute("manage", manage);
        	   mv.setViewName("forward:/main.jsp");
            }
        	else{
        		mv.addObject("error", "验证码错误");
            	mv.setViewName("forward:/index.jsp");
        	}
        }
        else{
        	mv.addObject("error", "用户名或密码错误");
			mv.setViewName("forward:/index.jsp");
        }
		return mv;
	}
	//注册
	@RequestMapping("/register.do")
	public ModelAndView doRegister(@Validated Manage manage,BindingResult br,HttpServletRequest request){
		ModelAndView mv=new ModelAndView();
		//System.out.println(manage);
		List<ObjectError> errors=br.getAllErrors();
		if(errors.size()>0){
			FieldError nameError=br.getFieldError("manage_name");
			FieldError phonenumberError=br.getFieldError("manage_phonenumber");
			FieldError ageError=br.getFieldError("manage_age");
			FieldError passwordError=br.getFieldError("manage_password");
			FieldError sexError=br.getFieldError("manage_sex");
			if(passwordError!=null){
				mv.addObject("error", passwordError.getDefaultMessage());
			}
			if(ageError!=null){
				mv.addObject("error", ageError.getDefaultMessage());
			}
			if(phonenumberError!=null){
				mv.addObject("error",phonenumberError.getDefaultMessage());
			}
			if(nameError!=null){
				mv.addObject("error", nameError.getDefaultMessage());
			}
			if(sexError!=null){
				mv.addObject("error", sexError.getDefaultMessage());
			}
			mv.setViewName("/register.jsp");
			return mv;
		}
		else if(request.getParameter("manage_apassword")==""||request.getParameter("manage_apassword")==null){
			mv.addObject("error", "请确认密码是否正确");
			mv.setViewName("/register.jsp");
			return mv;
		}
		else if(!request.getParameter("manage_apassword").equals(manage.getManage_password())){
			mv.addObject("error", "两次密码不一致，确认后重新输入");
			mv.setViewName("/register.jsp");
			return mv;
		}
		else{
			Manage manage2=service.checkphonenumber(manage.getManage_phonenumber());
			if(manage2!=null){
				mv.addObject("error", "您的手机号已经注册过，请直接登录");
				mv.setViewName("/register.jsp");
				return mv;
			}
			else{
				service.manageRegister(manage);
				mv.addObject("registersuc", "您已注册成功，请去登录");
				mv.setViewName("/index.jsp");
				return mv;
			}
		}
	}
	@RequestMapping("/checkpersonal_information.do")
	public ModelAndView docheckpersonal_information(HttpSession session){
		ModelAndView mv=new ModelAndView();
		Manage manage=(Manage) session.getAttribute("manage");
		mv.addObject("manage", manage);
		System.out.println(manage);
		mv.setViewName("/show_personal_information.jsp");
		return mv;
	}
	@SuppressWarnings("null")
	@RequestMapping("/alterpassword.do")
	public ModelAndView doalterpassword(String oldpassword,String newpassword,String anewpassword,HttpSession session)throws Exception{
		ModelAndView mv=new ModelAndView();
		Manage manage=(Manage) session.getAttribute("manage");
		String manage_phonenumber=manage.getManage_phonenumber();
		String oldpass=manage.getManage_password();
		if(oldpassword==oldpass){
			if(newpassword!=null&&!newpassword.equals("")){
				if(newpassword==anewpassword){
					if(newpassword.length()>=6&&newpassword.length()<=16){
						service.alterpassword(manage_phonenumber,newpassword);
						mv.setViewName("/show_personal_infomation.jsp");
						return mv;
					}
					else {
						mv.addObject("Error","新密码的长度是6~16个字符");
						mv.setViewName("/alterpassword.jsp");
						return mv;
					}
				}
				else{
					mv.addObject("Error", "两次输入的密码不一致，请重新输入");
					mv.setViewName("/alterpassword.jsp");
					return mv;
				}
			}
			else{
				mv.addObject("Error", "密码不能为空，请重新输入");
				mv.setViewName("/alterpassword.jsp");
				return mv;
			}
		}
		else{
			mv.addObject("Error", "旧密码不正确,请重新输入");
			mv.setViewName("/alterpassword.jsp");
			return mv;
		}
	}
}
