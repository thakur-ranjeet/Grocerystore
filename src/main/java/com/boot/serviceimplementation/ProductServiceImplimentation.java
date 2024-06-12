package com.boot.serviceimplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.entity.ProductEntity;
import com.boot.entity.UserEntity;
import com.boot.exceptions.ResourceNotFoundException;
import com.boot.repository.ProductRepository;
import com.boot.repository.UserRepository;
import com.boot.service.ProductService;

@Service
public class ProductServiceImplimentation implements ProductService
{
	@Autowired  // used for automatic dependency injection.
	private ProductRepository productRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Override  // informs the compiler that the element is meant to override an element declared in a superclass
	public ProductEntity addProduct(ProductEntity product) {
		// TODO Auto-generated method stub
		return this.productRepository.save(product);
	}

	@Override
	public List<ProductEntity> getAllProducts() {
		// TODO Auto-generated method stub
		return this.productRepository.findAll();
	}

	@Override
	public ProductEntity getproductbyId(int productId) {
		if(!this.productRepository.existsById(productId))
		{
			throw new ResourceNotFoundException("Product", "ProductID",productId);
		}
		else
		{
			return this.productRepository.findById(productId).get();
		}
	}

	@Override
	public void deleteProduct(int productId) {
		if(!this.productRepository.existsById(productId))
		{
			throw new ResourceNotFoundException("Product", "ProductID",productId);
		}
		else
		{
			this.productRepository.deleteById(productId);
		}
	}

	@Override
	public ProductEntity updateProductById(ProductEntity product, int productId) {
		if(!this.productRepository.existsById(productId))
		{
			throw new ResourceNotFoundException("Product", "ProductID",product.getProductId());
		}
		else
		{
			return this.productRepository.save(product);
		}
	}

	@Override
	public List<ProductEntity> getProductsBookedbyUserId(int userId) {
		UserEntity userObj=this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "User ID", userId));
		
		
		//return this.productRepository.findByUser1(userObj);
		return this.productRepository.getProductsBookedByUserId(userId);
	}

}
