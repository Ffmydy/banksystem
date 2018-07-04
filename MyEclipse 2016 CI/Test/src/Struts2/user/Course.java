package Struts2.user;

public class Course {
	private String coursename;  
    private String classname;
    private int gradename;
    private String teachername;
    
    public Course(){
    	super();
    }
    
    public Course(String coursename,String classname,int gradename,String teachername){
    	super();
    	this.coursename = coursename;
    	this.classname = classname;
    	this.gradename = gradename;
    	this.teachername = teachername;
    }
    
    public Course(String coursename){
    	super();
    	this.coursename = coursename;
    }
    
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	public int getGradename() {
		return gradename;
	}
	public void setGradename(int gradename) {
		this.gradename = gradename;
	}
	public String getTeachername() {
		return teachername;
	}
	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}
}
