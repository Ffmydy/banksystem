package com.haut.dao;

import java.util.List;
import java.util.Map;

import com.haut.beans.Count_Requirement_Bymonth;
import com.haut.beans.Count_Requirement_Byyear;
import com.haut.beans.Irrigation_Water_Requirement;
public interface IWaterrequirementDao {
	List<Irrigation_Water_Requirement> show_water_requirement(Map<String, Object> map);
	Long sel_waterrequirement_Count();
	List<Irrigation_Water_Requirement> show_somemonth_water_requirement(Map<String, Object> map);
	Irrigation_Water_Requirement check_somemonth_water_requirement(int year, int month);
	Irrigation_Water_Requirement isempty(Irrigation_Water_Requirement irrigation_water_requirement);
	void add_water_requirement(Irrigation_Water_Requirement irrigation_water_requirement);
	Count_Requirement_Bymonth count_requirement_bymonth(int month);
	Count_Requirement_Byyear count_requirement_byyear(int year);
	List<Irrigation_Water_Requirement> check_someyear_allmonthrequirement(Integer year);
}
