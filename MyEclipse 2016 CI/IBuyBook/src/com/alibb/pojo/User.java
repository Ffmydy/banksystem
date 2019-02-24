package com.alibb.pojo;

public class User {
	private Integer uid;
	private String uname;
	private double money;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String uname, double money) {
		super();
		this.uname = uname;
		this.money = money;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", money=" + money + "]";
	}
	

}
