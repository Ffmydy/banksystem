package Struts2.user;

public class Class {
	private int classid;//学期号
	private String classname;//学期
	
	public Class() {
		super();
	}
	public Class(int classid,String classname) {
		super();
		this.classid = classid;
		this.classname = classname;
	}
	public Class(String classname){
		super();
		this.classname = classname;
	}
	
	public int getClassid() {
		return classid;
	}
	public void setClassid(int classid) {
		this.classid = classid;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	
	
}
