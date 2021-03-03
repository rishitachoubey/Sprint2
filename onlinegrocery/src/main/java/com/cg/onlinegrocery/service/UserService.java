package com.cg.onlinegrocery.service;



import com.cg.onlinegrocery.domain.User;


public interface UserService {
	/*
	 * This method will take details from the user and will save it in the backend.
	 * This method will perform registration
	 */
	
	public User saveOrUpdate(User user);
	/*
	 * this method will check if email exists in the database or not.
	 */
	public User findUserByEmail(String email);
	/*
	 * login method
	 */

	public User loginUser(String email, String password);
	/*
	 * this method will display all the profiles
	 */
	public Iterable<User> showAllProfiles();
	/*
	 * this method will reset the password
	 */
	public User resetPassword(User user);
	/*
	 * this method will update the details 
	 */
	public User updateDetails(User user);
	
		
	

}
