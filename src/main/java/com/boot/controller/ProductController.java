package com.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.entity.ProductEntity;
import com.boot.entity.UserEntity;
import com.boot.exceptions.ApiRespo;
import com.boot.service.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
//import io.swagger.v3.oas.annotations.responses.ApiResponses;

import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;





@RestController
@RequestMapping("/product")
@CrossOrigin("*") // enables cross-origin resource sharing only for this specific method.
@Api(value="product-controller",description="This controller contains the functionality of viewing, adding, updating and deleting the product.")

//@io.swagger.v3.oas.annotations.tags.Tag(name="product-controller", description="This controller manages the product. Through this you can view, add, update and delete a product.")
public class ProductController 
{
	
	@Autowired
	private ProductService productService;
	
	
	@PostMapping("/")
	@ApiOperation(value="This functionality is used to add the product.",
    notes="You can add the product from here",
    response=UserEntity.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "HTTP 200 OK success operation response code indicates that the request has succeeded."),
	        @ApiResponse(code = 201, message = "The 201 created status code that the server has fulfilled the browser's request, and as a result, has created a new resource"),
	        @ApiResponse(code = 400, message = "The HTTP code Bad Request 400 indicates a client error"),
	        @ApiResponse(code = 401, message = "The HTTP code 401 Unauthorized Access is denied due to invalid credentials"),
	        @ApiResponse(code = 403, message = "The HTTP 403 Forbidden response status code indicates that the server understands the request but refuses to authorize it."),
	        @ApiResponse(code = 404, message = "The HTTP 404 Not Found response status code indicates that the server cannot find the requested resource."),
	        }
	)
	public ResponseEntity<ProductEntity> addProduct(@RequestBody ProductEntity product)
	{
		System.out.println("***************************");
		System.out.println(product);
		
		
		ProductEntity addedProduct = this.productService.addProduct(product);
		return new ResponseEntity<ProductEntity>(addedProduct,HttpStatus.CREATED);
	}
	//Get the list of Products booked by any particular user
	@GetMapping("/user/{userId}")
	@ApiOperation(value="This functionality is used to get all list of the product booked by user.",
		    
    notes="You can see how many products booked by user",
    response=UserEntity.class)
