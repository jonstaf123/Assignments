package ssa;

import java.util.*;

public class Mainline {

	public static void main(String[] args) {
	    
		Students students = new Students();
		// retrieve a single student with id = 1
		Student aStudent = students.getById(110);
		// display the student
		System.out.println(aStudent); // displays the student data in a
										// formatted way
		// retrieve all the students into a collection
		ArrayList<Student> allStudents = students.getAll();
		// iterate through the collection and display each student data in a
		// formatted way
		for (Student student : allStudents) {
			System.out.println(student);
		}
	    
	    List<Student> gpaStudents = students.orderByGpa();
	    for(Student student : gpaStudents) {
	        System.out.println(student);
	    }
}
}