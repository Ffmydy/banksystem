package com.wwl.bank.action.validateAction;


import com.opensymphony.xwork2.ActionSupport;
import com.wwl.bank.domain.UserInfo;

@SuppressWarnings("serial")
public class RegistValidate2 extends ActionSupport {
	private UserInfo userInfo;

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

}
