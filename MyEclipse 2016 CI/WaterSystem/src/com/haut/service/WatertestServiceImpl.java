package com.haut.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.haut.beans.PageInfo;
import com.haut.beans.Water_Test_Operation;
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
		//System.out.println(list);
		Long total=dao.selitemCount();
		pi.setCount(total);
		pi.setList(list);
		pi.setTotal(total%pageSize==0?total/pageSize:total/pageSize+1);
		return pi;
	}
	@Override
	public void deleteitem(String item_number,Water_Test_Operation water_test_operation) {
		dao.deleteitem(item_number);
		dao.add_operation(water_test_operation);
	}
	@Override
	public void updateitem(Water_Test_Report water_test_report,Water_Test_Operation water_test_operation) {
		dao.add_operation(water_test_operation);
		dao.updateitem(water_test_report);	
	}
	@Override
	public void additem(Water_Test_Report water_test_report, Water_Test_Operation water_test_operation) {
		dao.add_operation(water_test_operation);
		dao.additem(water_test_report);
		
	}
	@Override
	public Water_Test_Report check_itemnumber(String item_number) {
		Water_Test_Report water_Test_Report =dao.check_itemnumber(item_number);
		return water_Test_Report;
	}
	@Override
	public PageInfo show_unqualified_item(int pageSize, int pageNumber) {
		PageInfo pi=new PageInfo();
		pi.setPageNumber(pageNumber);
		pi.setPageSize(pageSize);
		Map<String,Object> map=new HashMap<>();
		map.put("pageStart",pageSize*(pageNumber-1));
		map.put("pageSize", pageSize);
		List<Water_Test_Report> list = dao.show_unqualified_item(map);
		//System.out.println(list);
		Long total=dao.selunqualifieditemCount();
		pi.setCount(total);
		pi.setList(list);
		pi.setTotal(total%pageSize==0?total/pageSize:total/pageSize+1);
		return pi;
	}
	@Override
	public PageInfo querybydetection_time(int pageSize, int pageNumber, String detection_time) {
		//System.out.println(detection_time);
		PageInfo pi=new PageInfo();
		pi.setPageNumber(pageNumber);
		pi.setPageSize(pageSize);
		Map<String,Object> map=new HashMap<>();
		map.put("pageStart",pageSize*(pageNumber-1));
		map.put("pageSize", pageSize);
		map.put("detection_time", detection_time);
		List<Water_Test_Report> list = dao.querybydetection_time(map);
		//System.out.println(list);
		Long total=dao.querybydetection_timeCount(detection_time);
		//System.out.println(total);
		pi.setCount(total);
		pi.setList(list);
		pi.setTotal(total%pageSize==0?total/pageSize:total/pageSize+1);
		return pi;
	}
	@Override
	public PageInfo querybyunit_number(int pageSize, int pageNumber, String unit_number) {
		PageInfo pi=new PageInfo();
		pi.setPageNumber(pageNumber);
		pi.setPageSize(pageSize);
		Map<String,Object> map=new HashMap<>();
		map.put("pageStart",pageSize*(pageNumber-1));
		map.put("pageSize", pageSize);
		map.put("unit_number", unit_number);
		List<Water_Test_Report> list = dao.querybyunit_number(map);	
		Long total=dao.querybyunit_numberCount(unit_number);
		pi.setCount(total);
		pi.setList(list);
		pi.setTotal(total%pageSize==0?total/pageSize:total/pageSize+1);
		return pi;
	}
	@Override
	public PageInfo querybywater_level(int pageSize, int pageNumber, Integer water_level) {
		PageInfo pi=new PageInfo();
		pi.setPageNumber(pageNumber);
		pi.setPageSize(pageSize);
		Map<String,Object> map=new HashMap<>();
		map.put("pageStart",pageSize*(pageNumber-1));
		map.put("pageSize", pageSize);
		map.put("water_level", water_level);
		List<Water_Test_Report> list = dao.querybywater_level(map);	
		Long total=dao.querybywater_levelCount(water_level);
		pi.setCount(total);
		pi.setList(list);
		pi.setTotal(total%pageSize==0?total/pageSize:total/pageSize+1);
		return pi;
	}
	@Override
	public Water_Test_Report queryunqualifiedbyitem_number(String item_number) {
		Water_Test_Report water_Test_Report =dao.queryunqualifiedbyitem_number(item_number);
		return water_Test_Report;
	}
	@Override
	public PageInfo queryunqualifiedbydetection_time(int pageSize, int pageNumber, String detection_time) {
		PageInfo pi=new PageInfo();
		pi.setPageNumber(pageNumber);
		pi.setPageSize(pageSize);
		Map<String,Object> map=new HashMap<>();
		map.put("pageStart",pageSize*(pageNumber-1));
		map.put("pageSize", pageSize);
		map.put("detection_time", detection_time);
		List<Water_Test_Report> list = dao.queryunqualifiedbydetection_time(map);
		//System.out.println(list);
		Long total=dao.queryunqualifiedbydetection_timeCount(detection_time);
		//System.out.println(total);
		pi.setCount(total);
		pi.setList(list);
		pi.setTotal(total%pageSize==0?total/pageSize:total/pageSize+1);
		return pi;
	}
	@Override
	public PageInfo queryunqualifiedbyunit_number(int pageSize, int pageNumber, String unit_number) {
		PageInfo pi=new PageInfo();
		pi.setPageNumber(pageNumber);
		pi.setPageSize(pageSize);
		Map<String,Object> map=new HashMap<>();
		map.put("pageStart",pageSize*(pageNumber-1));
		map.put("pageSize", pageSize);
		map.put("unit_number", unit_number);
		List<Water_Test_Report> list = dao.queryunqualifiedbyunit_number(map);	
		Long total=dao.queryunqualifiedbyunit_numberCount(unit_number);
		pi.setCount(total);
		pi.setList(list);
		pi.setTotal(total%pageSize==0?total/pageSize:total/pageSize+1);
		return pi;
	}
}
