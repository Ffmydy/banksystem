package com.dy.bank.action.validateAction;


import com.dy.bank.domain.UserInfo;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ManagerRegistValidate extends ActionSupport {
	private UserInfo userInfo;

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

}
