package com.haut.beans;

public class Entrusted_unit {
	private Integer unit_number;//单位编号
	private String unit_name;//单位名称
	private String unit_address;//单位地址
	private String unit_phonenumber;//单位电话
	private Integer boss_number;//单位老板编号
	
	public Entrusted_unit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Entrusted_unit(Integer unit_number, String unit_name, String unit_address, String unit_phonenumber,
			Integer boss_number) {
		super();
		this.unit_number = unit_number;
		this.unit_name = unit_name;
		this.unit_address = unit_address;
		this.unit_phonenumber = unit_phonenumber;
		this.boss_number = boss_number;
	}

	public Integer getUnit_number() {
		return unit_number;
	}

	public void setUnit_number(Integer unit_number) {
		this.unit_number = unit_number;
	}

	public String getUnit_name() {
		return unit_name;
	}

	public void setUnit_name(String unit_name) {
		this.unit_name = unit_name;
	}

	public String getUnit_address() {
		return unit_address;
	}

	public void setUnit_address(String unit_address) {
		this.unit_address = unit_address;
	}

	public String getUnit_phonenumber() {
		return unit_phonenumber;
	}

	public void setUnit_phonenumber(String unit_phonenumber) {
		this.unit_phonenumber = unit_phonenumber;
	}

	public Integer getBoss_number() {
		return boss_number;
	}

	public void setBoss_number(Integer boss_number) {
		this.boss_number = boss_number;
	}
	@Override
	public String toString() {
		return "Entrusted_unit [unit_number=" + unit_number + ", unit_name=" + unit_name + ", unit_address="
				+ unit_address + ", unit_phonenumber=" + unit_phonenumber + ", boss_number=" + boss_number + "]";
	}
}
