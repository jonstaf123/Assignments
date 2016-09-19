package ssa;

import java.io.*;
import java.sql.*;
import java.util.*;

public class Students extends HashMap<Integer, Student> {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	SqlDb db = null;

	private Student loadStudentData(ResultSet rs) {

		Student student = new Student();
		try {
			student.id = rs.getInt("id");
			student.fName = rs.getString("first_name");
			student.lName = rs.getString("last_name");
			student.gpa = rs.getDouble("gpa");
			student.sat = rs.getInt("sat");
			return student;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<Student> orderByGpa() {
		List<Student> students; 
				 return students =select("Select * from student order by  gpa desc");
		
	}
	public Student getByGpa(double minGpa, double maxGpa) {
		List<Student> students = select("Select * from student where gpa >= " + minGpa + " <=" + maxGpa);
		if (students.isEmpty())
			return null;
		return students.get(0);

	}
	public Student getById(int id) {
		List<Student> students = select("Select * from student where id = " + id);
		if (students.isEmpty())
			return null;
		return students.get(0);

	}
	public void delete(Student student) {
		String SqlStatement = String.format("delete from student where id =", 
				student.id);
		try { 
			 			db.executeSqlUdate(SqlStatement); 
			 		} catch (SQLException ex) { ex.printStackTrace(); } 
	
		
	}
	public void insert(Student student) {
		String SqlStatement = String.format("insert student(first_name,last_name,gpa,sat)values('%s','%s',%f,%d)", 
				student.fName, 
				student.lName,
				student.gpa,
				student.sat);
		try { 
			 			db.executeSqlUdate(SqlStatement); 
			 		} catch (SQLException ex) { ex.printStackTrace(); } 
	
		
	}
	public void Update(Student student) {
		String SqlStatement = String.format("update student set first_name = '%s', last_name= '%s', gpa=%f, sat=%d", 
				student.fName, 
				student.lName,
				student.gpa,
				student.sat);
		try { 
			 			db.executeSqlUdate(SqlStatement); 
			 		} catch (SQLException ex) { ex.printStackTrace(); } 
	
		
	}
	public ArrayList<Student> getAll() {
		return select("Select * from student");
	}

	public ArrayList<Student> select(String sql) {
		ArrayList<Student> students = new ArrayList<Student>();

		try {

			ResultSet rs = db.executeSqlQuery(sql);
			while (rs.next()) {
				Student student = loadStudentData(rs);
				students.add(student);
			}
			return students;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	private void makeConnection() {
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream("demo.properties"));
			String theUser = prop.getProperty("user");
			String thePass = prop.getProperty("password");
			String theDburl = prop.getProperty("dburl");
			db = new SqlDb(theDburl, theUser, thePass);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Students() {
		super();
		makeConnection();
	}

}
