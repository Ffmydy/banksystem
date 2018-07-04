package Struts2.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Struts2.user.Score;
import Struts2.user.Teacher;
import Struts2.util.DbConn;

public class TeacherDao {
	private static Connection conn = DbConn.getConn();
	  public boolean isLogin(Teacher teacher){
		  boolean flag=false;
		  String sql="select * from teacher where teacherid=? and teacherpass=?";
		  try {
			PreparedStatement pmst=conn.prepareStatement(sql);
			pmst.setString(1, teacher.getTeachername());
			pmst.setString(2, teacher.getTeacherpass());
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
	  
		public List ListTeacher() //管理员显示教师列表
		{
			Teacher teach=null;
			List list = new ArrayList();
			String sql = "select * from teacher";
			try {
				Statement smt = conn.createStatement();
				ResultSet rs = smt.executeQuery(sql);
				while (rs.next()) {
					int teacherid = rs.getInt("teacherid");
					String teachername = rs.getString("teachername");
					String teachersex = rs.getString("teachersex");
					String teacherpass = rs.getString("teacherpass");
					
					teach = new Teacher(teacherid,teachername,teachersex,teacherpass);
					list.add(teach);
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			return list;
		}
		
		public   boolean addTeacher(Teacher teacher) {
			boolean flag = false;
			String sql = "insert into teacher(teacherid,teachername,teachersex,teacherpass) "
					+ "values(?,?,?,?)";
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setInt(1, teacher.getTeacherid());
				psmt.setString(2, teacher.getTeachername());
				psmt.setString(3, teacher.getTeachersex());
				psmt.setString(4, teacher.getTeacherpass());
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
		
		public  Teacher STeacher(int teacherid){
			Teacher teach = null;
			String sql = "select * from teacher where teacherid = ?";
			try{
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setInt(1, teacherid);
				ResultSet rs = psmt.executeQuery();
				while (rs.next()){
					int teacherid1 = rs.getInt("teacherid");
					String teachername = rs.getString("teachername");
					String teachersex = rs.getString("teachersex");
					String teacherpass = rs.getString("teacherpass");
					teach = new Teacher(teacherid1,teachername,teachersex,teacherpass);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return teach;
		}
		public  boolean updateT(Teacher teacher){             //修改教师信息
			boolean flag = false;
			String sql = "update teacher set teachername=?,teachersex=?,teacherpass=?"+"where teacherid=?";
			try{
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, teacher.getTeachername());
				psmt.setString(2, teacher.getTeachersex());
				psmt.setString(3, teacher.getTeacherpass());
				psmt.setInt(4, teacher.getTeacherid());
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
		
		public static List Listct() {						//获取教师
			Teacher ct=null;
			List listct = new ArrayList();
			String sql = "select teachername from teacher";
			try {
				Statement smt = conn.createStatement();
				ResultSet rs = smt.executeQuery(sql);
				while (rs.next()) {
					String teachername = rs.getString("teachername");
					ct  = new Teacher(teachername);
					listct.add(ct);
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			return listct;
		}
		
		public List Listct(String courname){					//教师查看课程的成绩
			Score sco=null;
			List listct = new ArrayList();
			String sql = "select score.*,stu.* from stu,score where score.stuid=stu.stuid and coursename = ?";
			try{
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, courname);
				ResultSet rs = psmt.executeQuery();
				while (rs.next()){
					int gradename = rs.getInt("gradename");
					String classname = rs.getString("classname");
					String stuname = rs.getString("stuname");
					int score = rs.getInt("score");
					int stuid = rs.getInt("stuid");
					String coursename = rs.getString("coursename");
					sco = new Score(gradename,classname,stuname,score,stuid,coursename);
					listct.add(sco);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return listct;
		}
		
		public  Score ListSc(String studentname){
			Score sc = null;
			String sql = "select score.*,stu.* from stu,score where score.stuid=stu.stuid and stuname = ?";
			try{
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, studentname);
				ResultSet rs = psmt.executeQuery();
				while (rs.next()){
					int gradename = rs.getInt("gradename");
					String classname = rs.getString("classname");
					String stuname = rs.getString("stuname");
					int score = rs.getInt("score");
					int stuid = rs.getInt("stuid");
					String coursename = rs.getString("coursename");
					sc = new Score(gradename,classname,stuname,score,stuid,coursename);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return sc;
		}
		
		public  boolean updateSc(Score sc){             //教师修改成绩
			boolean flag = false;
			String sql = "update score set score = ? "+" where stuid = ?";
			try{
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setInt(1, sc.getScore());
				psmt.setInt(2, sc.getStuid());
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
}
