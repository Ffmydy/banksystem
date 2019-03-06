package com.alibb.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;

import com.alibb.service.ICustomerService;

public class GetCustomerService {
	public ICustomerService getCustomerService(){
	ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	ICustomerService service=(ICustomerService) ac.getBean("customerService");
	return service;
	}
}
