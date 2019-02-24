package com.dy.bank.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.dy.bank.domain.TradeInfo;
import com.dy.bank.util.DBConnection;


public class TradeDAOImpl implements TradeDAO {

	Connection conn = null;
	Statement st = null;
	PreparedStatement psmt1 = null;
	ResultSet rs = null;

	// 取款业务
	public void fetchMoney(TradeInfo tradeInfo) throws SQLException {
		int sum = tradeInfo.getBalance() - tradeInfo.getMoney();
		tradeInfo.setTrade("取款");
		String sql = "update userInfo set balance = '" + sum
				+ "' where userNO = '" + tradeInfo.getUserNO() + "'";
		Date date = Calendar.getInstance().getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(date);
		String sql1 = "insert into trader(userNO,money,trade,balance,datatime) "
			+ "values('"
			+ tradeInfo.getUserNO()
			+ "','"
			+ tradeInfo.getMoney()
			+ "','"
			+ tradeInfo.getTrade()
			+ "','"
			+ sum
			+ "'," + "'" + dateString + "')";
		String sql2 = "insert into abDetection(userNO,money,trade,datatime) "
				+ "values('"
				+ tradeInfo.getUserNO()
				+ "','"
				+ tradeInfo.getMoney()
				+ "','"
				+ tradeInfo.getTrade()
				+ "','"
				+ dateString + "')";
		try {
			conn = DBConnection.getDBC();
			conn.setAutoCommit(false);
			st = conn.createStatement();
			st.executeUpdate(sql1);
			st.executeUpdate(sql);
			System.out.println(tradeInfo.getMoney());
			if(tradeInfo.getMoney() >= 5000){
				st.executeUpdate(sql2);
			}
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conn.setAutoCommit(true);
			st.close();
			conn.close();
		}
	}

	// 存款业务
	public void saveMoney(TradeInfo tradeInfo) throws SQLException {
		int sum = tradeInfo.getMoney() + tradeInfo.getBalance();
		tradeInfo.setTrade("存款");
		String sql = "update userInfo set balance = '" + sum
				+ "' where userNO = '" + tradeInfo.getUserNO() + "'";
		Date date = Calendar.getInstance().getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(date);
		String sql1 = "insert into trader(userNO,money,trade,balance,datatime) "
				+ "values('"
				+ tradeInfo.getUserNO()
				+ "','"
				+ tradeInfo.getMoney()
				+ "','"
				+ tradeInfo.getTrade()
				+ "','"
				+ sum
				+ "'," + "'" + dateString + "')";
		try {
			conn = DBConnection.getDBC();
			conn.setAutoCommit(false);
			st = conn.createStatement();
			st.executeUpdate(sql1);
			st.executeUpdate(sql);
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conn.setAutoCommit(true);
			st.close();
			conn.close();
		}
	}

	// 查询余额业务
	public Integer selectBalance(String userNO) throws SQLException {
		Integer balance = new Integer(-1);
		String sql = "select balance from userInfo where userNO = '" + userNO
				+ " '";
		try {
			conn = DBConnection.getDBC();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				balance = Integer.valueOf(rs.getString("balance"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rs.close();
		conn.close();
		return balance;
	}

	// 查询业务
	@SuppressWarnings("unchecked")
	public List selectTradeInfo(String userNO) throws SQLException {
		List list = new ArrayList();
		String sql = "select * from trader where userNO='" + userNO + "'";
		try {
			conn = DBConnection.getDBC();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				TradeInfo tradeInfo = new TradeInfo();
				tradeInfo.setTrade(rs.getString("trade"));
				tradeInfo.setBalance(rs.getInt("balance"));
				tradeInfo.setDatatime(rs.getString("dataTime"));
				tradeInfo.setMoney(rs.getInt("money"));
				list.add(tradeInfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		rs.close();
		st.close();
		conn.close();
		return list;
	}

	@Override
	public void abDetection(TradeInfo tradeInfo) throws SQLException {
		// TODO 自动生成的方法存根
		
	}

	//查询异常检测信息业务
	public List selectAbDetection(String userNO) throws SQLException {
List list = new ArrayList();
String sql = "select * from abDetection";
try {
	conn = DBConnection.getDBC();
	st = conn.createStatement();
	rs = st.executeQuery(sql);
	while (rs.next()) {
		TradeInfo tradeInfo = new TradeInfo();
		tradeInfo.setId(rs.getInt("id"));
		tradeInfo.setUserNO(rs.getString("userNO"));
		tradeInfo.setTrade(rs.getString("trade"));
		tradeInfo.setDatatime(rs.getString("dataTime"));
		tradeInfo.setMoney(rs.getInt("money"));
		list.add(tradeInfo);
	}
} catch (Exception e) {
	e.printStackTrace();
}
rs.close();
st.close();
conn.close();
		return list;
	}

	//管理员查询用户交易信息
	@Override
	public List selectUserTradeInfo(String userNO) throws SQLException {
		List list = new ArrayList();
		String sql = "select * from trader where userNO='" + userNO + "'";
		try {
			conn = DBConnection.getDBC();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				TradeInfo tradeInfo = new TradeInfo();
				tradeInfo.setTrade(rs.getString("trade"));
				tradeInfo.setBalance(rs.getInt("balance"));
				tradeInfo.setDatatime(rs.getString("dataTime"));
				tradeInfo.setMoney(rs.getInt("money"));
				list.add(tradeInfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		rs.close();
		st.close();
		conn.close();
		return list;
	}
}
