package com.haut.dao;

import com.haut.beans.Manage;

public interface IManageDao {
	Manage manageLogin(String phonenumber, String password);
	Manage checkphonenumber(String manage_phonenumber);
	void manageRegister(Manage manage);
}

