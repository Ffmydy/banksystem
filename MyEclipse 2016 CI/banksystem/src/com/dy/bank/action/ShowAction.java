/**import java.util.List;  

import com.cjg.bank.domain.UserInfo;  
import com.cjg.bank.service.UserFacade;
import com.cjg.bank.service.UserFacadeImpl;
import com.opensymphony.xwork2.ActionSupport;  
  
@SuppressWarnings("serial")
public class ShowAction extends ActionSupport {  
	
    private List<UserInfo> userInfo ;  
    private int pageNow = 1 ; //��ʼ��Ϊ1,Ĭ�ϴӵ�һҳ��ʼ��ʾ  
    private int pageSize = 5 ; //ÿҳ��ʾ5����¼  
      
    private UserFacade userFacade;  
      
    public ShowAction() {
		userFacade = new UserFacadeImpl();
	}
  
	public List<UserInfo> getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(List<UserInfo> userInfo) {
		this.userInfo = userInfo;
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

	public String execute() throws Exception {  
		userInfo = userFacade.queryByPage(pageSize,pageNow);  
        return SUCCESS ;  
    }  
}*/
package com.dy.bank.action;

import java.util.List;

import com.dy.bank.domain.UserInfo;
import com.dy.bank.service.UserFacade;
import com.dy.bank.service.UserFacadeImpl;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ShowAction extends ActionSupport {
	
	private List<UserInfo> userInfo ;
	private int pageNow = 1 ; //��ʼ��Ϊ1,Ĭ�ϴӵ�һҳ��ʼ��ʾ
    private int pageSize = 5 ; //ÿҳ��ʾ5����¼
    
	private UserFacade userFacade;
	
	public ShowAction() {
		userFacade = new UserFacadeImpl();
	}
	
	public List<UserInfo> getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(List<UserInfo> userInfo) {
		this.userInfo = userInfo;
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

	public String toShow() throws Exception {
		userInfo = userFacade.queryByPage(pageSize, pageNow) ;
		return SUCCESS ;
	}
	/*public String execute() throws Exception {
		userInfo = userFacade.queryByPage(pageSize, pageNow) ;
		return SUCCESS ;
	}*/
}
