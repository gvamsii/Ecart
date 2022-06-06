package com.ecart.miracle.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecart.miracle.Repo.UserRepo;
import com.ecart.miracle.Services.UpdatedQuantityService;
import com.ecart.miracle.models.User;

@RestController
@RequestMapping
public class QuanityController {
	
	@Autowired
	UpdatedQuantityService updatedQuantityService;
	
	@Autowired
	UserRepo userRepo;

	//This method is to increase the quantity in addtocart page
	@CrossOrigin
	@PostMapping("/qualityupdate/{mobile}/{id}/{quantity}")
	public  String quantity(@PathVariable long mobile, @PathVariable String id, @PathVariable String quantity) {
		return updatedQuantityService.updateUserQuantity(mobile, quantity, id); 
	}
	
	//This method is to get the all quantity details of the products
	@CrossOrigin
	@GetMapping("/getquantity/{mobile}")
	public String getquantity(@PathVariable long mobile ) {
		return userRepo.getupdated_quantity(mobile);
	}

}
