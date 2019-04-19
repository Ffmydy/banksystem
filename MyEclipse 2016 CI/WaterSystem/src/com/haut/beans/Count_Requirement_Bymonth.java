package com.haut.beans;

public class Count_Requirement_Bymonth {
	public Integer month;
	public Double month_water_requirement;
	public Double month_average_water_requirement;
	public Count_Requirement_Bymonth() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Count_Requirement_Bymonth(Integer month, Double month_water_requirement,
			Double month_average_water_requirement) {
		super();
		this.month = month;
		this.month_water_requirement = month_water_requirement;
		this.month_average_water_requirement = month_average_water_requirement;
	}
	public Integer getMonth() {
		return month;
	}
	public void setMonth(Integer month) {
		this.month = month;
	}
	public Double getMonth_water_requirement() {
		return month_water_requirement;
	}
	public void setMonth_water_requirement(Double month_water_requirement) {
		this.month_water_requirement = month_water_requirement;
	}
	public Double getMonth_average_water_requirement() {
		return month_average_water_requirement;
	}
	public void setMonth_average_water_requirement(Double month_average_water_requirement) {
		this.month_average_water_requirement = month_average_water_requirement;
	}
	@Override
	public String toString() {
		return "Count_Requirement_Bymonth [month=" + month + ", month_water_requirement=" + month_water_requirement
				+ ", month_average_water_requirement=" + month_average_water_requirement + "]";
	}
	

}
