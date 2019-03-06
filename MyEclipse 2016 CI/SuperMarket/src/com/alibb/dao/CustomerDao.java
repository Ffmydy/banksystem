package com.alibb.dao;

import com.alibb.pojo.Customer;

public interface CustomerDao {
	Customer customerLogin(String cphonenumber,String cpassword);
	void customerRegister(Customer customer);
}
