package com.alibb.service;

import com.alibb.pojo.Goods;
import com.alibb.pojo.Manager;
import com.alibb.pojo.PageInfo;

public interface IManagerService {
	Manager managerLogin(String mphonenumber,String mpassword);
	void addgoods(Goods goods);
	PageInfo showallgoods(int pageSize,int pageNumber);
	void deletegoods(int gid);
	void updategoods(Goods goods);
	PageInfo showallcustomer(int pageSize, int pageNumber);
	void deletecustomer(int cid);
	void updatecustomer(int cid, String cpassword, String cphonenumber, String caddress);
	Manager checkmanager(int mid);
	void updatemanager(Manager manager);
}
