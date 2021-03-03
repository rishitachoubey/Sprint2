package com.cg.onlinegrocery.web;
/**
 * Controller class
 * @author Rupsi
 */


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlinegrocery.domain.User;
import com.cg.onlinegrocery.service.MapValidationErrorService;
import com.cg.onlinegrocery.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userservice;
	@Autowired
	private MapValidationErrorService mapValidationErrorService;
	
	/*
	 * For registration
	 */
	
	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@Valid @RequestBody User user, BindingResult result) {
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if (errorMap != null)
			return errorMap;
		User user1 =userservice.saveOrUpdate(user);
		return new ResponseEntity<User>(user1, HttpStatus.OK);
	}
	/*
	 * View my profile
	 */
	
	@GetMapping("/{email}")
	public ResponseEntity<?> viewProfile(@PathVariable String email){
		User user = userservice.findUserByEmail(email);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	/*
	 * For login
	 */
	
	@GetMapping("/{email}/{password}")
	public ResponseEntity<?> authenticateUser(@PathVariable String email, String password)
	{
		User user=userservice.findUserByEmail(email);
		if(user==null)
			return new ResponseEntity<String>("User with email: "+email+" does not exist.",HttpStatus.OK);
		
				User user2=userservice.loginUser(email,password);
			   return new ResponseEntity<User>(user2,HttpStatus.OK);
	 }
	/*
	 * View all profiles
	 * Only admin can view all the profiles
	 */
	@GetMapping("/allProfiles")
	public Iterable<User>showAllProfiles(){
		return userservice.showAllProfiles();
	}
	/*
	 * Forgot password
	 */
	@PutMapping("/update")
	public ResponseEntity<?> forgotPassword(@Valid @RequestBody User user, BindingResult result){
		ResponseEntity<?> errorMap =  mapValidationErrorService.mapValidationError(result);
		if(errorMap!=null) return errorMap;
		User updatedUser = userservice.resetPassword(user);
		return new ResponseEntity<User>(updatedUser,HttpStatus.OK);
	}
	/*
	 * Update details
	 */
	
	@PutMapping("/updateDetails")
	public ResponseEntity<?> updateProfile(@Valid @RequestBody User user, BindingResult result)
	{
		ResponseEntity<?> errorMap =  mapValidationErrorService.mapValidationError(result);
		if(errorMap!=null) return errorMap;
		User updateUser=userservice.updateDetails(user);
		return new ResponseEntity<User>(updateUser,HttpStatus.OK);
		
	}
	
	}


