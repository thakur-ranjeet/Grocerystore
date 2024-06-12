package com.boot.repository;

//provides the mechanism for storage, retrieval, search, update and delete operation on objects.
import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer>
{
	UserEntity findByUserEmailAndUserPassword(String userEmail,String user);
}
