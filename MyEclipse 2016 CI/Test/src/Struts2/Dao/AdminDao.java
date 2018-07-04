package Struts2.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Struts2.user.Admin;
import Struts2.util.DbConn;

public class AdminDao {
	private Connection conn = DbConn.getConn();
	  public boolean isLogin(Admin admin){
		  boolean flag=false;
		  String sql="select * from Admin where Adminname=? and Adminpass=?";
		  try {
			PreparedStatement pmst=conn.prepareStatement(sql);
			pmst.setString(1, admin.getUsername());
			pmst.setString(2, admin.getPassword());
			ResultSet rs=pmst.executeQuery();
			if(rs.next()){
				flag=true;				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;	  
	  }	
}
