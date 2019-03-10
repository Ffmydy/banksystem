package com.alibb.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibb.pojo.Goods;
import com.alibb.pojo.Manager;

public interface ManagerDao {
	Manager managerLogin(String mphonenumber,String mpassword);
	void addgoods(Goods goods);
	List<Goods> checkgoods(Map<String, Object> map);
	Long selgoodsCount();
	void deletegoods(int gid);
	void updategoods(Goods goods);
	List<Goods> checkcustomer(Map<String, Object> map);
	Long selcustomerCount();
	void deletecustomer(int cid);
	void updatecustomer(int cid, String cpassword, String cphonenumber, String caddress);
	Manager checkmanager(int mid);
	void updatemanager(Manager manager);
}
