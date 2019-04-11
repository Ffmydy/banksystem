package com.haut.beans;
import java.util.Date;


public class Water_Test_Report {
	private Integer item_number;//水检项目编号
	private String item_name;
	private Double item_concentration;//项目元素浓度
	private Integer water_level;//水质级别
	private Date time;
	private Integer unit_number;//项目负责单位编号
	public Water_Test_Report() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Water_Test_Report(Integer item_number, String item_name, Double item_concentration, Integer water_level,
			Date time, Integer unit_number) {
		super();
		this.item_number = item_number;
		this.item_name = item_name;
		this.item_concentration = item_concentration;
		this.water_level = water_level;
		this.time = time;
		this.unit_number = unit_number;
	}

	public Integer getItem_number() {
		return item_number;
	}

	public void setItem_number(Integer item_number) {
		this.item_number = item_number;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public Double getItem_concentration() {
		return item_concentration;
	}

	public void setItem_concentration(Double item_concentration) {
		this.item_concentration = item_concentration;
	}

	public Integer getWater_level() {
		return water_level;
	}

	public void setWater_level(Integer water_level) {
		this.water_level = water_level;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	public Integer getUnit_number() {
		return unit_number;
	}
	public void setUnit_number(Integer unit_number) {
		this.unit_number = unit_number;
	}
	@Override
	public String toString() {
		return "Water_Test_Report [item_number=" + item_number + ", item_name=" + item_name + ", item_concentration="
				+ item_concentration + ", water_level=" + water_level + ", time=" + time + ", unit_number="
				+ unit_number + "]";
	}
	
	
}
