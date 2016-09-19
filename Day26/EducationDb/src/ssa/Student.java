package ssa;

public class Student {
	int id; 
	String fName; 
	String lName; 
	double gpa; 
	int sat; 
	 
	@Override 
public String toString() { 
	String msg = String.format("%3d %-20s %4.2f  %4d", 
	this.id, 
	this.fName + " " + this.lName, 
	this.gpa, 
	this.sat); 
	return msg; 
		} 
	
	 } 
