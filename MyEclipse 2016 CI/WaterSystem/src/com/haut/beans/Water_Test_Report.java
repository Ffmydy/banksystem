package com.haut.beans;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;


public class Water_Test_Report {
	@NotBlank(message="项目编号不能为空")
	@Pattern(regexp="^1\\d{5}$",message="项目编号格式不正确")//项目编号的格式以1开头的六位数
	private String item_number;//水检项目编号
	@NotBlank(message="项目名字不能为空")
	private String item_name;
	@NotNull(message="成分浓度不能为空")
	private Double item_concentration;//项目元素浓度
	@NotNull(message="水质级别不能为空")
	@Min(value=1,message="级别最低为一级")
    @Max(value=5,message="级别最高为五级")
	private Integer water_level;//水质级别
	@NotBlank(message="水检时间不能为空")
	private String detection_time;
	@NotBlank(message="项目负责单位编号不能空")
	@Pattern(regexp="^2\\d{5}$",message="单位编号格式不正确")//项目负责单位编号的格式以2开头的六位数
	private String unit_number;//项目负责单位编号
	public Water_Test_Report() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Water_Test_Report(String item_number, String item_name, Double item_concentration, Integer water_level,
			String detection_time, String unit_number) {
		super();
		this.item_number = item_number;
		this.item_name = item_name;
		this.item_concentration = item_concentration;
		this.water_level = water_level;
		this.detection_time = detection_time;
		this.unit_number = unit_number;
	}
	public String getItem_number() {
		return item_number;
	}
	public void setItem_number(String item_number) {
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
	public String getDetection_time() {	
		return detection_time;
	}
	public void setDetection_time(String detection_time) {	
		this.detection_time = detection_time;
	}
	public String getUnit_number() {
		return unit_number;
	}
	public void setUnit_number(String unit_number) {
		this.unit_number = unit_number;
	}
	@Override
	public String toString() {
		return "Water_Test_Report [item_number=" + item_number + ", item_name=" + item_name + ", item_concentration="
				+ item_concentration + ", water_level=" + water_level + ", detection_time=" + detection_time
				+ ", unit_number=" + unit_number + "]";
	}
	
	
}
