package com.boot.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/*1. User(yserId,userName,userEmail,userPassword,,userAge,userMobileNo,userCity)
 *                      @oneToMany        &    @ManyToMany
  2. Product(productId,productName,productCategory,productPrice,userId) 
 * 
 */
@Entity
@Table(name="user")
public class UserEntity 
{
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int userId;
	
	@Column(nullable = false,length = 20)
	private String userName;
	
	@Column(unique = true)
	private String userEmail;
	
	@Column(nullable = false,length = 10)
	private String userPassword;
	
	@Column(nullable = false)
	private String userAge;
	
	@Column(nullable = false)
	private String userCity;
	
	@OneToMany(mappedBy = "user1",cascade = CascadeType.ALL)
	@JsonIgnore
	private List<ProductEntity> productList = new ArrayList();
	
	

	public List<ProductEntity> getProductList() {
		return productList;
	}

	public void setProductList(List<ProductEntity> productList) {
		this.productList = productList;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserAge() {
		return userAge;
	}

	public void setUserAge(String userAge) {
		this.userAge = userAge;
	}

	public String getUserCity() {
		return userCity;
	}

	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}

	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "UserEntity [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail
				+ ", userPassword=" + userPassword + ", userAge=" + userAge + ", userCity=" + userCity
				+ ", productList=" + productList + "]";
	}
	
	

	

	

}
