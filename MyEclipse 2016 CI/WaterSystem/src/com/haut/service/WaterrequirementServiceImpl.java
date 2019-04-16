package com.haut.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.haut.beans.Irrigation_Water_Requirement;
import com.haut.beans.PageInfo;
import com.haut.beans.Water_Test_Operation;
import com.haut.dao.IWaterrequirementDao;
@Service("waterRequirementService")

public class WaterrequirementServiceImpl implements IWaterrequirementService {
	@Resource(name="IWaterrequirementDao")
	private IWaterrequirementDao dao;
	public void setDao(IWaterrequirementDao dao) {
		this.dao = dao;
	}
	@Override
	public PageInfo show_water_requirement(int pageSize, int pageNumber) {
		PageInfo pi=new PageInfo();
		pi.setPageNumber(pageNumber);
		pi.setPageSize(pageSize);
		Map<String,Object> map=new HashMap<>();
		map.put("pageStart",pageSize*(pageNumber-1));
		map.put("pageSize", pageSize);
		List<Irrigation_Water_Requirement> list = dao.show_water_requirement(map);
		System.out.println(list);
		Long total=dao.sel_waterrequirement_Count();
		pi.setCount(total);
		pi.setList(list);
		pi.setTotal(total%pageSize==0?total/pageSize:total/pageSize+1);
		return pi;
	}
	@Override
	public Irrigation_Water_Requirement check_somemonth_water_requirement(int year, int month) {
		return dao.check_somemonth_water_requirement(year,month);
	}
	@Override
	public Irrigation_Water_Requirement isempty(Irrigation_Water_Requirement irrigation_water_requirement) {
		return dao.isempty(irrigation_water_requirement);
	}
	@Override
	public void add_water_requirement(Irrigation_Water_Requirement irrigation_water_requirement) {
		dao.add_water_requirement(irrigation_water_requirement);
		
	}
	
}
