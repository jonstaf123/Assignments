import java.io.*;
import java.sql.*;
import java.util.Properties;

public class Enroll {
	public static Connection myConn = null;
	public static PreparedStatement stmt = null;
	public static ResultSet rs = null;
	
	public static void main(String[] args) throws Exception {
		enrollStudent(3.0, 1200, "Adam", "Zapel");
		enrollStudent(2.5, 500, "Graham", "Krakir");
		enrollStudent(3.0, 800, "Ella", "Vader");
		enrollStudent(3.3, 1350, "Stanley", "kupp");
		enrollStudent(3.0, 950, "Lou", "Zar");
		assignMajor("Zapel", "Finance");
		assignMajor("Vader", "Accounting");
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
	private static void enrollStudent(double gpa,int sat,String fname, String lname) throws SQLException {
		try {
			makeConnection();
			stmt = myConn.prepareStatement("insert student(gpa,sat,first_name,last_name) values(?,?,?,?)");
			stmt.setDouble(1, gpa);
			stmt.setInt(2, sat);
			stmt.setString(3, fname);
			stmt.setString(4, lname);
			stmt.executeUpdate();
			

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			close();

		}
	}
	private static void assignMajor(String studentLastName, String Major) throws SQLException {

		try {
			makeConnection();
			stmt = myConn.prepareStatement("select * from major, student where description = ?");
			stmt.setString(1, Major);
			rs =stmt.executeQuery();
			while (rs.next()) {
				int majorID =rs.getInt("id");
				int reqSat= rs.getInt("req_sat");
				int studentSat = rs.getInt("sat");
				if (studentSat >= reqSat) {
			stmt =myConn.prepareStatement("update student set major_id = ? where last_name = ?");
			stmt.setString(2, studentLastName);
			stmt.setInt(1, majorID);
			stmt.executeUpdate();
				} else throw new Exception("does not meet SAT requirement" );
			
			
			}


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
