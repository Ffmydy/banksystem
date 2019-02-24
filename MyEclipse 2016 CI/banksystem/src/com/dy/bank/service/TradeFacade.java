package com.dy.bank.service;

import java.sql.SQLException;
import java.util.List;

import com.dy.bank.domain.TradeInfo;


public interface TradeFacade {
	/**
	 * ���ҵ��
	 */
	void saveMoney(TradeInfo tradeInfo) throws SQLException;

	/**
	 * ȡ��ҵ��
	 */
	void fetchMoney(TradeInfo tradeInfo) throws SQLException;

	/**
	 * ��ѯ�ʻ����
	 * 
	 * @param userNO
	 *            ��ǰ��¼�û��ʺ�
	 * @return �����ʻ����
	 */
	Integer selectBalance(String userNO) throws SQLException;

	/**
	 * ��ѯ��ǰ��¼�û����н�����Ϣ
	 * 
	 * @param userNO
	 *            ��ǰ��¼�û��ʺ�
	 * @return ���ؽ�����Ϣ
	 */
	List selectTradeInfo(String userNO) throws SQLException;
	
	/**
	 * �쳣��⣨ȡ������ڵ���5000��
	 * @param tradeInfo
	 * @throws SQLException
	 */
	void abDetection(TradeInfo tradeInfo) throws SQLException;
	
	/**
	 * ��ѯ��ǰ��¼�û����н�����Ϣ
	 * 
	 * @param userNO
	 *            ��ǰ��¼�û��ʺ�
	 * @return ���ؽ�����Ϣ
	 */
	List selectAbDetection(String userNO) throws SQLException;

	/**
	 * �鿴�û�������Ϣ��¼
	 * @param userNO
	 * @return
	 * @throws SQLException
	 */
	List selectUserTradeInfo(String userNO) throws SQLException;
}
