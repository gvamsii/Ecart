package com.ecart.miracle.Services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.ecart.miracle.Repo.UserRepo;
import com.ecart.miracle.models.User;

@Service
public class UserService {

	@Autowired
	UserRepo userRepo;

	public User userregistration(User user) {
		return userRepo.save(user);
	}
	
	public List getall(User user) {
		return userRepo.findAll();
	}

}
