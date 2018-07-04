package Struts2.user;

public class Stu {
	private String stuname;//ÓÃ»§ÕÊºÅ
	private String stupass;//ÃÜÂë
	private int stuid;
	private String stusex;
	private String classname;
	
	public Stu() {
		super();
	}

	public Stu(int stuid,String stuname,String stusex, String stupass,String classname) {
		super();
		this.stuid = stuid;
		this.stuname = stuname;
		this.stusex = stusex;
		this.stupass = stupass;
		this.classname = classname;
	}

	public String getStuname() {
		return stuname;
	}

	public void setStuname(String stuname) {
		this.stuname = stuname;
	}

	public String getStupass() {
		return stupass;
	}

	public void setStupass(String stupass) {
		this.stupass = stupass;
	}

	public int getStuid() {
		return stuid;
	}

	public void setStuid(int stuid) {
		this.stuid = stuid;
	}

	public String getStusex() {
		return stusex;
	}

	public void setStusex(String stusex) {
		this.stusex = stusex;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}






}
