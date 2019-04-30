package com.haut.dao;

import com.haut.beans.Manage;

public interface IManageDao {
	Manage manageLogin(String phonenumber, String password);//登录
	Manage checkphonenumber(String manage_phonenumber);//查询账号是否存在
	void manageRegister(Manage manage);//注册
	void alterpassword(String manage_phonenumber, String newpassword);//修改个人登录密码
	void alterphonenumber(String oldphonenumber, String newphonenumber);//更换手机号
	void logout(String manage_phonenumber);//注销账号
}

