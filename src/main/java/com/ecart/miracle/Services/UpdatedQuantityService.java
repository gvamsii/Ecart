package com.ecart.miracle.Services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecart.miracle.Repo.UserRepo;

@Service
public class UpdatedQuantityService {
	
	
	@Autowired
	UserRepo userRepo;
	
	
	/*This method is to increase the quantity. If user can
	increase or decrease the quantity from the cart page  */
	public String updateUserQuantity (long mobile, String quantity,String id) {
		userRepo.updateUserCartQuantity(quantity,id, mobile );
		return "true";
		
	}

}
