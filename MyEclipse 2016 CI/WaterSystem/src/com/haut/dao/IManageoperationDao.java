package com.haut.dao;

import java.util.List;
import java.util.Map;

import com.haut.beans.Water_Test_Operation;
public interface IManageoperationDao {
	List<Water_Test_Operation> show_manageoperation(Map<String, Object> map);//显示操作列表
	Long sel_operation_Count();
	List<Water_Test_Operation> queryoperationbyoperation_managename(Map<String, Object> map);//根据姓名查询水检操作表
	Long queryoperationbyoperation_managenameCount(String operation_managename);
}
