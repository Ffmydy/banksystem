package com.dy.bank.action.validateAction;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class MoneyValidate extends ActionSupport{
	private int money;

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
}
