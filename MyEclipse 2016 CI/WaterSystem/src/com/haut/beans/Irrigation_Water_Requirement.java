package com.haut.beans;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Irrigation_Water_Requirement {
	private Integer water_requirement_id;
	@NotNull(message="年份不能为空")
	private Integer year;
	@NotNull(message="月份不能为空")
	@Min(value=1,message="月份至少为1")
	@Max(value=12,message="月份不能超过12")
	private Integer month;
	@NotNull(message="水需量不能为空")
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
