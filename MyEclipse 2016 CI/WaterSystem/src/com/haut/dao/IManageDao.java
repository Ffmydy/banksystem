package com.haut.dao;

import com.haut.beans.Manage;

public interface IManageDao {
	Manage manageLogin(String phonenumber, String password);
}
