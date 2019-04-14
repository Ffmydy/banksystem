package com.haut.service;

import com.haut.beans.Irrigation_Water_Requirement;
import com.haut.beans.PageInfo;

public interface IWaterrequirementService {
	PageInfo show_water_requirement(int pageSize, int pageNumber);
	Irrigation_Water_Requirement check_somemonth_water_requirement(int year, int month);
}
