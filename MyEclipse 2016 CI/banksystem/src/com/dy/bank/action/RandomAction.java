package com.dy.bank.action;

import java.io.ByteArrayInputStream;

import com.dy.bank.util.RandomNumUtil;
import com.opensymphony.xwork2.ActionContext;  
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class RandomAction extends ActionSupport{  
	
	private ByteArrayInputStream inputStream; 
	
	@SuppressWarnings("unchecked")
	public String execute() throws Exception{  
		
		RandomNumUtil rdnu=RandomNumUtil.Instance();   
		this.setInputStream(rdnu.getImage());//ȡ�ô�������ַ�����ͼƬ   
		//ȡ������ַ�������HttpSession
		ActionContext.getContext().getSession().put("random", rdnu.getString());   
		return SUCCESS;   
	}   
	
	public void setInputStream(ByteArrayInputStream inputStream) {   
		this.inputStream = inputStream;   
	}   
	
	public ByteArrayInputStream getInputStream() {   
		return inputStream;   
	}  
} 
