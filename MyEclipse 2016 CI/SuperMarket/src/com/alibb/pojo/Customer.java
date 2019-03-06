package com.alibb.pojo;

public class Customer {
	private Integer cid;
	private String cname;
	private String cpassword;
	private String cphonenumber;
	private String caddress;
	private double cmoney;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(String cname, String cpassword, String cphonenumber, String caddress, double cmoney) {
		super();
		this.cname = cname;
		this.cpassword = cpassword;
		this.cphonenumber = cphonenumber;
		this.caddress = caddress;
		this.cmoney = cmoney;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCpassword() {
		return cpassword;
	}
	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}
	public String getCphonenumber() {
		return cphonenumber;
	}
	public void setCphonenumber(String cphonenumber) {
		this.cphonenumber = cphonenumber;
	}
	public String getCaddress() {
		return caddress;
	}
	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}
	public double getCmoney() {
		return cmoney;
	}
	public void setCmoney(double cmoney) {
		this.cmoney = cmoney;
	}
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cname=" + cname + ", cpassword=" + cpassword + ", cphonenumber="
				+ cphonenumber + ", caddress=" + caddress + ", cmoney=" + cmoney + "]";
	}
	
	

}
