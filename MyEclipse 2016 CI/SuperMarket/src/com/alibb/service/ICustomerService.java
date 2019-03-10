package com.alibb.service;

import com.alibb.pojo.Customer;

public interface ICustomerService {
	Customer customerLogin(String cphonenumber,String cpassword);
	void customerRegister(Customer customer);
	void buygoods(int gid, String bnumber, double gprice, Integer cid);
}
