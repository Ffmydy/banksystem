package com.dy.bank.service;

import java.sql.SQLException;
import java.util.List;

import com.dy.bank.domain.TradeInfo;
import com.dy.bank.persistence.TradeDAO;
import com.dy.bank.persistence.TradeDAOImpl;


public class TradeFacadeImpl implements TradeFacade {

	private TradeDAO tradeDAO;

	public TradeFacadeImpl() {
		tradeDAO = new TradeDAOImpl();
	}

	public void fetchMoney(TradeInfo tradeInfo) throws SQLException {
		tradeDAO.fetchMoney(tradeInfo);
	}

	public void saveMoney(TradeInfo tradeInfo) throws SQLException {
		tradeDAO.saveMoney(tradeInfo);
	}

	public Integer selectBalance(String userNO) throws SQLException {
		return tradeDAO.selectBalance(userNO);
	}

	public List selectTradeInfo(String userNO) throws SQLException {
		return tradeDAO.selectTradeInfo(userNO);
	}

	@Override
	public void abDetection(TradeInfo tradeInfo) throws SQLException {
		tradeDAO.abDetection(tradeInfo);
		
	}

	@Override
	public List selectAbDetection(String userNO) throws SQLException {
		// TODO 自动生成的方法存根
		return tradeDAO.selectAbDetection(userNO);
	}

	@Override
	public List selectUserTradeInfo(String userNO) throws SQLException {
		// TODO 自动生成的方法存根
		return tradeDAO.selectUserTradeInfo(userNO);
	}

}
