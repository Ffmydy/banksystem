package com.alibb.pojo;

public class Manager {
	private Integer mid;
	private String mname;
	private String mpassword;
	private String mphonenumber;
	
	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Manager(String mname, String mpassword, String mphonenumber) {
		super();
		this.mname = mname;
		this.mpassword = mpassword;
		this.mphonenumber = mphonenumber;
	}

	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMpassword() {
		return mpassword;
	}
	public void setMpassword(String mpassword) {
		this.mpassword = mpassword;
	}
	public String getMphonenumber() {
		return mphonenumber;
	}
	public void setMphonenumber(String mphonenumber) {
		this.mphonenumber = mphonenumber;
	}
	@Override
	public String toString() {
		return "Manager [mid=" + mid + ", mname=" + mname + ", mpassword=" + mpassword + ", mphonenumber="
				+ mphonenumber + "]";
	}
	

}
