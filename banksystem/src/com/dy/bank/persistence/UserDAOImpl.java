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

	Connection conn = null;		//创建变量conn
	//执行静态SQL语句，通常通过Statement实例实现
	Statement st = null;		//创建变量st
	private PreparedStatement pstmt ;
	private UserInfo userInfo ;
	private ResultSet rs ;
	//普通用户登录系统业务
	public boolean login(UserInfo user) throws SQLException {
		boolean flag = false;	//创建boolean类型变量
		MD5 md5 = new MD5();	//生成工具类MD5的对象
		String userNO = user.getUserNO();	//获取用户账号
		//获取工具类对象md5处理后的用户密码
		String password = md5.getMD5ofStr(user.getPassword());
		@SuppressWarnings("unused")
		String rand = user.getRand();
		try {
			conn = DBConnection.getDBC();	//通过工具类DBConnection获取连接信息
			st = conn.createStatement();	//为变量st赋值
			//创建sql语句
			String sql = "select userNO from userInfo where userNO='" + userNO
					+ "' and  password = '" + password + "'";
			ResultSet rs = st.executeQuery(sql);	//sql语句执行结果
			if (rs.next()) {	//执行成功
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
	//管理员登录系统业务
		public boolean Manlogin(UserInfo user) throws SQLException {
			boolean flag = false;	//创建boolean类型变量
			MD5 md5 = new MD5();	//生成工具类MD5的对象
			String userNO = user.getUserNO();	//获取用户账号
			//获取工具类对象md5处理后的用户密码
			String password = md5.getMD5ofStr(user.getPassword());
			@SuppressWarnings("unused")
			String rand = user.getRand();
			try {
				conn = DBConnection.getDBC();	//通过工具类DBConnection获取连接信息
				st = conn.createStatement();	//为变量st赋值
				//创建sql语句
				String sql = "select userNO from manuserInfo where userNO='" + userNO
						+ "' and  password = '" + password + "'";
				ResultSet rs = st.executeQuery(sql);	//sql语句执行结果
				if (rs.next()) {	//执行成功
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
	//普通用户注册业务
	public void registService(UserInfo user) throws SQLException {
		MD5 md5 = new MD5();
		java.util.Random random=new java.util.Random();// 定义随机类
		int id=100+random.nextInt(500);// 返回100+[0,500)集合中的整数，注意不包括10
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
	//管理员注册业务
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
	//查询个人帐户信息业务
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
				//将数据库结果集中查询到的列名为userName的列的值传入userInfo.setUserName()方法中
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
	//修改个人帐户信息业务
	public void updateUserInfo(UserInfo user, String userNO)
			throws SQLException {
		MD5 md5 = new MD5();
		/*String sql = "update userInfo set tel ='" + user.getTel()
				+ "',password='" + md5.getMD5ofStr(user.getPassword())
				+ "',city='" + user.getCity() + "',userAddress='"
				+ user.getAddress() + "'";*/
		String sql = "update userInfo set tel ='" + user.getTel()
				+ "',city='" + user.getCity() + "',userAddress='"
				+ user.getAddress() + "'";
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
	//注销帐户业务
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
	//分页查询
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
		//管理员删除普通用户帐户业务
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
		 * 管理员修改普通用户账户信息
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
		//管理员添加新用户
		
		public void addUserInfo(UserInfo user) throws SQLException {
			//user = new UserInfo();
			//MD5加密算法
			MD5 md5 = new MD5();
			java.util.Random random=new java.util.Random();// 定义随机类
			int id=100+random.nextInt(500);// 返回100+[0,500)集合中的整数，注意不包括10
			//System.currentTimeMillis()获得当前时间，精确到毫秒数
			
			long s = System.currentTimeMillis();
			//String.valueOf(s),把long变量转换成String类型；
			String a = String.valueOf(s);
			//设置userNo 的值为a
			
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
		//管理员更改密码
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
		//修改管理员个人信息
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
		//查询管理员帐户信息业务
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
					//将数据库结果集中查询到的列名为userName的列的值传入userInfo.setUserName()方法中
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
