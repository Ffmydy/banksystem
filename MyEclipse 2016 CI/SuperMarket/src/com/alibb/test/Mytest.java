package com.alibb.test;

import java.security.Provider.Service;

import org.junit.Test;

import com.alibb.pojo.Customer;
import com.alibb.service.ICustomerService;
import com.alibb.util.GetCustomerService;

public class Mytest {
	@Test
	public void test01(){
		ICustomerService service = new GetCustomerService().getCustomerService();
		Customer customer = new Customer("黄涛", "ht123", "13980989809", "河南工业大学", 10000);
		service.customerRegister(customer);
	}
}
