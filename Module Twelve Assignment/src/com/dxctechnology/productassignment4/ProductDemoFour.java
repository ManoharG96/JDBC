package com.dxctechnology.productassignment4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProductDemoFour {

	public static void main(String[] args) {
		Connection con = null;
		int eleCount = 0;
		int cloCount = 0;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/assignmentdb";
			String user = "root";
			String password = "root";
			con = DriverManager.getConnection(url,user,password);

			Statement stmt = con.createStatement();
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);

			ResultSet set = stmt.executeQuery("SELECT * FROM PRODUCTS");
			ArrayList<Product> list = new ArrayList<Product>();
			
			while (set.next()) {
				Product product = new Product();
				product.setProductCode(set.getInt("prod_code"));
				product.setProductName(set.getString("prod_name"));
				product.setProductPrice(set.getInt("prod_price"));
				product.setProductCategory(set.getString("prod_cate"));
				list.add(new Product(product.getProductCode(), product.getProductName(), product.getProductPrice(),product.getProductCategory()));
				
				double price = set.getDouble("prod_price");
				String category = set.getString("prod_cate");
				if (price < 1000 && category.equalsIgnoreCase("electronics")) {
					set.updateDouble("prod_price", (price * 0.1)+price);
					set.updateRow();
					eleCount ++;
				}
				if (price > 1000 && category.equalsIgnoreCase("clothings")) {
					set.updateDouble("prod_price", price - (price * 0.1));
					set.updateRow();
					cloCount ++;
				}
			}
			for (Product info : list) {
				System.out.println(info);
			}
			System.out.println(eleCount+" Updated for electronics rows");
			System.out.println(cloCount+" Updated for clothings rows");

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

