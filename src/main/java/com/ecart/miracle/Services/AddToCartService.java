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
public class AddToCartService {

	@Autowired
	ProductService productService;

	@Autowired
	ProductRepo productRepo;

	@Autowired 
	UserRepo userRepo;
	
	
	 /* This method is for adding items/products to user cart. First it checks the cart 
	if cart is empty it adds product to the cart otherwise adds new product with already existing product. */
	public String addToCart(long mobile, long pid) {
	
		String productId = "" + pid; 
		boolean temp = true;
		User userData = userRepo.getById(mobile);
		
		System.out.println(userData.getCart());
		if ( userData.getCart() == null || userData.getCart() =="" || userData.getCart().isEmpty()) { 
			userRepo.updateCart(productId, mobile);
			
			return "true";
		} 
		else {
			
			String strArray[] = userData.getCart().split(",");
			for (int i = 0; i < strArray.length; i++) {
				if (strArray[i].equals(productId)) {
					temp = false;
					break;
				}
			}
			if (temp == true) {
				productId = productId + "," + userData.getCart();
				userRepo.updateCart(productId, mobile);
				return "true";
			} else {
				return "false";
			}
		}
	}

	
	//It shows all products available in user cart
	public List myCart(long mobile) {
		List<Product> list = new ArrayList<>();
		try {
		List<User> user = userRepo.getByMobile(mobile);
		User userCart = user.get(0);
		String str = userCart.getCart();
		
		
//		//......................................................
//		if(str.charAt(str.length()-1)==',')
//		{
//			str=str.substring(0,str.length()-1);
//		}
//		//...........................................................
		if(str !=""||str !=null) { 
		String[] strArray = str.split(",");//7,8,
		for (int i = 0; i < strArray.length; i++) {
			long productid = Integer.parseInt(strArray[i]);
			list.add(productRepo.getById(productid));
		}}
		
		}
		catch (NumberFormatException e) {
			// TODO: handle exception
		}catch (NullPointerException e) {
			// TODO: handle exception
		}
		return list;
		
		
	}

	/*This method is for delete the product from the cart. The
	product id checks with user enter product id if both are same then 
	it delete that product from the cart based on user id. */
	public String deleteCartProduct(long mobile, long pid)  {
		List<User> userDatas = userRepo.getByMobile(mobile);
		String temp = "";
		String[] strArray = null;
		try {
			
		User userCart = userDatas.get(0);
		String str = userCart.getCart();
		
		if(str != null) {
			strArray = str.split(","); 
		for (int j = 0; j < strArray.length; j++) {
			if (strArray[0] == "," || strArray[strArray.length-1] == "") {
				continue;
			} else {
				long productid = Integer.parseInt(strArray[j]);
				if (productid == pid) {
					continue;
				}
			System.out.println(strArray[j]);
				temp = +productid + "," + temp;
			}
		}
		userRepo.updateCart(temp, mobile);
		}
		}catch (NumberFormatException e) {
			// TODO: handle exception
		}
		//userRepo.updateCart(temp, mobile);
		return "Item removed";
	}

}
