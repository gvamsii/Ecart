package com.ecart.miracle.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecart.miracle.Services.UserService;
import com.ecart.miracle.models.User;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/userregistration")
	public User userlogin(@RequestBody User user) {
		return userService.userregistration(user);
	}
	
	@GetMapping("/getall")
	public List getall(@RequestBody User user) {
		return userService.getall(user);
	}
	
	

}
