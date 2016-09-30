package com.ssa.entity;

import javax.persistence.*;


@Entity
@Table(name="student")
public class Student {
	//id, first_name, last_name, sat, gpa, major_id
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	int id;
	
	
	@Column(name="sat")
	int sat;
	
	@Column(name="first_name")
	String fname;
	
	@Column(name="last_name")
	String lname;
	
	@Column(name="gpa")
	double gpa;
	
	@Column(name="major_id")
	int majorId;
	
	public Student(){}
	public Student(int sat, String fname, String lname, double gpa, int majorId) {
		
		this.sat = sat;
		this.fname = fname;
		this.lname = lname;
		this.gpa = gpa;
		this.majorId=majorId;
	}

	public int getMajorId() {
		return majorId;
	}

	public void setMajorId(int majorId) {
		this.majorId = majorId;
	}

	public int getSat() {
		return sat;
	}

	public void setSat(int sat) {
		this.sat = sat;
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

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
}
