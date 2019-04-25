package com.haut.service;

import com.haut.beans.Manage;

public interface IManageService {
	Manage manageLogin(String phonenumber, String password);

	Manage checkphonenumber(String manage_phonenumber);

	void manageRegister(Manage manage);

	void alterpassword(String manage_phonenumber, String newpassword);

	
}
