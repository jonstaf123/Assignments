package eddb;

public class Student {
	int id;
	String fname;
	String lname;
	int sat;
	double gpa;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public int getSat() {
		return sat;
	}
	public void setSat(int sat) {
		this.sat = sat;
	}
	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	public Student(String fname, String lname, int sat, double gpa) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.sat = sat;
		this.gpa = gpa;
	}
}
