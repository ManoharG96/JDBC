package com.dxctechnology.product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductDemoOne {

	public static void main(String[] args) {
		Connection con = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/assignmentdb";
			String user = "root";
			String password = "root";
			con = DriverManager.getConnection(url,user,password);

			Statement stmt = con.createStatement();

			ResultSet set = stmt.executeQuery("SELECT * FROM PRODUCTS");

			while (set.next()) {
				System.out.println("Product Id : "+set.getInt(1)+" Product Name : "+set.getString(2)+" Product Price : "
						+set.getInt(3)+" Product Category : "+set.getString(4));
			}

		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());

		} catch (SQLException e) {
			System.out.println(e.getMessage());

		} finally {

			try {
				con.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());

			}
		}

	}

}
