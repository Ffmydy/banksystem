package com.haut.service;


import com.haut.beans.PageInfo;
import com.haut.beans.Water_Test_Operation;
import com.haut.beans.Water_Test_Report;

public interface IWatertestService {
	PageInfo showitem(int pageSize, int pageNumber);
	void deleteitem(String item_number, Water_Test_Operation water_test_operation);
	void updateitem(Water_Test_Report water_test_report, Water_Test_Operation water_test_operation);
	void additem(Water_Test_Report water_test_report, Water_Test_Operation water_test_operation);
	Water_Test_Report check_itemnumber(String item_number);
	PageInfo show_unqualified_item(int pageSize, int pageNumber);
	PageInfo querybydetection_time(int pageSize, int pageNumber, String detection_time);
	PageInfo querybyunit_number(int pageSize, int pageNumber, String unit_number);
	PageInfo querybywater_level(int pageSize, int pageNumber, Integer water_level);
	Water_Test_Report queryunqualifiedbyitem_number(String item_number);
	PageInfo queryunqualifiedbydetection_time(int pageSize, int pageNumber, String detection_time);
	PageInfo queryunqualifiedbyunit_number(int pageSize, int pageNumber, String unit_number);
}
