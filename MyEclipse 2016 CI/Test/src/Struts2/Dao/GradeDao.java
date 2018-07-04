package Struts2.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Struts2.user.Grade;
import Struts2.user.Teacher;
import Struts2.util.DbConn;

public class GradeDao {
	private static Connection conn = DbConn.getConn();
	
	public static  List ListGrade() //管理员显示学期列表
	{
		Grade grade=null;
		List list = new ArrayList();
		String sql = "select * from grade";
		try {
			Statement smt = conn.createStatement();
			ResultSet rs = smt.executeQuery(sql);
			while (rs.next()) {
				int gradeid = rs.getInt("gradeid");
				int gradename = rs.getInt("gradename");
				
				grade = new Grade(gradeid,gradename);
				list.add(grade);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return list;
	}
	
	public  boolean addGrade(Grade grade) {
		boolean flag = false;
		String sql = "insert into grade(gradeid,gradename) "+ "values(?,?)";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setInt(1, grade.getGradeid());
			psmt.setInt(2, grade.getGradename());
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
	
	public static  List Listcg() {						//获取学期
		Grade cg=null;
		List listcg = new ArrayList();
		String sql = "select gradename from grade";
		try {
			Statement smt = conn.createStatement();
			ResultSet rs = smt.executeQuery(sql);
			while (rs.next()) {
				int gradename = rs.getInt("gradename");
				cg  = new Grade(gradename);
				listcg.add(cg);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return listcg;
	}
	

}