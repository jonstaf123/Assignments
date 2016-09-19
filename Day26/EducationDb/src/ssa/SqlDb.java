package ssa;

import java.sql.*;

import com.mysql.jdbc.Connection;

public class SqlDb {

	public static ResultSet rs = null;
	String theDburl = null;
	String theUser = null;
	String thePass = null;
	public Connection myConn = null;

	public SqlDb(String theDburl, String theUser, String thePass) throws SQLException {
		myConn = (Connection) DriverManager.getConnection(theDburl, theUser, thePass);
	}

	public void close() throws SQLException {
		if (myConn != null) {
			myConn.close();
			myConn = null;
		}
	}
	public void executeSqlUdate(String sql) throws SQLException {
		Statement stmt = myConn.createStatement();
		try {
			 stmt.executeUpdate(sql);
			
		} catch (SQLException ex) {
			throw ex;
		}

	}
	public ResultSet executeSqlQuery(String sql) throws SQLException {
		Statement stmt = myConn.createStatement();
		try {
			ResultSet rs = stmt.executeQuery(sql);
			return rs;
		} catch (SQLException ex) {
			throw ex;
		}

	}

	
}
