package com.alibb.service;

import com.alibb.dao.BookDao;
import com.alibb.dao.UserDao;

public class BuyBookImpl implements IBuyBook {
	UserDao udao;
	BookDao bdao;
	
	public void setUdao(UserDao udao) {
		this.udao = udao;
	}
	public void setBdao(BookDao bdao) {
		this.bdao = bdao;
	}
	@Override
	public void openu(String uname, double umoney) {
		udao.openu(uname, umoney);
	}
	@Override
	public void openb(String bname, double bprice, int bnumber) {
		bdao.openb(bname, bprice, bnumber);	
	}
	@Override
	public void buybook(String uname, String bname,int number) {
		udao.ubuybook(uname, bname,number);
		bdao.bbuybook(bname, number);
	}
}
