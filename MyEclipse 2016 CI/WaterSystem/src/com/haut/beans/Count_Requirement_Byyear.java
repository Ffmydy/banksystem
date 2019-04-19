package com.haut.beans;

public class Count_Requirement_Byyear {
	public Integer year;
	public Double year_water_requirement;
	public Double year_average_water_requirement;
	public Count_Requirement_Byyear() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Count_Requirement_Byyear(Integer year, Double year_water_requirement,
			Double year_average_water_requirement) {
		super();
		this.year = year;
		this.year_water_requirement = year_water_requirement;
		this.year_average_water_requirement = year_average_water_requirement;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public Double getYear_water_requirement() {
		return year_water_requirement;
	}
	public void setYear_water_requirement(Double year_water_requirement) {
		this.year_water_requirement = year_water_requirement;
	}
	public Double getYear_average_water_requirement() {
		return year_average_water_requirement;
	}
	public void setYear_average_water_requirement(Double year_average_water_requirement) {
		this.year_average_water_requirement = year_average_water_requirement;
	}
	@Override
	public String toString() {
		return "Count_Requirement_Byyear [year=" + year + ", year_water_requirement=" + year_water_requirement
				+ ", year_average_water_requirement=" + year_average_water_requirement + "]";
	}
	
}
