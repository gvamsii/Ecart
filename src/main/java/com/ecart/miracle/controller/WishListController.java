package com.ecart.miracle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecart.miracle.Services.WishListService;

@RestController
@RequestMapping
public class WishListController {
	
	@Autowired
	WishListService wishListService;
	
	//This method is to put the products into wish list based on id
	@CrossOrigin
	@GetMapping("/addToWishList/{mobile}/{id}")
	public String wishList(@PathVariable long mobile,@PathVariable long id ) {
		return wishListService.addToWishList(mobile,id);
	}
	
	//This method is for remove the product from the wish list
	@CrossOrigin
	@PutMapping("/removeFromWishList/{mobile}/{id}")
	public String removeFromWishList(@PathVariable long mobile, @PathVariable long id) {
		return wishListService.removeFromWishlist(mobile, id); 
	}
	
}
