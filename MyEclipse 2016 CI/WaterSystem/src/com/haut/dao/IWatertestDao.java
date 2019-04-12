package com.haut.dao;

import java.util.List;
import java.util.Map;

import com.haut.beans.Water_Test_Report;
public interface IWatertestDao {
	List<Water_Test_Report> showitem(Map<String, Object> map);//显示所有水检项目
	Long selitemCount();//求水检项目的个数
	void deleteitem(int item_number);//删除水检项目
	void updateitem(Water_Test_Report water_test_report);
}
