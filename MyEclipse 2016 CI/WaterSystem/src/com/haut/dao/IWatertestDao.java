package com.haut.dao;

import java.util.List;
import java.util.Map;

import com.haut.beans.Water_Test_Report;
public interface IWatertestDao {
	List<Water_Test_Report> showitem(Map<String, Object> map);
	Long selitemCount();
}
