package com.dy.bank.service;

import java.sql.SQLException;
import java.util.List;

import com.dy.bank.domain.TradeInfo;


public interface TradeFacade {
	/**
	 * 存款业务
	 */
	void saveMoney(TradeInfo tradeInfo) throws SQLException;

	/**
	 * 取款业务
	 */
	void fetchMoney(TradeInfo tradeInfo) throws SQLException;

	/**
	 * 查询帐户余额
	 * 
	 * @param userNO
	 *            当前登录用户帐号
	 * @return 返回帐户余额
	 */
	Integer selectBalance(String userNO) throws SQLException;

	/**
	 * 查询当前登录用户所有交易信息
	 * 
	 * @param userNO
	 *            当前登录用户帐号
	 * @return 返回交易信息
	 */
	List selectTradeInfo(String userNO) throws SQLException;
	
	/**
	 * 异常检测（取款金额大于等于5000）
	 * @param tradeInfo
	 * @throws SQLException
	 */
	void abDetection(TradeInfo tradeInfo) throws SQLException;
	
	/**
	 * 查询当前登录用户所有交易信息
	 * 
	 * @param userNO
	 *            当前登录用户帐号
	 * @return 返回交易信息
	 */
	List selectAbDetection(String userNO) throws SQLException;

	/**
	 * 查看用户交易信息记录
	 * @param userNO
	 * @return
	 * @throws SQLException
	 */
	List selectUserTradeInfo(String userNO) throws SQLException;
}
