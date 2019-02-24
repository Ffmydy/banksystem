package com.dy.bank.service;

import java.sql.SQLException;
import java.util.List;

import com.dy.bank.domain.UserInfo;


public interface UserFacade {
	
	/**
	 * ��ͨ�û���¼ҵ��
	 * 
	 * @param user
	 *            ��¼��Ϣ����
	 * @return ��¼�ɹ���־
	 */
	boolean login(UserInfo user) throws SQLException;
	
	/**
	 * ����Ա��¼ҵ��
	 * 
	 * @param user
	 *            ��¼��Ϣ����
	 * @return ��¼�ɹ���־
	 */
	boolean Manlogin(UserInfo user) throws SQLException;

	/**
	 * ��ͨ�û�ע��ҵ��
	 * 
	 * @param user
	 *            ע����Ϣ����
	 */
	void registService(UserInfo user) throws SQLException;
	
	/**
	 * ����Աע��ҵ��
	 * 
	 * @param user
	 *            ע����Ϣ����
	 */
	void ManRegService(UserInfo user) throws SQLException;

	/**
	 * ��ѯ�����ʻ���Ϣ
	 * 
	 * @param userNO
	 *            ��ǰ��¼�û��ʺ�
	 * @return
	 */
	UserInfo selectUser(String userNO) throws SQLException;

	/**
	 * �޸ĸ����ʻ���Ϣ
	 * 
	 * @param user
	 * @param userNO
	 */
	void updateUserInfo(UserInfo user, String userNO) throws SQLException;

	/**
	 * ע�������ʻ�
	 * 
	 * @param userNO
	 */
	void deleteUserInfo(String userNO) throws SQLException;
	
	/**
	 * ����Ա��ѯ�û��б�
	 * 
	 * @param pageSize
	 * @param pageNow
	 * @throws Exception 
	 */
	List<UserInfo> queryByPage (int pageSize, int pageNow) throws SQLException, Exception;
	
	/**
	 * ����Աɾ����ͨ�û�
	 * @param userNO
	 * @throws SQLException
	 */
	void deleteUserInfo2(String userNO) throws SQLException;
	
	/**
	 * ����Ա�޸���ͨ�û��ʻ���Ϣ
	 * 
	 * @param user
	 * @param userNO
	 */
	void updateUserInfo2(UserInfo user, String userNO) throws SQLException;
	/**
	 * ����û���Ϣ
	 * @param user
	 * @throws SQLException
	 */
	void addUserInfo(UserInfo user) throws SQLException;
	/**
	 * ��������
	 * @param user
	 * @param userNO
	 * @throws SQLException
	 */
	void changePass(UserInfo user, String userNO,String newpasswd2) throws SQLException;
	/**
	 * �޸Ĺ���Ա�ʻ���Ϣ
	 * 
	 * @param user
	 * @param userNO
	 */
	void updateManUserInfo(UserInfo user, String userNO) throws SQLException;
	/**
	 * ��ѯ����Ա�ʻ���Ϣ
	 * 
	 * @param userNO
	 *            ��ǰ��¼�û��ʺ�
	 * @return
	 */
	UserInfo selectManUser(String userNO) throws SQLException;
}
