package com.ecart.miracle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecart.miracle.Services.BuyProductService;
import com.ecart.miracle.models.Product;

@RestController
@RequestMapping
public class BuyProductController {
	@Autowired
	BuyProductService buyProductService;
	
	
	// This method is for buy the product 
	@CrossOrigin
	@GetMapping("/buy/{productId}")
	public Product buyProduct(@PathVariable long productId)
	{ 
		return buyProductService.buyProduct(productId);  
	}
	 
	
	// This method is for checkout
	@CrossOrigin
	@PostMapping("/check/{mobile}")
	public String checkout(@PathVariable long mobile) {
		return buyProductService.checkout(mobile); 
	}
		
	//This method is for confirm order
	@CrossOrigin
	@GetMapping("/checkout/{quantity}/{id}/{mail}")
	public String confirmOrder(@PathVariable int quantity ,@PathVariable long id, @PathVariable String mail) {
		
		return buyProductService.confirmorder(quantity, id,mail);
	}
	
	
}
