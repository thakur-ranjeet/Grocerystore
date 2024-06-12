package com.boot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.boot.entity.ProductEntity;
import com.boot.entity.UserEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer>
{
	
	List<ProductEntity>  findByUser1(UserEntity user);

	// Custom SQL Native Query(suppose we don't want to use inbuilt method of Hibernate then we can use Custom) 
	
	@Query(value="select * from product p where p.uid=:userId",nativeQuery = true)
	List<ProductEntity>  getProductsBookedByUserId(@Param("userId") int userId);
}
