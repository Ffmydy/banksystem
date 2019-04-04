package com.haut.handlers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.haut.beans.Manage;
import com.haut.service.IManageService;

@Controller
public class ManageController {
	@Autowired
	@Qualifier("manageService")
	private IManageService service;
	public void setService(IManageService service) {
		this.service = service;
	}
	//登录
	@RequestMapping("/login.do")
	public ModelAndView doLogin(String phonenumber,String password){
		System.out.println(phonenumber+"......"+password);
		ModelAndView mv=new ModelAndView();
		Manage manage=service.manageLogin(phonenumber,password);
		mv.addObject("manage", manage);
		//System.out.println(manage);
		if(manage!=null){
			mv.setViewName("forward:/main.jsp");
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
}
