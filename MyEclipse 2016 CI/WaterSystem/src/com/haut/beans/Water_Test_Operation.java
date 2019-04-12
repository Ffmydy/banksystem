package com.haut.beans;

public class Water_Test_Operation {
	private Integer operation_id;
	private String operation_managename;
	private String operation_itemnumber;
	private String operation_itemname;
	private String operation_time;
	private String operation_name;
	public Water_Test_Operation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Water_Test_Operation(String operation_managename, String operation_itemnumber, String operation_itemname,
			String operation_time, String operation_name) {
		super();
		this.operation_managename = operation_managename;
		this.operation_itemnumber = operation_itemnumber;
		this.operation_itemname = operation_itemname;
		this.operation_time = operation_time;
		this.operation_name = operation_name;
	}
	public Integer getOperation_id() {
		return operation_id;
	}
	public void setOperation_id(Integer operation_id) {
		this.operation_id = operation_id;
	}
	public String getOperation_managename() {
		return operation_managename;
	}
	public void setOperation_managename(String operation_managename) {
		this.operation_managename = operation_managename;
	}
	public String getOperation_itemnumber() {
		return operation_itemnumber;
	}
	public void setOperation_itemnumber(String operation_itemnumber) {
		this.operation_itemnumber = operation_itemnumber;
	}
	public String getOperation_itemname() {
		return operation_itemname;
	}
	public void setOperation_itemname(String operation_itemname) {
		this.operation_itemname = operation_itemname;
	}
	public String getOperation_time() {
		return operation_time;
	}
	public void setOperation_time(String operation_time) {
		this.operation_time = operation_time;
	}
	public String getOperation_name() {
		return operation_name;
	}
	public void setOperation_name(String operation_name) {
		this.operation_name = operation_name;
	}
	@Override
	public String toString() {
		return "Water_Test_Operation [operation_managename=" + operation_managename + ", operation_itemnumber="
				+ operation_itemnumber + ", operation_itemname=" + operation_itemname + ", operation_time="
				+ operation_time + ", operation_name=" + operation_name + "]";
	}
	
}
