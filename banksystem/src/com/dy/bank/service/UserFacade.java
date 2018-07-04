package com.dy.bank.service;

import java.sql.SQLException;
import java.util.List;

import com.dy.bank.domain.UserInfo;


public interface UserFacade {
	
	/**
	 * 普通用户登录业务
	 * 
	 * @param user
	 *            登录信息对象
	 * @return 登录成功标志
	 */
	boolean login(UserInfo user) throws SQLException;
	
	/**
	 * 管理员登录业务
	 * 
	 * @param user
	 *            登录信息对象
	 * @return 登录成功标志
	 */
	boolean Manlogin(UserInfo user) throws SQLException;

	/**
	 * 普通用户注册业务
	 * 
	 * @param user
	 *            注册信息对象
	 */
	void registService(UserInfo user) throws SQLException;
	
	/**
	 * 管理员注册业务
	 * 
	 * @param user
	 *            注册信息对象
	 */
	void ManRegService(UserInfo user) throws SQLException;

	/**
	 * 查询个人帐户信息
	 * 
	 * @param userNO
	 *            当前登录用户帐号
	 * @return
	 */
	UserInfo selectUser(String userNO) throws SQLException;

	/**
	 * 修改个人帐户信息
	 * 
	 * @param user
	 * @param userNO
	 */
	void updateUserInfo(UserInfo user, String userNO) throws SQLException;

	/**
	 * 注销个人帐户
	 * 
	 * @param userNO
	 */
	void deleteUserInfo(String userNO) throws SQLException;
	
	/**
	 * 管理员查询用户列表
	 * 
	 * @param pageSize
	 * @param pageNow
	 * @throws Exception 
	 */
	List<UserInfo> queryByPage (int pageSize, int pageNow) throws SQLException, Exception;
	
	/**
	 * 管理员删除普通用户
	 * @param userNO
	 * @throws SQLException
	 */
	void deleteUserInfo2(String userNO) throws SQLException;
	
	/**
	 * 管理员修改普通用户帐户信息
	 * 
	 * @param user
	 * @param userNO
	 */
	void updateUserInfo2(UserInfo user, String userNO) throws SQLException;
	/**
	 * 添加用户信息
	 * @param user
	 * @throws SQLException
	 */
	void addUserInfo(UserInfo user) throws SQLException;
	/**
	 * 更改密码
	 * @param user
	 * @param userNO
	 * @throws SQLException
	 */
	void changePass(UserInfo user, String userNO,String newpasswd2) throws SQLException;
	/**
	 * 修改管理员帐户信息
	 * 
	 * @param user
	 * @param userNO
	 */
	void updateManUserInfo(UserInfo user, String userNO) throws SQLException;
	/**
	 * 查询管理员帐户信息
	 * 
	 * @param userNO
	 *            当前登录用户帐号
	 * @return
	 */
	UserInfo selectManUser(String userNO) throws SQLException;
}
