package com.dxctechnology.basicsteps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCInsertUsingScanner {
	
	public static void main(String[] args) {
		
		Connection con = null;
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the Cust_Id");
		int custId = scn.nextInt();
		System.out.println("Enter the Last name");
		String lastName = scn.next();
		System.out.println("Enter the middle name");
		String middleName = scn.next();
		System.out.println("Enter the first name");
		String firstName = scn.next();	
		System.out.println("Enter the account number");
		int accNo = scn.nextInt();
		System.out.println("Enter the Account type");
		String accType = scn.next();
		System.out.println("Enter the bank branch");
		String branchName = scn.next();
		System.out.println("Enter the mail id");
		String mailId = scn.next();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/bankingdb";
			String user = "root";
			String password = "root";
			con = DriverManager.getConnection(url,user,password);
			
			Statement stmt = con.createStatement();
			
			int count= stmt.executeUpdate("insert into Customer_Account_Details values("+custId+",'"+lastName+"','"+middleName+"','"+firstName+"',"+accNo+",'"+accType+"','"+branchName+"','"+mailId+"')");
			
			System.out.println("inserted the values "+count);
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			
		} finally {
			
			try {
				con.close();
				scn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				
			}
		}
	}
}
