package com.alibb.dao;
import org.springframework.jdbc.core.support.JdbcDaoSupport;


public class UserDaoImpl extends JdbcDaoSupport implements UserDao   {

	@Override
	public void openu(String uname, double umoney) {
		String sql="insert into user(uname,umoney) values(?,?)";
		this.getJdbcTemplate().update(sql, uname,umoney);
	}
	@Override
	public void ubuybook(String uname, String bname,int number) {
		String sql="select bprice from book where bname=?";
		double price=this.getJdbcTemplate().queryForObject(sql, new Object[]{bname},double.class);
		double allprice=price*number;
		count(uname,allprice);
	}
	public void count(String uname,double allprice){
		String sql="update user set umoney=umoney-? where uname=? ";
		this.getJdbcTemplate().update(sql, allprice,uname);	
	}
}
