package com.haut.beans;

public class Irrigation_Water_Requirement {
	private Integer water_requirement_id;
	private Integer year;
	private Integer month;
	private Double water_requirement;
	public Irrigation_Water_Requirement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Irrigation_Water_Requirement(Integer year, Integer month, Double water_requirement) {
		super();
		this.year = year;
		this.month = month;
		this.water_requirement = water_requirement;
	}
	public Integer getWater_requirement_id() {
		return water_requirement_id;
	}
	public void setWater_requirement_id(Integer water_requirement_id) {
		this.water_requirement_id = water_requirement_id;
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
	public Double getWater_requirement() {
		return water_requirement;
	}
	public void setWater_requirement(Double water_requirement) {
		this.water_requirement = water_requirement;
	}
	@Override
	public String toString() {
		return "Irrigation_Water_Requirement [year=" + year + ", month=" + month + ", water_requirement="
				+ water_requirement + "]";
	}
	
}
