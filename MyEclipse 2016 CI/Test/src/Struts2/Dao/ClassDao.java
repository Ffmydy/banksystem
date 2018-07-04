package Struts2.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

import Struts2.user.Class;
import Struts2.util.DbConn;

public class ClassDao {
	private static Connection conn = DbConn.getConn();
	
	public static  List ListClass() //管理员显示班级	列表
	{
		Class cl = null;
		List list = new ArrayList();
		String sql = "select * from class";
		try {
			Statement smt = conn.createStatement();
			ResultSet rs = smt.executeQuery(sql);
			while (rs.next()) {
				
				int classid = rs.getInt("classid");
				String classname = rs.getString("classname");
				
				cl = new Class(classid,classname);
				list.add(cl);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return list;
	}
	
	public static   boolean addClass(Class cl) {//增加班级的实现类
		boolean flag = false;
		String sql = "insert into class(classid,classname) "+ "values(?,?)";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setInt(1, cl.getClassid());
			psmt.setString(2, cl.getClassname());
			int i = psmt.executeUpdate();
			if (i == 1) {
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	
	public static  List ListCl() {						//获取班级
		Class cl=null;
		List listCl = new ArrayList();
		String sql = "select classname from class";
		try {
			Statement smt = conn.createStatement();
			ResultSet rs = smt.executeQuery(sql);
			while (rs.next()) {
				String classname = rs.getString("classname");
				cl  = new Class(classname);
				listCl.add(cl);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return listCl;
	}
}
