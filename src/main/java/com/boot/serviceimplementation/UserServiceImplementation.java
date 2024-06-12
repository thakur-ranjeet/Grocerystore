package com.boot.serviceimplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.entity.UserEntity;
import com.boot.exceptions.ResourceNotFoundException;
import com.boot.repository.UserRepository;
import com.boot.service.UserService;

@Service
public class UserServiceImplementation implements UserService 
{
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserEntity addUser(UserEntity user) {
		// TODO Auto-generated method stub
		return this.userRepository.save(user);
	}

	@Override
	public List<UserEntity> getAllusers() {
		// TODO Auto-generated method stub
		return this.userRepository.findAll();

	}

	@Override
	public UserEntity getUserById(int userId) {
		// TODO Auto-generated method stub
		return this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "User ID", userId));
	}

	@Override
	public UserEntity updateUserbyId(UserEntity user, int userId) {
		// TODO Auto-generated method stub
	    if(!this.userRepository.existsById(userId))
        {
            
            throw new ResourceNotFoundException("user" , "user Id",userId);
            
        }
        
        return this.userRepository.save(user);
    }

	@Override
	public void deleteUserById(int userId) {
		// TODO Auto-generated method stub
		if(!this.userRepository.existsById(userId))
        {
            
            throw new ResourceNotFoundException("User" , "User ID", userId);
            
            }
        else
        {
            this.userRepository.deleteById(userId);
        }
       
    }

	@Override
	public UserEntity checkLogin(String userEmail, String userPassword) {
		UserEntity user = this.userRepository.findByUserEmailAndUserPassword(userEmail, userPassword);
		return user;
	}
	

}
