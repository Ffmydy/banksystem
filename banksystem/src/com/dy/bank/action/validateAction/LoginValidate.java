package com.dy.bank.action.validateAction;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class LoginValidate extends ActionSupport{
	private String userNO;

	private String password;
	
	private String rand;

	public String getRand() {
		return rand;
	}

	public void setRand(String rand) {
		this.rand = rand;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserNO() {
		return userNO;
	}

	public void setUserNO(String userNO) {
		this.userNO = userNO;
	}

}
