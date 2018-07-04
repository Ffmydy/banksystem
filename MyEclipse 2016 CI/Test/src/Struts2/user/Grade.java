package Struts2.user;

public class Grade {
	private int gradeid;//学期号
	private int gradename;//学期
	
	public Grade() {
		super();
	}
	public Grade(int gradeid,int gradename) {
		super();
		this.gradeid = gradeid;
		this.gradename = gradename;
	}
	public Grade(int gradename){
		super();
		this.gradename = gradename;
	}
	
	public int getGradeid() {
		return gradeid;
	}
	public void setGradeid(int gradeid) {
		this.gradeid = gradeid;
	}
	public int getGradename() {
		return gradename;
	}
	public void setGradename(int gradename) {
		this.gradename = gradename;
	}
	
}
