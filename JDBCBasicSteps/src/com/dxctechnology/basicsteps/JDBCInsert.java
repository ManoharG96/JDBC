package com.dxctechnology.basicsteps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCInsert {

	public static void main(String[] args) {
		Connection con = null;
		
		try {
			//step 1 : Loading the class
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//step 2 : Connection to the database
			String url = "jdbc:mysql://localhost:3306/bankingdb";
			String user = "root";
			String password = "root";
			con = DriverManager.getConnection(url,user,password);
			
			//step 3 : create statement
			Statement stmt = con.createStatement();
			
			//step 4 : execute the insert query
			int count= stmt.executeUpdate("insert into Customer_Account_Details values(126,'Vinod','P','Gowda',6541,'savings','gadag','vinod@gmail.com')");
			
			//step 5 : print the count
			System.out.println("inserted the values "+count);
			
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			
		} finally {
			//step 6 : closing the connection
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				
			}
		}
	}
}
