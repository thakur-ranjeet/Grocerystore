package com.boot.service;

import java.util.List;

import com.boot.entity.ProductEntity;

public interface ProductService 
{
	
	//add product
	public ProductEntity addProduct(ProductEntity course);
	
	//Get list of all products
	public List<ProductEntity> getAllProducts();
	
	//Get product by Id
	public ProductEntity getproductbyId(int productId);
	
	//Delete Product
	public void deleteProduct(int productId);
	
	//update Product
	public ProductEntity updateProductById(ProductEntity product, int productId);
	
	//List of Products booked by userID
	public List<ProductEntity> getProductsBookedbyUserId(int userId);
	

}
