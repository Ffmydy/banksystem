package com.haut.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.haut.beans.Entrusted_unit;
import com.haut.beans.PageInfo;

import com.haut.dao.IEntrustedunitDao;
@Service("entrustedunitService")
public class EntrustedunitServiceImpl implements IEntrustedunitService {
	@Resource(name="IEntrustedunitDao")
	private IEntrustedunitDao dao;
	public void setDao(IEntrustedunitDao dao) {
		this.dao = dao;
	}
	@Override
	public PageInfo showunit(int pageSize, int pageNumber) {
		PageInfo pi=new PageInfo();
		pi.setPageNumber(pageNumber);
		pi.setPageSize(pageSize);
		Map<String,Object> map=new HashMap<>();
		map.put("pageStart",pageSize*(pageNumber-1));
		map.put("pageSize", pageSize);
		List<Entrusted_unit> list = dao.showunit(map);
		System.out.println(list);
		Long total=dao.selunitCount();
		pi.setCount(total);
		pi.setList(list);
		pi.setTotal(total%pageSize==0?total/pageSize:total/pageSize+1);
		return pi;
	}
	@Override
	public Entrusted_unit check_current_unit(String unit_number) {
		return dao.check_current_unit(unit_number);
	}
}
