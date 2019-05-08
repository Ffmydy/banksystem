package com.haut.service;

import java.util.List;

import com.haut.beans.Count_Evaporation_Bymonth;
import com.haut.beans.Count_Evaporation_Byyear;
import com.haut.beans.PageInfo;
import com.haut.beans.Reservoir_Water_Evaporation;

public interface IWaterevaporationService {
	PageInfo show_water_evaporation(int pageSize, int pageNumber);
	Reservoir_Water_Evaporation isempty(Reservoir_Water_Evaporation reservoir_water_evaporation);
	void add_water_evaporation(Reservoir_Water_Evaporation reservoir_water_evaporation);
	Reservoir_Water_Evaporation check_somemonth_water_evaporation(int year, int month);
	Count_Evaporation_Bymonth count_evaporation_bymonth(int month);
	Count_Evaporation_Byyear count_evaporation_byyear(int year);
	List<Reservoir_Water_Evaporation> check_someyear_allmonth_evaporation(Integer year);
}
