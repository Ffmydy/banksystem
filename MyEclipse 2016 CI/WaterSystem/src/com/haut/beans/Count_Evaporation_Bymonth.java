package com.haut.beans;

public class Count_Evaporation_Bymonth {
	private Integer month;
	private Double month_water_evaporation;
	private Double month_average_water_evaporation;
	public Count_Evaporation_Bymonth() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Count_Evaporation_Bymonth(Integer month, Double month_water_evaporation,
			Double month_average_water_evaporation) {
		super();
		this.month = month;
		this.month_water_evaporation = month_water_evaporation;
		this.month_average_water_evaporation = month_average_water_evaporation;
	}
	public Integer getMonth() {
		return month;
	}
	public void setMonth(Integer month) {
		this.month = month;
	}
	public Double getMonth_water_evaporation() {
		return month_water_evaporation;
	}
	public void setMonth_water_evaporation(Double month_water_evaporation) {
		this.month_water_evaporation = month_water_evaporation;
	}
	public Double getMonth_average_water_evaporation() {
		return month_average_water_evaporation;
	}
	public void setMonth_average_water_evaporation(Double month_average_water_evaporation) {
		this.month_average_water_evaporation = month_average_water_evaporation;
	}
	@Override
	public String toString() {
		return "Count_Evaporation_Bymonth [month=" + month + ", month_water_evaporation=" + month_water_evaporation
				+ ", month_average_water_evaporation=" + month_average_water_evaporation + "]";
	}
	

}
