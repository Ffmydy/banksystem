package com.dy.bank.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext; 

import com.dy.bank.domain.UserInfo;
import com.dy.bank.service.UserFacade;
import com.dy.bank.service.UserFacadeImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


@SuppressWarnings("serial")
public class LoginAction extends ActionSupport{

	private String userNO;

	private String password;
	
	private String rand;
	
	public String RadioButtonList1;
	
	private UserFacade userFacade;
	
	public String getRadioButtonList1() {
		return RadioButtonList1;
	}

	public void setRadioButtonList1(String radioButtonList1) {
		RadioButtonList1 = radioButtonList1;
	}

	public String getRand() {
		return rand;
	}

	public void setRand(String rand) {
		this.rand = rand;
	}

	public LoginAction() {
		userFacade = new UserFacadeImpl();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserNO() {
		return userNO;
	}

	public void setUserNO(String userNO) {
		this.userNO = userNO;
	}
	//��ͨ�û���¼
	public String login() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		boolean flag = false;
		UserInfo user = new UserInfo();
		user.setUserNO(getUserNO());
		user.setPassword(getPassword());
		user.setRand(getRand());
		String arandom=(String)(ActionContext.getContext().getSession().get("random"));
		String RadioButtonList1 = (String)request.getParameter("RadioButtonList1");
		if(RadioButtonList1.equals("00")){
			try {
				flag = userFacade.login(user);
				// flag==true˵�������ݿ��в�ѯ������ҳ���õ��ʺ�������ƥ��Ľ��
				if (flag == true && arandom.equals(this.getRand())) {
					UserInfo userInfo = userFacade.selectUser(userNO);
					session.setAttribute("user", userInfo);
					return "loginSuccess";
				} 
				else if(flag != true && !arandom.equals(this.getRand())){
					return "bothError";
				}
				else if(flag == true && !arandom.equals(this.getRand())){
					return "verError";
				}
				else{
					return "loginError";
				}
			} catch (Exception e) {
				e.printStackTrace();
				return "Error";
			}
		}else{
			return "managerLogin";
		}
	}
	//����Ա�û���¼
	public String Manlogin() {
		boolean flag = false;
		UserInfo user = new UserInfo();
		user.setUserNO(getUserNO());
		user.setPassword(getPassword());
		user.setRand(getRand());
		String arandom=(String)(ActionContext.getContext().getSession().get("random"));
		try {
			flag = userFacade.Manlogin(user);
			// flag==true˵�������ݿ��в�ѯ������ҳ���õ��ʺ�������ƥ��Ľ��
			if (flag == true && arandom.equals(this.getRand())) {
				UserInfo userInfo = userFacade.selectManUser(userNO);
				HttpServletRequest request = ServletActionContext.getRequest();
				HttpSession session = request.getSession();
				// ����¼�û���Ϣ����session
				session.setAttribute("user", userInfo);
				//System.out.println("session:"+session);
				//System.out.println("userInfo:"+userInfo);
				return "ManloginSuccess";
			} 
			else if(flag != true && !arandom.equals(this.getRand())){
				return "bothError";
			}
			else if(!arandom.equals(this.getRand())){
				return "verError";
			}
			else{
				return "loginError";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "Error";
		}
	}
	//��ͨ�û��˳�
	public String logout() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		// ����session
		session.invalidate();
		return "logout";
	}
	//����Ա�û��˳�
	public String Manlogout() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		// ����session
		session.invalidate();
		return "Manlogout";
	}
}
