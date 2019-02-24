package com.alibb.service;

public interface IBuyBook {
	void openu(String uname,double umoney);//用户开户
	void openb(String bname,double bprice,int bnumber);//书籍进库
	
	void buybook(String uname,String bname,int number);//用户购书

} 
