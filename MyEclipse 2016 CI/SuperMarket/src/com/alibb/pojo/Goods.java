package com.alibb.pojo;

public class Goods {
	private Integer gid;
	private String gname;
	private double gprice;
	private Integer gnumber;
	public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Goods(String gname, double gprice, Integer gnumber) {
		super();
		this.gname = gname;
		this.gprice = gprice;
		this.gnumber = gnumber;
	}

	public Integer getGid() {
		return gid;
	}
	public void setGid(Integer gid) {
		this.gid = gid;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public double getGprice() {
		return gprice;
	}
	public void setGprice(double gprice) {
		this.gprice = gprice;
	}
	public Integer getGnumber() {
		return gnumber;
	}
	public void setGnumber(Integer gnumber) {
		this.gnumber = gnumber;
	}
	@Override
	public String toString() {
		return "Goods [gid=" + gid + ", gname=" + gname + ", gprice=" + gprice + ", gnumber=" + gnumber + "]";
	}
	
	
	

}
