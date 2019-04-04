package com.haut.handlers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
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
	@RequestMapping("/register.do")
	public void doRegister(HttpServletRequest request,HttpServletResponse response){
		String password = request.getParameter("password");
		String apassword = request.getParameter("apassword");
		if(password.equals(apassword)){
			
		}
	}
}
