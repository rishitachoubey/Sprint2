package com.cg.onlinegrocery.serviceimpl;
/**
 * This class will implement all the methods from service interface
 * @author Rupsi
 *
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlinegrocery.domain.User;
import com.cg.onlinegrocery.exception.UserIdException;
import com.cg.onlinegrocery.exception.UserNotFoundException;
import com.cg.onlinegrocery.repository.UserRepository;
import com.cg.onlinegrocery.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	
	@Autowired
	private UserRepository userRepo;
	/*
	 * This method will start the login process
	 */
	@Override
	public User loginUser(String email, String password) {
		User user=userRepo.findByEmail(email);
		try {
			if(!(user.getPassword().equals(password)))
				throw new UserNotFoundException("Invalid credentials!! Check your credentials");
			
		}
		catch (Exception e)
		{
			e.getMessage();
		}
		return user;
		}
	/*
	 * This method will start the registration process
	 */

	@Override
	public User saveOrUpdate(User user) {
		try {
			
			return userRepo.save(user);
			}
			catch(Exception e)
			{
				throw new UserIdException("User email : "+user.getEmail()+" already exists");
			}
	}
     /*
      * This method will check if the email exists in the database or not
      */
    @Override
	public User findUserByEmail(String email) {
		User user = userRepo.findByEmail(email);
		if (user == null) {
			throw new UserIdException("User Id : " + email + " does not exist");
		}
		return user;
	}
   /*
    * this method will display all the profiles 
    */
	@Override
	public Iterable<User> showAllProfiles() {
		return userRepo.findAll();
		
	}
	/*
	 * This method will reset password
	 */

	@Override
	public User resetPassword(User user) {
		try {
		User user1=userRepo.findByEmail(user.getEmail());
		if(user1.getEmail().equals(user.getEmail()))
			user1.setPassword(user.getPassword());
		user.setPassword(user.getPassword());
		return userRepo.save(user1);
		}
		catch(Exception e)
		{
			throw new UserNotFoundException("Email does not exist.");
		}
	}
	/*
	 * This method will update details
	 */
    @Override
	public User updateDetails(User user) {
		try {
			User updateUser1 =userRepo.findByEmail(user.getEmail());
			updateUser1.setName(user.getName());
		    updateUser1.setPhone(user.getPhone());
			return  userRepo.save(updateUser1);
			}
		catch(Exception e)
			{ 
				throw new UserNotFoundException("Email doesn't Exist");
			}
		
	}


}
