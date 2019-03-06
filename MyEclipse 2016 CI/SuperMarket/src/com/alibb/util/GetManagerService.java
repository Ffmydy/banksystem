package com.alibb.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;

import com.alibb.service.IManagerService;

public class GetManagerService {
	public IManagerService getManagerService(){
	ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	IManagerService service=(IManagerService) ac.getBean("managerService");
	return service;
	}
}
