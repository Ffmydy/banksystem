package com.haut.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.haut.beans.Count_Evaporation_Bymonth;
import com.haut.beans.Count_Evaporation_Byyear;
import com.haut.beans.PageInfo;
import com.haut.beans.Reservoir_Water_Evaporation;
import com.haut.dao.IWaterevaporationDao;

@Service("waterEvaporationService")
public class WaterevaporationServiceImpl implements IWaterevaporationService {
	@Resource(name = "IWaterevaporationDao")
	private IWaterevaporationDao dao;
	public void setDao(IWaterevaporationDao dao) {
		this.dao = dao;
	}

	@Override
	public PageInfo show_water_evaporation(int pageSize, int pageNumber) {
		PageInfo pi=new PageInfo();
		pi.setPageNumber(pageNumber);
		pi.setPageSize(pageSize);
		Map<String,Object> map=new HashMap<>();
		map.put("pageStart",pageSize*(pageNumber-1));
		map.put("pageSize", pageSize);
		List<Reservoir_Water_Evaporation> list = dao.show_water_evaporation(map);
		System.out.println(list);
		Long total=dao.sel_waterevaporation_Count();
		pi.setCount(total);
		pi.setList(list);
		pi.setTotal(total%pageSize==0?total/pageSize:total/pageSize+1);
		return pi;
	}

	@Override
	public Reservoir_Water_Evaporation isempty(Reservoir_Water_Evaporation reservoir_water_evaporation) {
		return dao.isempty(reservoir_water_evaporation);
	}
	@Override
	public void add_water_evaporation(Reservoir_Water_Evaporation reservoir_water_evaporation) {
		dao.add_water_evaporation(reservoir_water_evaporation);
	}

	@Override
	public Reservoir_Water_Evaporation check_somemonth_water_evaporation(int year, int month) {
		 return dao.check_somemonth_water_evaporation(year,month);
		
	}

	@Override
	public Count_Evaporation_Bymonth count_evaporation_bymonth(int month) {
		return dao.count_evaporation_bymonth(month);
	}

	@Override
	public Count_Evaporation_Byyear count_evaporation_byyear(int year) {
		return dao.count_evaporation_byyear(year);
	}

	@Override
	public List<Reservoir_Water_Evaporation> check_someyear_allmonth_evaporation(Integer year) {
		return dao.check_someyear_allmonth_evaporation(year);
	}

}
