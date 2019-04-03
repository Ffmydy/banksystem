package com.haut.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.haut.beans.Manage;
import com.haut.service.IManageService;

@Controller
@RequestMapping("/font")
public class ManageController {
	@Autowired
	@Qualifier("manageService")
	private IManageService service;
	public void setService(IManageService service) {
		this.service = service;
	}
	@RequestMapping("/login.do")
	public String doLogin(String phonenumber,String password){
		Manage manage=service.manageLogin(phonenumber,password);
		System.out.println(manage);
		if(manage!=null){
			return "/main.jsp";
		}
		else{
			return "/index.jsp";
		}
	}
}
