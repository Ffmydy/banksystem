package com.haut.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.haut.beans.Manage;
import com.haut.dao.IManageDao;
import com.haut.util.MD5Util;
@Service("manageService")
public class ManageServiceImpl implements IManageService {
	@Resource(name="IManageDao")
	private IManageDao dao;
	public void setDao(IManageDao dao) {
		this.dao = dao;
	}
	@Override
	public Manage manageLogin(String phonenumber, String password) {
		//Md5登录
		String md5Password=MD5Util.MD5EncodeUtf8(password);
		Manage manage=dao.manageLogin(phonenumber,md5Password);
		return manage;
	}
	@Override
	public Manage checkphonenumber(String manage_phonenumber) {
		Manage manage=dao.checkphonenumber(manage_phonenumber);
		return manage;
	}
	@Override
	public void manageRegister(Manage manage) {
		//Md5加密
		manage.setManage_password(MD5Util.MD5EncodeUtf8(manage.getManage_password()));
		dao.manageRegister(manage);
	}
	@Override
	public void alterpassword(String manage_phonenumber, String newpassword) {
		//修改后的新密码，md5加密
		String newpasswordmd5=MD5Util.MD5EncodeUtf8(newpassword);
		dao.alterpassword(manage_phonenumber,newpasswordmd5);
		
	}
	@Override
	public void alterphonenumber(String oldphonenumber, String newphonenumber) {
		dao.alterphonenumber(oldphonenumber,newphonenumber);
	}
}
