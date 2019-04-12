package com.haut.beans;

public class Boss {
	private String boss_number;
	private String boss_name;
	private Integer boss_age;
	private char boss_sex;
	private String boss_phonenumber;
	private String boss_email;
	private String boss_phote;
	public Boss() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Boss(String boss_number, String boss_name, Integer boss_age, char boss_sex, String boss_phonenumber,
			String boss_email, String boss_phote) {
		super();
		this.boss_number = boss_number;
		this.boss_name = boss_name;
		this.boss_age = boss_age;
		this.boss_sex = boss_sex;
		this.boss_phonenumber = boss_phonenumber;
		this.boss_email = boss_email;
		this.boss_phote = boss_phote;
	}
	public String getBoss_number() {
		return boss_number;
	}
	public void setBoss_number(String boss_number) {
		this.boss_number = boss_number;
	}
	public String getBoss_name() {
		return boss_name;
	}
	public void setBoss_name(String boss_name) {
		this.boss_name = boss_name;
	}
	public Integer getBoss_age() {
		return boss_age;
	}
	public void setBoss_age(Integer boss_age) {
		this.boss_age = boss_age;
	}
	public char getBoss_sex() {
		return boss_sex;
	}
	public void setBoss_sex(char boss_sex) {
		this.boss_sex = boss_sex;
	}
	public String getBoss_phonenumber() {
		return boss_phonenumber;
	}
	public void setBoss_phonenumber(String boss_phonenumber) {
		this.boss_phonenumber = boss_phonenumber;
	}
	public String getBoss_email() {
		return boss_email;
	}
	public void setBoss_email(String boss_email) {
		this.boss_email = boss_email;
	}
	public String getBoss_phote() {
		return boss_phote;
	}
	public void setBoss_phote(String boss_phote) {
		this.boss_phote = boss_phote;
	}
	@Override
	public String toString() {
		return "Boss [boss_number=" + boss_number + ", boss_name=" + boss_name + ", boss_age=" + boss_age
				+ ", boss_sex=" + boss_sex + ", boss_phonenumber=" + boss_phonenumber + ", boss_email=" + boss_email
				+ ", boss_phote=" + boss_phote + "]";
	}
}
