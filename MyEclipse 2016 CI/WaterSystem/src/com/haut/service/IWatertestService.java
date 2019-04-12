package com.haut.service;

import com.haut.beans.PageInfo;
import com.haut.beans.Water_Test_Report;

public interface IWatertestService {
	PageInfo showitem(int pageSize, int pageNumber);
	void deleteitem(int item_number);
	void updateitem(Water_Test_Report water_test_report);
}
