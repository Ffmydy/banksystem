package com.haut.dao;

import java.util.List;
import java.util.Map;

import com.haut.beans.Water_Test_Operation;
public interface IManageoperationDao {
	List<Water_Test_Operation> show_manageoperation(Map<String, Object> map);
	Long sel_operation_Count();
}
