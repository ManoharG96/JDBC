package com.dxctechnology.instituteproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface DBUtil {
	
	public static Connection getConnection () throws SQLException, ClassNotFoundException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/assignmentdb";
		String user = "root";
		String password = "root";
		Connection con = DriverManager.getConnection(url,user,password);
		return con;
		
	}

}
