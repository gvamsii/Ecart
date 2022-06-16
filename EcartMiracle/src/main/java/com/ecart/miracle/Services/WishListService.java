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
	
	
	public String addToWishList(long mobile, long pid)
	{
		String productId = "" + pid; 
		boolean temp = true;
		User userData = userRepo.getById(mobile);
		
		if ( userData.getWishlist() == null || userData.getWishlist() =="" || userData.getWishlist().isEmpty()) { 
			userRepo.updateWishList(productId, mobile);
			
			return "true";
		} 
		else {
			
			String strArray[] = userData.getWishlist().split(",");
			for (int i = 0; i < strArray.length; i++) {
				if (strArray[i].equals(productId)) { 
					temp = false;
					break;
				}
			}
			if (temp == true) {
				productId = productId + "," + userData.getWishlist();
				userRepo.updateWishList(productId, mobile);
				return "true";
			} else {
				return "false";
			}
		}
	}
	
	public List getWishList(long mobile)
	{
		List<Product> wishList = new ArrayList<>();
		List<User> userGetData=userRepo.getByMobile(mobile);
		String wishListData=userGetData.get(0).getWishlist();
		try {
		if(wishListData!=null || wishListData!="")
		{
			String[] stringArray=wishListData.split(",");
			for(int j=0; j  < stringArray.length; j++)
			{
				long productid =Integer.parseInt(stringArray[j]);
				wishList.add(productRepo.getById(productid));	
			}
		}}
		catch (NumberFormatException e) {
			// TODO: handle exception
		}catch (NullPointerException e) {
			// TODO: handle exception
		}
		return wishList;
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
