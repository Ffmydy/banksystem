package com.haut.beans;

public class Count_Evaporation_Byyear {
	private Integer year;
	private Double year_water_evaporation;
	private Double year_average_water_evaporation;
	public Count_Evaporation_Byyear() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Count_Evaporation_Byyear(Integer year, Double year_water_evaporation,
			Double year_average_water_evaporation) {
		super();
		this.year = year;
		this.year_water_evaporation = year_water_evaporation;
		this.year_average_water_evaporation = year_average_water_evaporation;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public Double getYear_water_evaporation() {
		return year_water_evaporation;
	}
	public void setYear_water_evaporation(Double year_water_evaporation) {
		this.year_water_evaporation = year_water_evaporation;
	}
	public Double getYear_average_water_evaporation() {
		return year_average_water_evaporation;
	}
	public void setYear_average_water_evaporation(Double year_average_water_evaporation) {
		this.year_average_water_evaporation = year_average_water_evaporation;
	}
	@Override
	public String toString() {
		return "Count_Evaporation_Byyear [year=" + year + ", year_water_evaporation=" + year_water_evaporation
				+ ", year_average_water_evaporation=" + year_average_water_evaporation + "]";
	}
}
