package com.ecart.miracle.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecart.miracle.Repo.ProductRepo;
import com.ecart.miracle.Repo.UserRepo;
import com.ecart.miracle.models.Product;
import com.ecart.miracle.models.User;

@Service
public class WishListService {
	
	@Autowired
	ProductRepo productRepo;
	
	@Autowired
	UserRepo userRepo;
	
	/*This method is for add products to wish list. First it checks the wish list
	if wish list is empty it adds product to the wish list otherwise adds new 
	product with already existing product. Each product id is separated by comma.*/
	public String addToWishList(long mobile, long pid) {
		String productId =""+pid;
		User userData= userRepo.getById(mobile);
		
		if(userData.getWishlist()==null)
		{
		
		userRepo.updateWishList(productId, mobile);
		}
		else { 
			
			productId=productId+","+userData.getWishlist();
			userRepo.updateWishList(productId, mobile);
		}
		return "Saved in wishlist";
	}
	
	/*This method is for remove the product from wish list. The
	product id checks with user enter product id if both are same then 
	it delete that product from the wish list based on user id.*/
	public String removeFromWishlist(long mobile,long pid) {
		List<User> userData= userRepo.getByMobile(mobile);
		User userCart=userData.get(0);
		String str=userCart.getWishlist();
		String[] strArray =str.split(",");
		String wishlist="";
		for(int j=0; j<strArray.length; j++)
		{
			if(strArray[0]==",")
			{
				continue;
			}else {
			long productid =Integer.parseInt(strArray[j]);
			if(productid==pid)
			{
				continue;
			}
			
			wishlist=+productid+","+wishlist;
		}}
			
		userRepo.updateWishList(wishlist, mobile);
		return "Item removed";
		}
	
	
}
