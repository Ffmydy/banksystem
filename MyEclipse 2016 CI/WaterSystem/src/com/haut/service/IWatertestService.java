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
}
