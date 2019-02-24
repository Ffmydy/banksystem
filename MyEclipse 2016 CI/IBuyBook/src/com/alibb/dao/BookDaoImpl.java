package com.alibb.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class BookDaoImpl extends JdbcDaoSupport implements BookDao {

	@Override
	public void openb(String bname, double bprice, int bnumber) {
		String sql="insert into book(bname,bprice,bnumber)values(?,?,?)";
		this.getJdbcTemplate().update(sql, bname,bprice,bnumber);
	}

	@Override
	public void bbuybook(String bname, int number) {
		String sql="update book set bnumber=bnumber-? where bname=?";
		this.getJdbcTemplate().update(sql, number,bname);
	}
}
