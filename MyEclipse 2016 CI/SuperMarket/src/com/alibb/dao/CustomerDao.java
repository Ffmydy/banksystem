package com.alibb.dao;

import com.alibb.pojo.Customer;

public interface CustomerDao {
	Customer customerLogin(String cphonenumber,String cpassword);
	void customerRegister(Customer customer);
	//购物导致商品数量减少
	void buygoodscone(int gid, String bnumber);
	//购物导致自己的money减少
	void buygoodsctwo(String bnumber, double gprice, Integer cid);
}
