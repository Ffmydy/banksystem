package com.dy.bank.service;

import java.sql.SQLException;
import java.util.List;

import com.dy.bank.domain.UserInfo;
import com.dy.bank.persistence.UserDAO;
import com.dy.bank.persistence.UserDAOImpl;


public class UserFacadeImpl implements UserFacade {

	private UserDAO userDAO;
	
	public UserFacadeImpl() {
		userDAO = new UserDAOImpl();
	}

	public void deleteUserInfo(String userNO) throws SQLException {
		userDAO.deleteUserInfo(userNO);
	}

	public boolean login(UserInfo user) throws SQLException {
		return userDAO.login(user);
	}
	
	public boolean Manlogin(UserInfo user) throws SQLException {
		return userDAO.Manlogin(user);
	}

	public void registService(UserInfo user) throws SQLException {
		userDAO.registService(user);
	}

	public UserInfo selectUser(String userNO) throws SQLException {
		return userDAO.selectUser(userNO);
	}

	public void updateUserInfo(UserInfo user, String userNO)
			throws SQLException {
		userDAO.updateUserInfo(user, userNO);
	}
	
	public List<UserInfo> queryByPage (int pageSize, int pageNow)
			throws Exception{
		return userDAO.queryByPage(pageSize, pageNow);
	}

	public void deleteUserInfo2(String userNO) throws SQLException {
		userDAO.deleteUserInfo2(userNO);
		
	}

	@Override
	public void updateUserInfo2(UserInfo user, String userNO)
			throws SQLException {
		userDAO.updateUserInfo2(user, userNO);		
	}

	@Override
	public void addUserInfo(UserInfo user) throws SQLException {
		userDAO.addUserInfo(user);
		
	}

	@Override
	public void ManRegService(UserInfo user) throws SQLException {
		userDAO.ManRegService(user);
		
	}

	@Override
	public void changePass(UserInfo user, String userNO,String newpasswd2)
			throws SQLException {
		userDAO.changePass(user, userNO,newpasswd2);
		
	}

	@Override
	public void updateManUserInfo(UserInfo user, String userNO)
			throws SQLException {
		userDAO.updateManUserInfo(user, userNO);
		
	}
	
	public UserInfo selectManUser(String userNO) throws SQLException {
		return userDAO.selectManUser(userNO);
	}
}
