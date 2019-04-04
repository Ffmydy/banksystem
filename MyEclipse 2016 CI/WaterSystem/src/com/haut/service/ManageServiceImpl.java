package com.haut.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.haut.beans.Manage;
import com.haut.dao.IManageDao;
@Service("manageService")
public class ManageServiceImpl implements IManageService {
	@Resource(name="IManageDao")
	private IManageDao dao;
	public void setDao(IManageDao dao) {
		this.dao = dao;
	}
	@Override
	public Manage manageLogin(String phonenumber, String password) {
		Manage manage=dao.manageLogin(phonenumber,password);
		return manage;
	}
}
