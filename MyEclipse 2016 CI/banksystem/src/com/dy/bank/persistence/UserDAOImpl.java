package com.dy.bank.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dy.bank.domain.UserInfo;
import com.dy.bank.util.DBConnection;
import com.dy.bank.util.MD5;


public class UserDAOImpl implements UserDAO {

	Connection conn = null;		//��������conn
	//ִ�о�̬SQL��䣬ͨ��ͨ��Statementʵ��ʵ��
	Statement st = null;		//��������st
	private PreparedStatement pstmt ;
	private UserInfo userInfo ;
	private ResultSet rs ;
	//��ͨ�û���¼ϵͳҵ��
	public boolean login(UserInfo user) throws SQLException {
		boolean flag = false;	//����boolean���ͱ���
		MD5 md5 = new MD5();	//���ɹ�����MD5�Ķ���
		String userNO = user.getUserNO();	//��ȡ�û��˺�
		//��ȡ���������md5�������û�����
		String password = md5.getMD5ofStr(user.getPassword());
		@SuppressWarnings("unused")
		String rand = user.getRand();
		try {
			conn = DBConnection.getDBC();	//ͨ��������DBConnection��ȡ������Ϣ
			st = conn.createStatement();	//Ϊ����st��ֵ
			//����sql���
			String sql = "select userNO from userInfo where userNO='" + userNO
					+ "' and  password = '" + password + "'";
			ResultSet rs = st.executeQuery(sql);	//sql���ִ�н��
			if (rs.next()) {	//ִ�гɹ�
				flag = true;
				rs.close();
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			st.close();
			conn.close();
		}
		return flag;
	}
	//����Ա��¼ϵͳҵ��
		public boolean Manlogin(UserInfo user) throws SQLException {
			boolean flag = false;	//����boolean���ͱ���
			MD5 md5 = new MD5();	//���ɹ�����MD5�Ķ���
			String userNO = user.getUserNO();	//��ȡ�û��˺�
			//��ȡ���������md5�������û�����
			String password = md5.getMD5ofStr(user.getPassword());
			@SuppressWarnings("unused")
			String rand = user.getRand();
			try {
				conn = DBConnection.getDBC();	//ͨ��������DBConnection��ȡ������Ϣ
				st = conn.createStatement();	//Ϊ����st��ֵ
				//����sql���
				String sql = "select userNO from manuserInfo where userNO='" + userNO
						+ "' and  password = '" + password + "'";
				ResultSet rs = st.executeQuery(sql);	//sql���ִ�н��
				if (rs.next()) {	//ִ�гɹ�
					flag = true;
					rs.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				st.close();
				conn.close();
			}
			return flag;
		}
	//��ͨ�û�ע��ҵ��
	public void registService(UserInfo user) throws SQLException {
		MD5 md5 = new MD5();
		java.util.Random random=new java.util.Random();// ���������
		int id=100+random.nextInt(500);// ����100+[0,500)�����е�������ע�ⲻ����10
		long s = System.currentTimeMillis();
		String a = String.valueOf(s);
		user.setUserNO(a);
		String sql = "insert into userInfo"
				+ "(id,userName,password,userAge,idCard,userSex,tel,city,userAddress,userNO,balance,userflag) "
			//	+ "values('" + user.getUserName() + "'," + "'"
				+ "values('"+ id+ "','" + user.getUserName() + "'," + "'"
				+ md5.getMD5ofStr(user.getPassword()) + "'," + "'"
				+ user.getUserAge() + "'," + "'" + user.getIdCard() + "',"
				+ "'" + user.getUserSex() + "'," + "'" + user.getTel() + "',"
				+ "'" + user.getCity() + "'," + "'" + user.getAddress() + "' ,"
				+ "'" + user.getUserNO() + "','" + 0 + "','" + 0 + "')";
		try {
			conn = DBConnection.getDBC();
			conn.setAutoCommit(false);
			st = conn.createStatement();
			st.executeUpdate(sql);
            conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			st.close();
			conn.close();
		}
	}
	//����Աע��ҵ��
		public void ManRegService(UserInfo user) throws SQLException {
			MD5 md5 = new MD5();
			long s = System.currentTimeMillis();
			String a = String.valueOf(s);
			user.setUserNO(a);
			String sql = "insert into manuserInfo"
					+ "(userName,password,userAge,idCard,userSex,tel,city,userAddress,userNO,balance,userflag) "
					+ "values('" + user.getUserName() + "'," + "'"
					+ md5.getMD5ofStr(user.getPassword()) + "'," + "'"
					+ user.getUserAge() + "'," + "'" + user.getIdCard() + "',"
					+ "'" + user.getUserSex() + "'," + "'" + user.getTel() + "',"
					+ "'" + user.getCity() + "'," + "'" + user.getAddress() + "' ,"
					+ "'" + user.getUserNO() + "','" + 0 + "','" + 0 + "')";
			try {
				conn = DBConnection.getDBC();
				conn.setAutoCommit(false);
				st = conn.createStatement();
				st.executeUpdate(sql);
	            conn.commit();
			} catch (Exception e) {
				e.printStackTrace();
				conn.rollback();
			} finally {
				st.close();
				conn.close();
			}
		}
	//��ѯ�����ʻ���Ϣҵ��
	public UserInfo selectUser(String userNO) throws SQLException {
		ResultSet rs = null;
		UserInfo userInfo = null;
		String sql = "select * from userInfo where userNO = '" + userNO + "'";
		try {
			conn = DBConnection.getDBC();
			st = conn.createStatement();
			userInfo = new UserInfo();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				userInfo.setUserName(rs.getString("userName"));
				//�����ݿ������в�ѯ��������ΪuserName���е�ֵ����userInfo.setUserName()������
				userInfo.setUserNO(rs.getString("userNO"));
				userInfo.setUserAge(rs.getInt("userAge"));
				userInfo.setIdCard(rs.getString("idCard"));
				userInfo.setTel(rs.getString("tel"));
				userInfo.setCity(rs.getString("city"));
				userInfo.setBalance(rs.getInt("balance"));
				userInfo.setAddress(rs.getString("userAddress"));
				userInfo.setUserSex(rs.getString("userSex"));
				userInfo.setUserflag(rs.getInt("userflag"));
				return userInfo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rs.close();
			st.close();
			conn.close();
		}
		return null;
	}
	//�޸ĸ����ʻ���Ϣҵ��
	public void updateUserInfo(UserInfo user, String userNO)
			throws SQLException {
		MD5 md5 = new MD5();
		/*String sql = "update userInfo set tel ='" + user.getTel()
				+ "',password='" + md5.getMD5ofStr(user.getPassword())
				+ "',city='" + user.getCity() + "',userAddress='"
				+ user.getAddress() + "'";*/
		String sql = "update userInfo set tel ='" + user.getTel()
				+ "',city='" + user.getCity() + "',userAddress='"
				+ user.getAddress() + "'where userNO='" + userNO
				+ "'";
		try {
			conn = DBConnection.getDBC();
			conn.setAutoCommit(false);
			st = conn.createStatement();
			System.out.println(sql+"======");
			st.executeUpdate(sql);
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			st.close();
			conn.close();
		}
	}
	//ע���ʻ�ҵ��
	public void deleteUserInfo(String userNO) throws SQLException {
		String sql = "update userInfo set userflag='1' where userNO='" + userNO
				+ "'";
		try {
			conn = DBConnection.getDBC();
			conn.setAutoCommit(false);
			st = conn.createStatement();
			st.executeUpdate(sql);
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			st.close();
			conn.close();
		}
	}
	//��ҳ��ѯ
	  public List<UserInfo> queryByPage (int pageSize, int pageNow) throws Exception {
	  	List<UserInfo> list = new ArrayList<UserInfo> () ;
	  	conn = DBConnection.getDBC();
	  	int i=0;
	  	try {
	  	  if (conn !=null && pageSize>0 && pageNow>0) {
	  		if(pageNow == 1){
		  		pstmt = conn.prepareStatement(
			  		    "select top 5 id,userNO,userName,userAge,idCard,"
			  		    + "tel,city,userAddress,userSex,balance from "
			  		    + "userInfo");
	  		}else{
	  			pstmt = conn.prepareStatement(
			  		    "select top 5 id,userNO,userName,userAge,idCard,"
			  		    + "tel,city,userAddress,userSex,balance from "
			  		    + "userInfo where userNO not in "+"("+"select top "+((pageNow-1)*pageSize)+" userNO "
			  		    		+ "from userInfo order by userNO"+")"+" order by userNO");  
	  		}
	  		rs = pstmt.executeQuery () ;
	  		  while (rs.next()) {
	  			  ++i;
	  			  userInfo = new UserInfo ();
	  			  userInfo.setId (rs.getInt(1)) ;
	  			  userInfo.setUserNO (rs.getString(2)) ;
	  			  userInfo.setUserName (rs.getString(3)) ;
	  			  userInfo.setUserAge (rs.getInt(4)) ;
		  		  userInfo.setIdCard (rs.getString(5)) ;
		  		  userInfo.setTel (rs.getString(6)) ;
		  		  userInfo.setCity (rs.getString(7)) ;
		  	      userInfo.setAddress (rs.getString(8)) ;
		  		  userInfo.setUserSex (rs.getString(9)) ;
	  			  userInfo.setBalance (rs.getInt(10)) ;
	  			  list.add (userInfo) ;
	  		  }
	  	  }
	  	} catch(SQLException e) {
	  		e.printStackTrace() ;
	  	}
	  	return list ;
	  }
		//����Աɾ����ͨ�û��ʻ�ҵ��
		public void deleteUserInfo2(String userNO) throws SQLException {
			String sql = "delete from userInfo where userNO='" + userNO
					+ "'";
			try {
				conn = DBConnection.getDBC();
				conn.setAutoCommit(false);
				st = conn.createStatement();
				st.executeUpdate(sql);
				conn.commit();
			} catch (Exception e) {
				e.printStackTrace();
				conn.rollback();
			} finally {
				st.close();
				conn.close();
			}
		}
		/**
		 * ����Ա�޸���ͨ�û��˻���Ϣ
		 */
		public void updateUserInfo2(UserInfo user, String userNO)
				throws SQLException {
			MD5 md5 = new MD5();
			
			
			String sql = "update userInfo set tel ='" + user.getTel()
					//+ "',password='" + md5.getMD5ofStr(user.getPassword())
					+ "',city='" + user.getCity() + "',userAddress='"
					+ user.getAddress() + "'"+" where userNO='"+user.getUserNO()+"'";
			try {
				conn = DBConnection.getDBC();
				conn.setAutoCommit(false);
				st = conn.createStatement();
				st.executeUpdate(sql);
				conn.commit();
			} catch (Exception e) {
				e.printStackTrace();
				conn.rollback();
			} finally {
				st.close();
				conn.close();
			}
		}
		@Override
		//����Ա������û�
		
		public void addUserInfo(UserInfo user) throws SQLException {
			//user = new UserInfo();
			//MD5�����㷨
			MD5 md5 = new MD5();
			java.util.Random random=new java.util.Random();// ���������
			int id=100+random.nextInt(500);// ����100+[0,500)�����е�������ע�ⲻ����10
			//System.currentTimeMillis()��õ�ǰʱ�䣬��ȷ��������
			
			long s = System.currentTimeMillis();
			//String.valueOf(s),��long����ת����String���ͣ�
			String a = String.valueOf(s);
			//����userNo ��ֵΪa
			
			user.setUserNO(a);
			String sql = "insert into userInfo"
					+ "(id,userName,password,userAge,idCard,userSex,tel,city,userAddress,userNO,balance,userflag) "
				//	+ "values('" + user.getUserName() + "'," + "'"
					+ "values('"+ id+ "','" + user.getUserName() + "'," + "'"
					+ md5.getMD5ofStr(user.getPassword()) + "'," + "'"
					+ user.getUserAge() + "'," + "'" + user.getIdCard() + "',"
					+ "'" + user.getUserSex() + "'," + "'" + user.getTel() + "',"
					+ "'" + user.getCity() + "'," + "'" + user.getAddress() + "' ,"
					+ "'" + user.getUserNO() + "','" + 0 + "','" + 0 + "')";
			try {
				conn = DBConnection.getDBC();
				conn.setAutoCommit(false);
				st = conn.createStatement();
				st.executeUpdate(sql);
	            conn.commit();
			} catch (Exception e) {
				e.printStackTrace();
				conn.rollback();
			} finally {
				st.close();
				conn.close();
			}
		}
		//����Ա��������
		@Override
		public void changePass(UserInfo user, String userNO,String newpasswd2)
				throws SQLException {
			MD5 md5 = new MD5();
			String sql = "update manuserInfo set password ='" + md5.getMD5ofStr(newpasswd2)
							+"'"+"  where userNO='"+user.getUserNO()+"'";
			try {
				conn = DBConnection.getDBC();
				conn.setAutoCommit(false);
				st = conn.createStatement();
				st.executeUpdate(sql);
				conn.commit();
			} catch (Exception e) {
				e.printStackTrace();
				conn.rollback();
			} finally {
				st.close();
				conn.close();
			}
		}
		//�޸Ĺ���Ա������Ϣ
		@Override
		public void updateManUserInfo(UserInfo user, String userNO)
				throws SQLException {
			MD5 md5 = new MD5();
			String sql = "update manuserInfo set tel ='" + user.getTel()
			+ "',city='" + user.getCity() + "',userAddress='"
			+ user.getAddress() + "'";
			
//			String sql = "update manuserInfo set tel ='" + user.getTel()
//					+ "',password='" + md5.getMD5ofStr(user.getPassword())
//					+ "',city='" + user.getCity() + "',userAddress='"
//					+ user.getAddress() + "'";
			try {
				conn = DBConnection.getDBC();
				conn.setAutoCommit(false);
				st = conn.createStatement();
				st.executeUpdate(sql);
				conn.commit();
			} catch (Exception e) {
				e.printStackTrace();
				conn.rollback();
			} finally {
				st.close();
				conn.close();
			}
			
		}
		//��ѯ����Ա�ʻ���Ϣҵ��
		public UserInfo selectManUser(String userNO) throws SQLException {
			ResultSet rs = null;
			UserInfo userInfo = null;
			String sql = "select * from manuserInfo where userNO = '" + userNO + "'";
			try {
				conn = DBConnection.getDBC();
				st = conn.createStatement();
				userInfo = new UserInfo();
				rs = st.executeQuery(sql);
				if (rs.next()) {
					userInfo.setUserName(rs.getString("userName"));
					//�����ݿ������в�ѯ��������ΪuserName���е�ֵ����userInfo.setUserName()������
					userInfo.setPassword(rs.getString("password"));
					userInfo.setUserNO(rs.getString("userNO"));
					userInfo.setUserAge(rs.getInt("userAge"));
					userInfo.setIdCard(rs.getString("idCard"));
					userInfo.setTel(rs.getString("tel"));
					userInfo.setCity(rs.getString("city"));
					userInfo.setBalance(rs.getInt("balance"));
					userInfo.setAddress(rs.getString("userAddress"));
					userInfo.setUserSex(rs.getString("userSex"));
					userInfo.setUserflag(rs.getInt("userflag"));
					return userInfo;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				rs.close();
				st.close();
				conn.close();
			}
			return null;
		}
}
