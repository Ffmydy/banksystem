package com.alibb.service;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibb.dao.ManagerDao;
import com.alibb.pojo.Goods;
import com.alibb.pojo.Manager;
import com.alibb.pojo.PageInfo;
import com.github.pagehelper.PageHelper;


public class ManagerServiceImpl implements IManagerService {
	private ManagerDao dao;
	public void setDao(ManagerDao dao) {
		this.dao = dao;
	}
	@Override
	public Manager managerLogin(String mphonenumber, String mpassword) {
		return dao.managerLogin(mphonenumber, mpassword);		
	}
	@Override
	public void addgoods(Goods goods) {
		dao.addgoods(goods);
	}
	@Override
	public PageInfo showallgoods(int pageSize, int pageNumber) {
		PageInfo pi=new PageInfo();
		pi.setPageNumber(pageNumber);
		pi.setPageSize(pageSize);
		Map<String,Object> map=new HashMap<>();
		map.put("pageStart",pageSize*(pageNumber-1));
		map.put("pageSize", pageSize);
		List<Goods> list = dao.checkgoods(map);
		Long total=dao.selcustomerCount();
		pi.setCount(total);
		pi.setList(list);
		pi.setTotal(total%pageSize==0?total/pageSize:total/pageSize+1);
		return pi;
		
	}
	@Override
	public void deletegoods(int gid) {
	    dao.deletegoods(gid);	
	}
	@Override
	public void updategoods(Goods goods) {
		dao.updategoods(goods);
	}
	@Override
	public PageInfo showallcustomer(int pageSize, int pageNumber) {
		PageInfo pi=new PageInfo();
		pi.setPageNumber(pageNumber);
		pi.setPageSize(pageSize);
		Map<String,Object> map=new HashMap<>();
		map.put("pageStart",pageSize*(pageNumber-1));
		map.put("pageSize", pageSize);
		List<Goods> list = dao.checkcustomer(map);
		Long total=dao.selcustomerCount();
		pi.setCount(total);
		pi.setList(list);
		pi.setTotal(total%pageSize==0?total/pageSize:total/pageSize+1);
		return pi;
	}
	@Override
	public void deletecustomer(int cid) {
		dao.deletecustomer(cid);
		
	}
	@Override
	public void updatecustomer(int cid, String cpassword, String cphonenumber, String caddress) {
		dao.updatecustomer(cid,cpassword,cphonenumber,caddress);
	}
	@Override
	public Manager checkmanager(int mid) {
		return dao.checkmanager(mid);
	}
}
