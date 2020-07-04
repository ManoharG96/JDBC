package com.dxctechnology.basicsteps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BasicStepsForJDBC {

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
			
			//step 4 : execute the query
			ResultSet set = stmt.executeQuery("SELECT * FROM customer_account_details");
			
			//step 5 : print the data or use the data from db
			while (set.next()) {
				System.out.println("Cust_id: "+set.getString(1)+" Cust_name: "+set.getString(2)+" Account No: "+set.getInt(5));
			}
			
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
