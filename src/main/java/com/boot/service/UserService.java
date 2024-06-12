package com.boot.service;

import java.util.List;

import com.boot.entity.UserEntity;

public interface UserService 
{
	// To add new record of user
	public UserEntity addUser(UserEntity user);

	//To get all the users list
	public List<UserEntity> getAllusers();
	
	//To get the user record by id 
	public UserEntity getUserById(int userId);
	
	//Update the user by Id
	public UserEntity updateUserbyId(UserEntity user,int userId);
	
	//Delete student record by Id
	public void deleteUserById(int userId);
	
	public UserEntity checkLogin(String userEmail,String userPassword);
	
}
