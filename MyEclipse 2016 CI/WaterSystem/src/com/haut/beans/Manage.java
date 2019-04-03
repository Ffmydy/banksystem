package com.haut.beans;

public class Manage {
	private Integer manage_number;
	private String manage_phonenumber;
	private String manage_password;
	private String manage_name;
	private char manage_sex;
	private Integer manage_age;
	private String manage_photo;
	
	public Manage() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Manage(String manage_phonenumber, String manage_password, String manage_name, char manage_sex,
			Integer manage_age, String manage_photo) {
		super();
		this.manage_phonenumber = manage_phonenumber;
		this.manage_password = manage_password;
		this.manage_name = manage_name;
		this.manage_sex = manage_sex;
		this.manage_age = manage_age;
		this.manage_photo = manage_photo;
	}
	public Integer getManage_number() {
		return manage_number;
	}
	public void setManage_number(Integer manage_number) {
		this.manage_number = manage_number;
	}
	public String getManage_phonenumber() {
		return manage_phonenumber;
	}
	public void setManage_phonenumber(String manage_phonenumber) {
		this.manage_phonenumber = manage_phonenumber;
	}
	public String getManage_password() {
		return manage_password;
	}
	public void setManage_password(String manage_password) {
		this.manage_password = manage_password;
	}
	public String getManage_name() {
		return manage_name;
	}
	public void setManage_name(String manage_name) {
		this.manage_name = manage_name;
	}
	public char getManage_sex() {
		return manage_sex;
	}
	public void setManage_sex(char manage_sex) {
		this.manage_sex = manage_sex;
	}
	public Integer getManage_age() {
		return manage_age;
	}
	public void setManage_age(Integer manage_age) {
		this.manage_age = manage_age;
	}
	public String getManage_photo() {
		return manage_photo;
	}
	public void setManage_photo(String manage_photo) {
		this.manage_photo = manage_photo;
	}

	@Override
	public String toString() {
		return "manage [manage_phonenumber=" + manage_phonenumber + ", manage_password=" + manage_password
				+ ", manage_name=" + manage_name + ", manage_sex=" + manage_sex + ", manage_age=" + manage_age
				+ ", manage_photo=" + manage_photo + "]";
	}
	

}
