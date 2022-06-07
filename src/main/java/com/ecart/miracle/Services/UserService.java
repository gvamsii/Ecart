package com.ecart.miracle.Services;



import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecart.miracle.Repo.UserRepo;
import com.ecart.miracle.models.User;

@Service
public class UserService {
 
	@Autowired
	
	UserRepo userRepo;

	/*This method is for user registration. 
	 After the user entered the details, that details are stored in object temporarily, 
	 after verification of mail that details are stored in database. */
	public User userRegistration(User user) {
		return userRepo.save(user); 
	}
	
	
	/*This method is for user login.In login page user will enter 
	 user id and password that details are checks with user database
      based on user id. If both are match the user login is successful.  */
	public List<User> login(Long mobile)
	{	
		return userRepo.getByMobile(mobile);
	}
	public List<User> login1(String email)
	{	
		return userRepo.getByEmail(email);
	}
 

} 
