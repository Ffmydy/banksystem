package com.haut.beans;

public class EchartsEntity {
	private String month;
    private double evapCapacity;
	public EchartsEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EchartsEntity(String month, double evapCapacity) {
		super();
		this.month = month;
		this.evapCapacity = evapCapacity;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public double getEvapCapacity() {
		return evapCapacity;
	}
	public void setEvapCapacity(double evapCapacity) {
		this.evapCapacity = evapCapacity;
	}
    
    
}
