package com.haut.dao;

import java.util.List;
import java.util.Map;

import com.haut.beans.Irrigation_Water_Requirement;
public interface IWaterrequirementDao {
	List<Irrigation_Water_Requirement> show_water_requirement(Map<String, Object> map);
	Long sel_waterrequirement_Count();
	List<Irrigation_Water_Requirement> show_somemonth_water_requirement(Map<String, Object> map);
	Irrigation_Water_Requirement check_somemonth_water_requirement(int year, int month);
}
