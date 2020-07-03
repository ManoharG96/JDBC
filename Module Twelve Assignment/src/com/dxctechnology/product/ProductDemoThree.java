package com.dxctechnology.product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import com.dxctechnology.productassignment4.Product;

public class ProductDemoThree {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		Connection con= null;
		ArrayList<Product> productList = new ArrayList<Product>();
		int count = 0;

		System.out.println("enter the no of products to be inserted");
		int noOfProducts = scn.nextInt();
		for (int i = 0; i < noOfProducts ; i++) {
			System.out.println("Enter the product code");
			int productCode = scn.nextInt();
			System.out.println("enter the product name");
			String productName = scn.next();
			System.out.println("enter the product price");
			double productPrice = scn.nextDouble();
			System.out.println("enter the product category");
			String productCategory = scn.next();
			Product product = new Product(productCode, productName, productPrice, productCategory);
			productList.add(product);
		}

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/assignmentdb";
			String user = "root";
			String password = "root";
			con = DriverManager.getConnection(url,user,password);

			Statement stmt = con.createStatement();
			for (Product product : productList) {
				count = stmt.executeUpdate("INSERT INTO products VALUES ("+product.getProductCode()+",'"+product.getProductName()+"',"
						+ ""+product.getProductPrice()+",'"+product.getProductCategory()+"')");
			}
			if (count!=0)
				System.out.println("Records had been added to the products table "+count);
			else 
				System.out.println("please check there is error");

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
