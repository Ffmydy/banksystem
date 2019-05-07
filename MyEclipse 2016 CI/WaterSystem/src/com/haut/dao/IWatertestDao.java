package com.haut.dao;

import java.util.List;
import java.util.Map;


import com.haut.beans.Water_Test_Operation;
import com.haut.beans.Water_Test_Report;
public interface IWatertestDao {
	List<Water_Test_Report> showitem(Map<String, Object> map);//显示所有水检项目
	Long selitemCount();//求水检项目的个数
	void deleteitem(String item_number);//删除水检项目
	void updateitem(Water_Test_Report water_test_report);//修改水检项目
	void add_operation(Water_Test_Operation water_test_operation);//增加水检项目操作(包括修改、添加和删除操作)
	Water_Test_Report check_itemnumber(String item_number);//添加水检项目时，检查项目编号是否存在
	void additem(Water_Test_Report water_test_report);//添加水检项目
	List<Water_Test_Report> show_unqualified_item(Map<String, Object> map);//水质不合格项目
	Long selunqualifieditemCount();
	List<Water_Test_Report> querybydetection_time(Map<String, Object> map);//根据水检时间查询水检项目
	Long querybydetection_timeCount(String detection_time);
	List<Water_Test_Report> querybyunit_number(Map<String, Object> map);//根据水检单位编号查询水检项目
	Long querybyunit_numberCount(String unit_number);
}
