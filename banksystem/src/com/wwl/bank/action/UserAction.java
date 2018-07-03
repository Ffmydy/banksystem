package com.wwl.bank.action;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.wwl.bank.domain.UserInfo;
import com.wwl.bank.service.UserFacade;
import com.wwl.bank.service.UserFacadeImpl;
import com.wwl.bank.util.MD5;


@SuppressWarnings("serial")
public class UserAction extends ActionSupport{

	private UserFacade userFacade;

	private UserInfo userInfo;
	
	private List<UserInfo> userInfos;
	
	private String userNO;
	
	int balance;
	
	private String passwd;
	
	private String newpassword;
	
	private String p2;
	
	private String np2;
	
	private String error = null;
	
	private int pageNow = 1 ; //初始化为1,默认从第一页开始显示  
	
    private int pageSize = 5 ; //每页显示5条记录
	
	public List<UserInfo> getUserInfos() {
		return userInfos;
	}

	public void setUserInfos(List<UserInfo> userInfos) {
		this.userInfos = userInfos;
	}

	public int getPageNow() {
		return pageNow;
	}

	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	public String getP2() {
		return p2;
	}

	public void setP2(String p2) {
		this.p2 = p2;
	}

	public String getNp2() {
		return np2;
	}

	public void setNp2(String np2) {
		this.np2 = np2;
	}
	
	public UserAction() {
		
		userFacade = new UserFacadeImpl();
	}
	
	public String getUserNO() {
		return userNO;
	}

