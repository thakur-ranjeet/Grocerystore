package com.boot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
// 2.Product(productId,productName,productCategory,productPrice,userId)
@Entity
@Table(name="product")
public class ProductEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productId;
	
	@Column(nullable = false,length = 20)
	private String productName;
	
	@Column(nullable = false,length = 20)
	private String productCategory;
	
	@Column(nullable = false,length = 20)
	private int productPrice;
	
	@ManyToOne  //a single-valued association to another entity class that has many-to-one multiplicity.
	@JoinColumn(name="uid")
	//@JsonIgnore
	private UserEntity user1;

	public int getProductId() {      // used to protect your data, particularly when creating classes.
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public UserEntity getUser() {
		return user1;
	}

	public void setUser(UserEntity user) {
		this.user1 = user;
	}

	public ProductEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ProductEntity [productId=" + productId + ", productName=" + productName + ", productCategory="
				+ productCategory + ", productPrice=" + productPrice + ", user1=" + user1 + "]";
	}
	
	
}
