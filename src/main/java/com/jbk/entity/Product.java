package com.jbk.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	@Column(name="product_id",unique=true, nullable=false)
	private long productId;
	
	@Column(name="product_name",unique=true,nullable=false)
	private String productName;
	
	@Column(name="product_qty",unique=false,nullable=false)
	private int productQty;
	
	@Column(name="product_price",unique=false,nullable=false)
	private double productPrice;
	
	@Column(name="mfg_date",unique=false,nullable=false)
	private String mfgDate;
	
	@Column(name="exp_date",unique=false,nullable=false)
	private String expDate;
	
	public Product() {
		super();
		
	}
	public Product(long productId, String productName, int productQty, double productPrice, String mfgDate,
			String expDate) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productQty = productQty;
		this.productPrice = productPrice;
		this.mfgDate = mfgDate;
		this.expDate = expDate;
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductQty() {
		return productQty;
	}
	public void setProductQty(int productQty) {
		this.productQty = productQty;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public String getMfgDate() {
		return mfgDate;
	}
	public void setMfgDate(String mfgDate) {
		this.mfgDate = mfgDate;
	}
	public String getExpDate() {
		return expDate;
	}
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productQty=" + productQty
				+ ", productPrice=" + productPrice + ", mfgDate=" + mfgDate + ", expDate=" + expDate + "]";
	}
	
	
	
	
	

}
