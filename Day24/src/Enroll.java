import java.io.*;
import java.sql.*;
import java.util.Properties;

public class Enroll {
	public static Connection myConn = null;
	public static PreparedStatement stmt = null;
	public static ResultSet rs = null;
	
	public static void main(String[] args) throws Exception {
		enrollStudent();
		updateStudent();
		fetchData();
		
	}
	private static void makeConnection() throws FileNotFoundException, IOException, SQLException {

		Properties prop = new Properties();
		prop.load(new FileInputStream("demo.properties"));
		String theUser = prop.getProperty("user");
		String thePass = prop.getProperty("password");
		String theDburl = prop.getProperty("dburl");

		myConn = (Connection) DriverManager.getConnection(theDburl, theUser, thePass);
	}
	public static void close() throws SQLException {
		if (myConn != null)
			myConn.close();
		if (stmt != null)
			stmt.close();
		if (rs != null)
			rs.close();
	}
	private static void enrollStudent() throws SQLException {
		try {
			makeConnection();
			stmt = myConn.prepareStatement("insert student(gpa,sat,first_name,last_name,major_id) values(?,?,?,?,?)");
			stmt.setDouble(1, 3.0);
			stmt.setInt(2, 1200);
			stmt.setString(3, "Adam");
			stmt.setString(4, "Zapel");
			stmt.setInt(5, 3);
			stmt.executeUpdate();
			
			stmt = myConn.prepareStatement("insert student(gpa,sat,first_name,last_name,major_id) values(?,?,?,?,?)");
			stmt.setDouble(1, 2.5);
			stmt.setInt(2, 500);
			stmt.setString(3, "Graham");
			stmt.setString(4, "Krakir");
			stmt.setInt(5, 7);
			stmt.executeUpdate();
			
			stmt = myConn.prepareStatement("insert student(gpa,sat,first_name,last_name,major_id) values(?,?,?,?,?)");
			stmt.setDouble(1, 3.0);
			stmt.setInt(2, 800);
			stmt.setString(3, "Ella");
			stmt.setString(4, "Vader");
			stmt.setInt(5, 2);
			stmt.executeUpdate();
			
			stmt = myConn.prepareStatement("insert student(gpa,sat,first_name,last_name,major_id) values(?,?,?,?,?)");
			stmt.setDouble(1, 3.3);
			stmt.setInt(2, 1350);
			stmt.setString(3, "Stanley");
			stmt.setString(4, "Kupp");
			stmt.setInt(5, 5);
			stmt.executeUpdate();
			
			stmt = myConn.prepareStatement("insert student(gpa,sat,first_name,last_name,major_id) values(?,?,?,?,?)");
			stmt.setDouble(1, 3.0);
			stmt.setInt(2, 950);
			stmt.setString(3, "Lou");
			stmt.setString(4, "Zar");
			stmt.setInt(5, 6);
			stmt.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			close();

		}
	}
	private static void updateStudent() throws SQLException {

		try {
			makeConnection();
			stmt = myConn.prepareStatement("update student, major set Major_id= ? where student.id = ? and sat >= req_sat");
			stmt.setInt(1, 3);
			stmt.setInt(2, 1);
			stmt.executeUpdate();
			
			stmt = myConn.prepareStatement("update student, major set Major_id= ? where student.id = ? and sat >= req_sat");
			stmt.setInt(1, 7);
			stmt.setInt(2, 2);
			stmt.executeUpdate();
			
			stmt = myConn.prepareStatement("update student, major set Major_id= ? where student.id = ? and sat >= req_sat");
			stmt.setInt(1, 2);
			stmt.setInt(2, 3);
			stmt.executeUpdate();

			stmt = myConn.prepareStatement("update student, major set Major_id= ? where student.id = ? and sat >= req_sat");
			stmt.setInt(1, 5);
			stmt.setInt(2, 4);
			stmt.executeUpdate();
			
			stmt = myConn.prepareStatement("update student, major set Major_id= ? where student.id = ? and sat >= req_sat");
			stmt.setInt(1, 6);
			stmt.setInt(2, 5);
			stmt.executeUpdate();


		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			close();

		}
	}
	public static void display() throws Exception {
		while (rs.next()) {
			String fName = rs.getString("first_name");
			String lName = rs.getString("last_name");
			int sat = rs.getInt("sat");
			int reqSat= rs.getInt("req_sat");
			String description = rs.getString("description");
			System.out.printf("Enrolled %s %s as a new student\n",fName,lName);
			System.out.printf("%s %s has an SAT score of %d\n",fName,lName,sat);
			System.out.printf("Assigned %s %s to the %s which requires a required SAT score of %d\n",fName,lName,description,reqSat);
			System.out.println();
		}
	}
	private static void fetchData() throws Exception {
		try {
			makeConnection();
			stmt = myConn.prepareStatement("select * from student,major where student.id > ?");
			stmt.setInt(1, 190);
			rs = stmt.executeQuery();
			
			display();

		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			close();
		}
	}

}
