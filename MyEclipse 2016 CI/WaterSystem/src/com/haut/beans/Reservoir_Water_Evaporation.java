package com.haut.beans;

public class Reservoir_Water_Evaporation {
	private Integer id;
	private Integer year;
	private Integer month;
	private Double water_evaporation;
	public Reservoir_Water_Evaporation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Reservoir_Water_Evaporation(Integer year, Integer month, Double water_evaporation) {
		super();
		this.year = year;
		this.month = month;
		this.water_evaporation = water_evaporation;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public Integer getMonth() {
		return month;
	}
	public void setMonth(Integer month) {
		this.month = month;
	}
	public Double getWater_evaporation() {
		return water_evaporation;
	}
	public void setWater_evaporation(Double water_evaporation) {
		this.water_evaporation = water_evaporation;
	}
	@Override
	public String toString() {
		return "Reservoir_Water_Evaporation [id=" + id + ", year=" + year + ", month=" + month + ", water_evaporation="
				+ water_evaporation + "]";
	}
	

}
