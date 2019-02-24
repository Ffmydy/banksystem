package com.alibb.pojo;

public class Book {
	private Integer bid;
	private String bname;
	private double bprice;
	private Integer number;
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	public Book(String bname, double bprice, Integer number) {
		super();
		this.bname = bname;
		this.bprice = bprice;
		this.number = number;
	}

	public Integer getBid() {
		return bid;
	}
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public double getBprice() {
		return bprice;
	}
	public void setBprice(double bprice) {
		this.bprice = bprice;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "Book [bid=" + bid + ", bname=" + bname + ", bprice=" + bprice + ", number=" + number + "]";
	}
	

}
