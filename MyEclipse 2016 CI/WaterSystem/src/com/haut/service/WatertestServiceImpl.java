package com.haut.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


import com.haut.beans.PageInfo;
import com.haut.beans.Water_Test_Report;
import com.haut.dao.IWatertestDao;
@Service("watertestService")
public class WatertestServiceImpl implements IWatertestService {
	@Resource(name="IWatertestDao")
	private IWatertestDao dao;
	public void setDao(IWatertestDao dao) {
		this.dao = dao;
	}
	@Override
	public PageInfo showitem(int pageSize, int pageNumber) {
		PageInfo pi=new PageInfo();
		pi.setPageNumber(pageNumber);
		pi.setPageSize(pageSize);
		Map<String,Object> map=new HashMap<>();
		map.put("pageStart",pageSize*(pageNumber-1));
		map.put("pageSize", pageSize);
		List<Water_Test_Report> list = dao.showitem(map);
		Long total=dao.selitemCount();
		pi.setCount(total);
		pi.setList(list);
		pi.setTotal(total%pageSize==0?total/pageSize:total/pageSize+1);
		return pi;
	}
}
