package com.dy.bank.action.validateAction;

import com.dy.bank.domain.UserInfo;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ChangePassValidate extends ActionSupport{
	
	private UserInfo userInfo;
	
	private String p2;
	
	private String passwd;
	
	private String np2;

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public String getP2() {
		return p2;
	}

	public void setP2(String p2) {
		this.p2 = p2;
	}
	
	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getNp2() {
		return np2;
	}

	public void setNp2(String np2) {
		this.np2 = np2;
	}
	

}