@ApiResponses(value = {
		@ApiResponse(code = 200, message = "HTTP 200 OK success operation response code indicates that the request has succeeded."),
        @ApiResponse(code = 201, message = "The 201 created status code that the server has fulfilled the browser's request, and as a result, has created a new resource"),
        @ApiResponse(code = 400, message = "The HTTP code Bad Request 400 indicates a client error"),
        @ApiResponse(code = 401, message = "The HTTP code 401 Unauthorized Access is denied due to invalid credentials"),
        @ApiResponse(code = 403, message = "The HTTP 403 Forbidden response status code indicates that the server understands the request but refuses to authorize it."),
        @ApiResponse(code = 404, message = "The HTTP 404 Not Found response status code indicates that the server cannot find the requested resource."),
        }
)
	public ResponseEntity<List<ProductEntity>> getAllproductsBookedByUser(@PathVariable int userId)
	{
		List<ProductEntity> productsBookedbyUserId = this.productService.getProductsBookedbyUserId(userId);
		return new ResponseEntity<List<ProductEntity>>(productsBookedbyUserId,HttpStatus.OK);
	}
	
	//Get All Products
	@GetMapping("/")
	@ApiOperation(value="This functionality is used to get all list of the product.",
    notes="You can see how many products are available from here",
    response=UserEntity.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "HTTP 200 OK success operation response code indicates that the request has succeeded."),
	        @ApiResponse(code = 201, message = "The 201 created status code that the server has fulfilled the browser's request, and as a result, has created a new resource"),
	        @ApiResponse(code = 400, message = "The HTTP code Bad Request 400 indicates a client error"),
	        @ApiResponse(code = 401, message = "The HTTP code 401 Unauthorized Access is denied due to invalid credentials"),
	        @ApiResponse(code = 403, message = "The HTTP 403 Forbidden response status code indicates that the server understands the request but refuses to authorize it."),
	        @ApiResponse(code = 404, message = "The HTTP 404 Not Found response status code indicates that the server cannot find the requested resource."),
	        }
	)
	
	public ResponseEntity<List<ProductEntity>> getAllProductList()
	{
		List<ProductEntity> allProducts = this.productService.getAllProducts();
		return new ResponseEntity<List<ProductEntity>>(allProducts,HttpStatus.OK);
	}
	
	@GetMapping("/{productId}")
	@ApiOperation(value="This functionality is used to get the product from Id.",
    notes="You can see the products from here by Id",
    response=UserEntity.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "HTTP 200 OK success operation response code indicates that the request has succeeded."),
	        @ApiResponse(code = 201, message = "The 201 created status code that the server has fulfilled the browser's request, and as a result, has created a new resource"),
	        @ApiResponse(code = 400, message = "The HTTP code Bad Request 400 indicates a client error"),
	        @ApiResponse(code = 401, message = "The HTTP code 401 Unauthorized Access is denied due to invalid credentials"),
	        @ApiResponse(code = 403, message = "The HTTP 403 Forbidden response status code indicates that the server understands the request but refuses to authorize it."),
	        @ApiResponse(code = 404, message = "The HTTP 404 Not Found response status code indicates that the server cannot find the requested resource."),
	        }
	)
	public ResponseEntity<ProductEntity> getProductById(@PathVariable("productId") int productId )
	{
		ProductEntity getproductbyId = this.productService.getproductbyId(productId);
		return new ResponseEntity<ProductEntity>(getproductbyId,HttpStatus.OK);
	}
	
	@PutMapping("/{productId}")
	@ApiOperation(value="This functionality is used to update the product By Id.",
    notes="You can update the product from here",
    response=UserEntity.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "HTTP 200 OK success operation response code indicates that the request has succeeded."),
	        @ApiResponse(code = 201, message = "The 201 created status code that the server has fulfilled the browser's request, and as a result, has created a new resource"),
	        @ApiResponse(code = 400, message = "The HTTP code Bad Request 400 indicates a client error"),
	        @ApiResponse(code = 401, message = "The HTTP code 401 Unauthorized Access is denied due to invalid credentials"),
	        @ApiResponse(code = 403, message = "The HTTP 403 Forbidden response status code indicates that the server understands the request but refuses to authorize it."),
	        @ApiResponse(code = 404, message = "The HTTP 404 Not Found response status code indicates that the server cannot find the requested resource."),
	        }
	)
	public ResponseEntity<ProductEntity> updateProduct(@RequestBody ProductEntity product,@PathVariable("productId")int productId)
	{
		ProductEntity updatedProduct = this.productService.updateProductById(product, productId);
		return new ResponseEntity<ProductEntity>(updatedProduct,HttpStatus.OK);
	}
	
	@DeleteMapping("/{productId}")
	@ApiOperation(value="This functionality is used to delete the product by Id.",
    notes="You can delete the product from here",
    response=UserEntity.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "HTTP 200 OK success operation response code indicates that the request has succeeded."),
	        @ApiResponse(code = 201, message = "The 201 created status code that the server has fulfilled the browser's request, and as a result, has created a new resource"),
	        @ApiResponse(code = 400, message = "The HTTP code Bad Request 400 indicates a client error"),
	        @ApiResponse(code = 401, message = "The HTTP code 401 Unauthorized Access is denied due to invalid credentials"),
	        @ApiResponse(code = 403, message = "The HTTP 403 Forbidden response status code indicates that the server understands the request but refuses to authorize it."),
	        @ApiResponse(code = 404, message = "The HTTP 404 Not Found response status code indicates that the server cannot find the requested resource."),
	        }
	)
	public ResponseEntity<ApiRespo>deleteprductById(@PathVariable("productId")int ProductId)
	{
		this.productService.deleteProduct(ProductId);
		ApiRespo response = new ApiRespo();
		response.setMessage("Product Record is deleted Successfully");
		response.setStatus(true);
		return new ResponseEntity<ApiRespo>(response,HttpStatus.OK);
	}

}
