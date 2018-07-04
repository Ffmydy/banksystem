package Struts2.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Struts2.user.Course;
import Struts2.user.Grade;
import Struts2.user.Stu;
import Struts2.user.Teacher;
import Struts2.util.DbConn;

public class CourseDao {
	private static Connection conn = DbConn.getConn();
	
	public  List ListCou() //管理员显示课程列表
	{
		Course cou=null;
		List list = new ArrayList();
		String sql = "select * from course";
		try {
			Statement smt = conn.createStatement();
			ResultSet rs = smt.executeQuery(sql);
			while (rs.next()) {
				String coursename = rs.getString("coursename");
				String classname = rs.getString("classname");
				int gradename = rs.getInt("gradename");
				String teachername = rs.getString("teachername");
				cou = new Course(coursename,classname,gradename,teachername);
				list.add(cou);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return list;
	}
	
	public   boolean addCourse(Course course) {
		boolean flag = false;
		String sql = "insert into course(coursename,classname,gradename,teachername) "
				+ "values(?,?,?,?)";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, course.getCoursename());
			psmt.setString(2, course.getClassname());
			psmt.setInt(3, course.getGradename());
			psmt.setString(4, course.getTeachername());
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
	
	public  List Listgc(int gradename){
		Course cou = null;
		List listgc= new ArrayList();
		String sql = "select * from course where gradename = ?";
		try{
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setInt(1, gradename);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()){
				String coursename = rs.getString("coursename");
				cou = new Course(coursename);
				listgc.add(cou);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listgc;
	}
	
	public  List Listtc(int teacherid){
		Course cou = null;
		List listtc= new ArrayList();
		String sql = "select coursename from course where teachername IN(select teachername from teacher where teacherid = ?)";
		try{
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setInt(1, teacherid);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()){
				String coursename = rs.getString("coursename");
				cou = new Course(coursename);
				listtc.add(cou);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listtc;
	}
}
