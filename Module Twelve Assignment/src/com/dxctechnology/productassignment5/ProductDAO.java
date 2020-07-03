package com.dxctechnology.productassignment5;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductDAO {

	public boolean insertProducts(Product products) throws ClassNotFoundException, SQLException {
		Connection con = DBUtil.getConnection();
		Statement statement = con.createStatement();
		boolean result = false;
		String query = "INSERT INTO products VALUES ("+products.getProductCode()+",'"+products.getProductName()+"',"
				+products.getProductPrice()+",'"+products.getProductCategory()+"')";
		int count = statement.executeUpdate(query);
		if (count!=0) {
			result = true;
		}
		return result;
	}

	public Product getProduct(int prodCode) throws ClassNotFoundException, SQLException {
		Connection con = DBUtil.getConnection();
		Statement statement = con.createStatement();
		String query = "SELECT * FROM products WHERE prod_code = "+prodCode ; //SELECT * FROM products WHERE prod_code = 100
		ResultSet set = statement.executeQuery(query);
		Product product = new Product();;
		
		if (set.next()) {
			int productId = set.getInt("prod_code");
			product.setProductCode(productId);
			product.setProductName(set.getString("prod_name"));
			product.setProductPrice(set.getInt("prod_price"));
			product.setProductCategory(set.getString("prod_cate"));
		}
		return product;

	}

}
