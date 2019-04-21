package com.haut.service;

import com.haut.beans.PageInfo;
import com.haut.beans.Reservoir_Water_Evaporation;

public interface IWaterevaporationService {
	PageInfo show_water_evaporation(int pageSize, int pageNumber);
	Reservoir_Water_Evaporation isempty(Reservoir_Water_Evaporation reservoir_water_evaporation);
	void add_water_evaporation(Reservoir_Water_Evaporation reservoir_water_evaporation);
	Reservoir_Water_Evaporation check_somemonth_water_evaporation(int year, int month);
}
