package com.ecart.miracle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecart.miracle.Services.AddToCartService;


@RestController
@RequestMapping

public class AddToCartController { 
	
	@Autowired
	AddToCartService addToCartService;  
	
	
    // This method is for adding items/products to user cart 
	@CrossOrigin 
	@PostMapping ("/addToCart/{mobile}/{id}")
	public String addToCart(@PathVariable long mobile, @PathVariable long id) {
		return addToCartService.addToCart(mobile, id);
		
	} 
	
	//It shows all products available in user cart 
	@CrossOrigin
	@GetMapping("/myCart/{mobile}")
	public List  myCart(@PathVariable long mobile) {
		return addToCartService.myCart(mobile); 
		 
	}
	
	//This method is for delete the product from the cart 
	@CrossOrigin
	@PutMapping("/deleteCartItem/{mobile}/{id}")
	public String deleteCart(@PathVariable long mobile, @PathVariable long id)
	{
		return addToCartService.deleteCartProduct(mobile, id);
	}
	
}

