package Struts2.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Struts2.user.Score;
import Struts2.user.Stu;
import Struts2.util.DbConn;

	public class StuDao {
		private static Connection conn = DbConn.getConn();
		  public boolean isLogin(Stu stu){
			  boolean flag=false;
			  String sql="select * from stu where stuid=? and stupass=?";
			  try {
				PreparedStatement pmst=conn.prepareStatement(sql);
				pmst.setString(1, stu.getStuname());
				pmst.setString(2, stu.getStupass());
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
		  
		public  List ListStu() //管理员显示学生列表
			{
				Stu stu=null;
				List list = new ArrayList();
				String sql = "select * from stu";
				try {
					Statement smt = conn.createStatement();
					ResultSet rs = smt.executeQuery(sql);
					while (rs.next()) {
						int stuid = rs.getInt("stuid");
						String stuname = rs.getString("stuname");
						String stusex = rs.getString("stusex");
						String stupass = rs.getString("stupass");
						String classname = rs.getString("classname");
						stu = new Stu(stuid,stuname,stusex,stupass,classname);
						list.add(stu);
					}
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				return list;
			}
			
			public  boolean addStu(Stu stu) {
				boolean flag = false;
				String sql = "insert into stu(stuid,stuname,stusex,stupass,classname) "
						+ "values(?,?,?,?,?)";
				try {
					PreparedStatement psmt = conn.prepareStatement(sql);
					psmt.setInt(1, stu.getStuid());
					psmt.setString(2, stu.getStuname());
					psmt.setString(3, stu.getStusex());
					psmt.setString(4, stu.getStupass());
					psmt.setString(5, stu.getClassname());
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
			
			public  Stu SStu(int stuid){
				Stu stu = null;
				String sql = "select * from stu where stuid = ?";
				try{
					PreparedStatement psmt = conn.prepareStatement(sql);
					psmt.setInt(1, stuid);
					ResultSet rs = psmt.executeQuery();
					while (rs.next()){
						int stuid1 = rs.getInt("stuid");
						String stuname = rs.getString("stuname");
						String stusex = rs.getString("stusex");
						String stupass = rs.getString("stupass");
						String classname = rs.getString("classname");
						stu = new Stu(stuid1,stuname,stusex,stupass,classname);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return stu;
			}
			public boolean updateS(Stu stu){             //修改学生信息
				boolean flag = false;
				String sql = "update stu set stuname=?,stusex=?,stupass=?,classname=?"+"where stuid=?";
				try{
					PreparedStatement psmt = conn.prepareStatement(sql);
					psmt.setString(1, stu.getStuname());
					psmt.setString(2, stu.getStusex());
					psmt.setString(3, stu.getStupass());
					psmt.setString(4,stu.getClassname());
					psmt.setInt(5, stu.getStuid());
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
			
		public  List Listss(int stuid) 						//学生查看成绩列表
			{
				Score ss=null;
				List list = new ArrayList();
				String sql = "select * from score where stuid = ?";
				try {
					PreparedStatement psmt = conn.prepareStatement(sql);
					psmt.setInt(1, stuid);
					ResultSet rs = psmt.executeQuery();
					while (rs.next()) {
						String coursename = rs.getString("coursename");
						int score = rs.getInt("score");
						ss = new Score(coursename,score);
						list.add(ss);
					}
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				return list;
			}
}
