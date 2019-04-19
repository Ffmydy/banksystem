package com.haut.dao;

import java.util.List;
import java.util.Map;

import com.haut.beans.Reservoir_Water_Evaporation;

public interface IWaterevaporationDao {
	List<Reservoir_Water_Evaporation> show_water_evaporation(Map<String, Object> map);
	Long sel_waterevaporation_Count();
}
