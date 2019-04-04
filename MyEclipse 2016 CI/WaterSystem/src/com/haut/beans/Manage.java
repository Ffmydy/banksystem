package com.haut.beans;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;


public class Manage {
	@NotBlank(message="姓名不能为空")
	@Size(min=2,max=6,message="姓名长度必须在{min}-{max}之间")
	private String manage_name;
	@NotBlank(message="手机号不能为空")
	@Pattern(regexp="^1[34578]\\d{9}$",message="手机号格式不正确")
	private String manage_phonenumber;
	@NotNull(message="年龄不能为空")
	@Min(value=18,message="你还未成年，不能注册")
	@Max(value=60,message="太老了，该退休了 ")
	private Integer manage_age;
	@NotBlank(message="密码不能为空")
	@Size(min=6,max=16,message="密码长度必须在{min}-{max}之间")
	private String manage_password;
	@NotNull(message="性别不能为空")
	private char manage_sex;
	private String manage_photo;
	public Manage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Manage(String manage_name, String manage_phonenumber, Integer manage_age, String manage_password,
			char manage_sex, String manage_photo) {
		super();
		this.manage_name = manage_name;
		this.manage_phonenumber = manage_phonenumber;
		this.manage_age = manage_age;
		this.manage_password = manage_password;
		this.manage_sex = manage_sex;
		this.manage_photo = manage_photo;
	}
	public String getManage_name() {
		return manage_name;
	}
	public void setManage_name(String manage_name) {
		this.manage_name = manage_name;
	}
	public String getManage_phonenumber() {
		return manage_phonenumber;
	}
	public void setManage_phonenumber(String manage_phonenumber) {
		this.manage_phonenumber = manage_phonenumber;
	}
	public Integer getManage_age() {
		return manage_age;
	}
	public void setManage_age(Integer manage_age) {
		this.manage_age = manage_age;
	}
	public String getManage_password() {
		return manage_password;
	}
	public void setManage_password(String manage_password) {
		this.manage_password = manage_password;
	}
	public char getManage_sex() {
		return manage_sex;
	}
	public void setManage_sex(char manage_sex) {
		this.manage_sex = manage_sex;
	}
	public String getManage_photo() {
		return manage_photo;
	}
	public void setManage_photo(String manage_photo) {
		this.manage_photo = manage_photo;
	}
	@Override
	public String toString() {
		return "Manage [manage_name=" + manage_name + ", manage_phonenumber=" + manage_phonenumber + ", manage_age="
				+ manage_age + ", manage_password=" + manage_password + ", manage_sex=" + manage_sex + ", manage_photo="
				+ manage_photo + "]";
	}

}
