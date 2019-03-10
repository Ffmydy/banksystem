package com.alibb.service;

import com.alibb.dao.CustomerDao;
import com.alibb.pojo.Customer;

public class CustomerServiceImpl implements ICustomerService {
	private CustomerDao dao;
	public void setDao(CustomerDao dao) {
		this.dao = dao;
	}

	@Override
	public Customer customerLogin(String cphonenumber, String cpassword) {
		return dao.customerLogin(cphonenumber, cpassword);
	}

	@Override
	public void customerRegister(Customer customer) {
		//System.out.println(customer);
		dao.customerRegister(customer);
	}

	@Override
	public void buygoods(int gid, String bnumber, double gprice, Integer cid) {
		dao.buygoodscone(gid,bnumber);
		dao.buygoodsctwo(bnumber,gprice,cid);
		
	}


}
