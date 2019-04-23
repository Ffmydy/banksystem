package com.haut.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.haut.beans.Boss;
import com.haut.beans.PageInfo;
import com.haut.dao.IBossDao;
@Service("bossService")
public class BossServiceImpl implements IBossService {
	@Resource(name="IBossDao")
	private IBossDao dao;
	public void setDao(IBossDao dao) {
		this.dao = dao;
	}
	@Override
	public PageInfo showboss(int pageSize, int pageNumber) {
		PageInfo pi=new PageInfo();
		pi.setPageNumber(pageNumber);
		pi.setPageSize(pageSize);
		Map<String,Object> map=new HashMap<>();
		map.put("pageStart",pageSize*(pageNumber-1));
		map.put("pageSize", pageSize);
		List<Boss> list = dao.showboss(map);
		System.out.println(list);
		Long total=dao.selbossCount();
		pi.setCount(total);
		pi.setList(list);
		pi.setTotal(total%pageSize==0?total/pageSize:total/pageSize+1);
		return pi;
	}
	@Override
	public Boss check_current_boss(String boss_number) {
		return dao.check_current_boss(boss_number);
	}

}
