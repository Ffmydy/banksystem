package com.haut.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.haut.beans.PageInfo;
import com.haut.beans.Water_Test_Operation;
import com.haut.dao.IManageoperationDao;
@Service("manageoperationService")
public class ManageoperationServiceImpl implements IManageoperationService {
	@Resource(name="IManageoperationDao")
	private IManageoperationDao dao;
	public void setDao(IManageoperationDao dao) {
		this.dao = dao;
	}
	@Override
	public PageInfo show_manageoperation(int pageSize, int pageNumber) {
		PageInfo pi=new PageInfo();
		pi.setPageNumber(pageNumber);
		pi.setPageSize(pageSize);
		Map<String,Object> map=new HashMap<>();
		map.put("pageStart",pageSize*(pageNumber-1));
		map.put("pageSize", pageSize);
		List<Water_Test_Operation> list = dao.show_manageoperation(map);
		System.out.println(list);
		Long total=dao.sel_operation_Count();
		pi.setCount(total);
		pi.setList(list);
		pi.setTotal(total%pageSize==0?total/pageSize:total/pageSize+1);
		return pi;
	}

}