	public void setUserNO(String userNO) {
		System.out.println(userNO);
		this.userNO = userNO;
	}
	
	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	//普通用户注册
	public String regist() {
		UserInfo user = getUserInfo();
		try {
			userFacade.registService(user);
			setUserInfo(user);
			return "registSuccess";
		} catch (Exception e) {
			e.printStackTrace();
			return "Error";
		}
	}
	//管理员用户注册
	public String ManagerRegist() {
		UserInfo user = getUserInfo();
		try {
			userFacade.ManRegService(user);
			setUserInfo(user);
			return "ManRegSuccess";
		} catch (Exception e) {
			e.printStackTrace();
			return "Error";
		}
	}
	//普通用户查询个人信息
	public String selectUser() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String userNO = (String) (((UserInfo) session.getAttribute("user"))
				.getUserNO());
		try {
			UserInfo user = userFacade.selectUser(userNO);
			setUserInfo(user);
		} catch (SQLException e) {
			e.printStackTrace();
			return "Error";
		}
		return "selectUser";
	}
	//普通用户更改个人信息
	public String updateUser() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String userNO = (String) (((UserInfo) session.getAttribute("user"))
				.getUserNO());
		int userflag = ((UserInfo) session.getAttribute("user")).getUserflag();
		//System.out.println("updateUser");
		if (userflag == 1) {
			return "abilityError";
		} else {
			UserInfo userInfo = getUserInfo();
			try {
				userFacade.updateUserInfo(userInfo, userNO);
				setUserInfo(userInfo);
			} catch (SQLException e) {
				e.printStackTrace();
				return "Error";
			}
			return "updateSuccess";
		}
	}
	//普通用户注销个人账户
	public String deleteUser() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String userNO = (String) (((UserInfo) session.getAttribute("user"))
				.getUserNO());
		int balance = 0;
		try {
			UserInfo userInfo = userFacade.selectUser(userNO);
			balance = userInfo.getBalance();
		} catch (Exception e) {
			e.printStackTrace();
			return "Error";
		}
		// 如果帐户余额大于零，不允许注销操作，提示出错
		if (balance > 0) {
			setBalance(balance);
			return "deleteError";
		} else {
			try {
				userFacade.deleteUserInfo(userNO);
				session.setAttribute("user", userFacade.selectUser(userNO));
				return "deleteSuccess";
			} catch (Exception e) {
				e.printStackTrace();
				return "Error";
			}
		}
	}
	//管理员查询用户列表
	public String queryByPage() {
		try {
			userInfos = userFacade.queryByPage(pageSize,pageNow);
			setUserInfos(userInfos);
		} catch (Exception e) {
			e.printStackTrace();
			return "Error";
		}
		return "selectUser";
	}
	//管理员删除普通用户
	public String deleteUser2()
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		int balance = 0;
		try {
			UserInfo userInfo = userFacade.selectUser(userNO);
			balance = userInfo.getBalance();
		} catch (Exception e) {
			e.printStackTrace();
			return "Error";
		}
		// 如果帐户余额大于零，不允许删除操作，提示出错
		if (balance > 0) {
			System.out.println("进入删除失败！");
			setBalance(balance);
			return "deleteError2";
		} else {
			try {
				System.out.println("进入删除成功！");
				userFacade.deleteUserInfo2(userNO);
				session.setAttribute("user", userFacade.selectUser(userNO));
				return "deleteSuccess2";
			} catch (Exception e) {
				e.printStackTrace();
				return "Error";
			}
		}
	}
	//管理员更改普通用户信息
	public String updateUser2() {
		@SuppressWarnings("unused")
		HttpServletRequest request = ServletActionContext.getRequest();
		UserInfo userInfo = getUserInfo();
		try {
			userFacade.updateUserInfo2(userInfo, userNO);
			setUserInfo(userInfo);
		} catch (SQLException e) {
			e.printStackTrace();
			return "Error";
		}
		return "updateSuccess2";
	}
	//管理员添加新用户
	public String addUserInfo() {
		UserInfo user = getUserInfo();
		try {
			userFacade.addUserInfo(user);
			setUserInfo(user);
			return "registSuccess2";
		} catch (Exception e) {
			e.printStackTrace();
			return "Error";
		}
	}
	//更改密码
	public String changePass(){
		MD5 md5 = new MD5();
		String passwd2 = null;
		String newpasswd2 = null;
		try {
			
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();  
			String userNO = (String) (((UserInfo) session.getAttribute("user"))
					.getUserNO()); 
			//System.out.println("userInfo.getNewpassword():"+userInfo.getNewpassword());
			newpasswd2 = userInfo.getNewpassword();
			UserInfo userInfo = userFacade.selectManUser(userNO);
			//加密后的当前密码
			passwd2 = md5.getMD5ofStr(getPasswd());
			//System.out.println("newpasswd2:"+newpasswd2);
			//System.out.println("getNp2():"+getNp2());
			if (passwd2.equals(userInfo.getPassword())) {  
	            if(passwd2.equals(md5.getMD5ofStr(getP2()))){
	            	if(newpasswd2.equals(getNp2())){
	            		try{
	                		userFacade.changePass(userInfo,userNO,newpasswd2);
	                    	//setUserInfo(userInfo);
	                    	return "changePaaSuc";
	                	}catch(Exception e){
	                		e.printStackTrace();
	                		return "Error";
	                	}
	                	
	            	}else{
	            		//新密码两次输入不一致；
	            		return "newpasserror";
	            	}
	            }else{
	            	//两次输入密码不一致；
	            	return "passerror";
	            }
	        }else{
	        	return "oldpasserror";
	        }
		} catch (Exception e) {
			e.printStackTrace(); 
			return "Error";
		}
	}
	//管理员用户更改个人信息
		public String updateManUser() {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			String userNO = (String) (((UserInfo) session.getAttribute("user"))
					.getUserNO());
			System.out.println("userNO:"+userNO);
			UserInfo user = getUserInfo();
			try {
				userFacade.updateManUserInfo(user, userNO);
				setUserInfo(user);
			} catch (SQLException e) {
				e.printStackTrace();
				return "Error";
			}
			return "updateManSuccess";
		}
	//管理员用户查询个人信息
		public String selectManUser() {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			String userNO = (String) (((UserInfo) session.getAttribute("user"))
					.getUserNO());
			try {
				UserInfo user = userFacade.selectManUser(userNO);
				setUserInfo(user);
			} catch (SQLException e) {
				e.printStackTrace();
				return "Error";
			}
			return "selectManUser";
		}
}
