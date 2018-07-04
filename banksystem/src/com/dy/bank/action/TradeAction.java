package com.dy.bank.action;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.dy.bank.domain.TradeInfo;
import com.dy.bank.domain.UserInfo;
import com.dy.bank.service.TradeFacade;
import com.dy.bank.service.TradeFacadeImpl;


public class TradeAction {

	private TradeFacade tradeFacade;
	
	TradeInfo tradeInfo;

	private Integer money;

	private String tradeType;

	private Integer balance;

	private List<TradeInfo> list;
	
	private String userNO;
	
	public String getUserNO() {
		return userNO;
	}

	public void setUserNO(String userNO) {
		this.userNO = userNO;
	}

	public TradeAction() {
		tradeFacade = new TradeFacadeImpl();
		tradeInfo = new TradeInfo();
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public List<TradeInfo> getList() {
		return list;
	}

	public void setList(List<TradeInfo> list) {
		this.list = list;
	}

	public Integer getMoney() {
		return money;
	}

	public void setMoney(Integer money) {
		this.money = money;
	}

	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	//取款业务
	public String fetchMoney() throws SQLException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String userNO = (String) (((UserInfo) session.getAttribute("user")).getUserNO());
		int userflag = ((UserInfo) session.getAttribute("user")).getUserflag();
		String tt = getTradeType();
		Integer balance = tradeFacade.selectBalance(userNO);
		tradeInfo.setUserNO(userNO);
		tradeInfo.setTrade(tt);
		tradeInfo.setBalance(balance);
		tradeInfo.setMoney(money);
		if (userflag == 1) {
			return "abilityError";
		} else {
			// 如果取款金额大于帐户余额则提示出错
			if (tradeInfo.getMoney() > balance.intValue()) {
				return "fetchError";
			}else if(tradeInfo.getMoney() >= 5000){
				tradeFacade.fetchMoney(tradeInfo);
				return "fetchSuccess";
			}else{
				tradeFacade.fetchMoney(tradeInfo);
				return "fetchSuccess";
			}
		}
	}

	//用户存款
	public String saveMoney() throws SQLException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String userNO = (String) (((UserInfo) session.getAttribute("user"))
				.getUserNO());
		// 从session中获得帐户是否注销标志userflag
		int userflag = ((UserInfo) session.getAttribute("user")).getUserflag();
		String tt = getTradeType();
		Integer balance = tradeFacade.selectBalance(userNO);
		tradeInfo.setUserNO(userNO);
		tradeInfo.setTrade(tt);
		tradeInfo.setBalance(balance);
		tradeInfo.setMoney(money);
		// userflag==1说明帐户已经被注销
		if (userflag == 1) {
			return "abilityError";
		} else {
			tradeFacade.saveMoney(tradeInfo);
			return "saveSuccess";
		}
	}

	//查询余额
	public String selectBalance() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String userNO = (String) (((UserInfo) session.getAttribute("user"))
				.getUserNO());
		int userflag = ((UserInfo) session.getAttribute("user")).getUserflag();
		if (userflag == 1) {
			return "abilityError";
		} else {
			try {
				Integer balance = tradeFacade.selectBalance(userNO);
				setBalance(balance);
			} catch (SQLException e) {
				e.printStackTrace();
				return "Error";
			}
			return "selectBalance";
		}
	}

	//查询交易信息
	@SuppressWarnings("unchecked")
	public String tradeInfo() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String userNO = (String) (((UserInfo) session.getAttribute("user"))
				.getUserNO());
		try {
			List list = tradeFacade.selectTradeInfo(userNO);
			setList(list);
		} catch (SQLException e) {
			e.printStackTrace();
			return "Error";
		}
		return "selectTradeInfo";
	}
	
	public String selectAbDetection() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String userNO = (String) (((UserInfo) session.getAttribute("user"))
				.getUserNO());
		try {
			List list = tradeFacade.selectAbDetection(userNO);
			setList(list);
		} catch (SQLException e) {
			e.printStackTrace();
			return "Error";
		}
		return "selectAbDete";
	}
	//查看用户交易信息表
	public String selectUserTradeInfo() {
		//System.out.println("交易记录账号userNO："+getUserNO());
		String userNO = getUserNO();
		//System.out.println("交易记录账号2userNO："+userNO);
		try {
			List list = tradeFacade.selectUserTradeInfo(userNO);
			setList(list);
		} catch (SQLException e) {
			e.printStackTrace();
			return "Error";
		}
		return "selectUserTradeInfo";
	}
}
