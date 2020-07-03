package com.dxctechnology.productassignment4;

public class Product {
	private int productCode;
	private String productName;
	private double productPrice;
	private String productCategory;
	public Product(int productCode, String productName, double productPrice, String productCategory) {
		this.productCode = productCode;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productCategory = productCategory;
	}
	public int getProductCode() {
		return productCode;
	}
	public String getProductName() {
		return productName;
	}
	@Override
	public String toString() {
		return "Product [productCode=" + productCode + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productCategory=" + productCategory + "]";
	}
	public Product() {
		super();
	}
	public double getProductPrice() {
		return productPrice;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
}
