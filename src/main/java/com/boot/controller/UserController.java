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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boot.entity.UserEntity;
import com.boot.exceptions.ApiRespo;
import com.boot.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

//import io.swagger.annotations.ApiResponse;

@RestController  
@RequestMapping("/user")
@CrossOrigin("*")
@Api(value="user-controller",description="This controller contains the functionality of viewing, adding, updating and deleting the user.")
/*@Api(value="", tags= {"user-controller"})
@io.swagger.v3.oas.annotations.tags.Tag(name="user-controller", description="This controller manages the user. Through this you can view, add, update and delete a user.")*/
public class UserController 
{
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/") // end point    http:loalhost:8080/user/
	@ApiOperation(value="This functionality is used to add the user.",
    notes="You can add the user from here",
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
	public ResponseEntity<UserEntity> addUser(@RequestBody UserEntity user)   ///(@RequestBody UserEntity)---put this notation inside addUser and can remove from below------
	{
		UserEntity savedUser = this.userService.addUser(user);
        return new ResponseEntity<UserEntity>(savedUser,HttpStatus.CREATED);
		
	}
	@GetMapping("/") //It handle the HTTP GET requests matched with given URI expression.
	@ApiOperation(value="This functionality is used to get list of the user.",
    notes="You can see how many users are available from here",
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
	public ResponseEntity<List<UserEntity>> getAllUsers()
	{
	    List<UserEntity> allusers = this.userService.getAllusers();
	    return new ResponseEntity<List<UserEntity>>(allusers,HttpStatus.OK);
	}
	@GetMapping("/{userId}")
	@ApiOperation(value="This functionality is used to select user from their Id.",
    notes="You can select the user from there Id",
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
    public ResponseEntity<UserEntity> getUserById(@PathVariable("userId")int userId)
    {
        UserEntity userById=this.userService.getUserById(userId);
        return new ResponseEntity<UserEntity>(userById,HttpStatus.OK);
        
    }
	
	@PutMapping("/{userId}") // used for mapping HTTP PUT requests onto specific handler methods.
	@ApiOperation(value="This functionality is used to update the user from their Id.",
    notes="You can update the user from there Id",
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
    public ResponseEntity<UserEntity> updateUsertbyId(@RequestBody UserEntity user,@PathVariable int userId)
    {
    UserEntity updateduser = this.userService.updateUserbyId(user, userId );
        return new ResponseEntity<UserEntity>(updateduser,HttpStatus.OK);
    }
	
	@DeleteMapping("/{userId}")
	@ApiOperation(value="This functionality is used to delete the user.",
    notes="You can delete the user from here",
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
    public ResponseEntity<ApiRespo> deleteUserById(@PathVariable("userId") int userId)
    {
   this.userService.deleteUserById(userId);
   ApiRespo response = new ApiRespo();
   response.setMessage("Student Record is deleted successfully with User ID: "+userId);
   
    return new ResponseEntity<ApiRespo>(response,HttpStatus.OK);    
        
    }
	
	@GetMapping("/check")
	@ApiOperation(value="This functionality is used to login the user.",
    notes="You can login the user from here",
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
	public ResponseEntity<UserEntity> checkLogin(@RequestParam("email") String email,@RequestParam("password") String password)
	{
		
		UserEntity checkLogin = this.userService.checkLogin(email, password);
		if(checkLogin!=null)
		{
			return new ResponseEntity<UserEntity>(checkLogin,HttpStatus.OK);
		}
		else
		{
			return null;
		}
	}

}