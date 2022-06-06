package com.ecart.miracle.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecart.miracle.Repo.ProductRepo;
import com.ecart.miracle.Repo.UserRepo;
import com.ecart.miracle.models.Product;

@Service
public class BuyProductService {

	@Autowired
	ProductRepo productRepo;
	
	@Autowired
	MailService mailService;
	
	@Autowired
	UserRepo userRepo;

    /*This method is for buy product. If user want to buy products directly,
	first we get all the details of that product based on product id and checks 
	with the quantity if products are available then checkout page open */ 
	public Product buyProduct(long productId) { 
		Product productData = productRepo.getById(productId);
		int productQuantity = productData.getQuantity();
		if (productQuantity != 0) {
			
			return productData; 
		} else {
			return null;
		} 
	} 
	
	/*This method is for checkout. If the user click on buy products, 
	 the checkout page will open, It shows product details, quantity, address */
	public String checkout(long mobile) {
		try {
			userRepo.updateCart(null, mobile);
		}
		catch(NullPointerException e){
		} 
		return "order placed sucessfully";
	}
	
	/* This method is for confirm order. After the user click on confirm order 
	 it sends message to user registered mail like your order is successfully placed and with some id */
	public String confirmorder(int quantity, long productId, String mail) {
		
		Product productData= productRepo.getById(productId);
		if (productData.getQuantity() >= quantity) {
			int remainingQuantity = productData.getQuantity() - quantity;
			productRepo.updateQuantity(remainingQuantity, productId);
			int random= (int) (Math.random()*(99999-11111+1)+11111);
			String content =  "your order is successfully placed and your order id is "+"EKART-MSS"+random;
			
			mailService.sendingMail(mail,content );
			return "order placed";
		} 
		else {
			return "order placement not done"; 
		}
	}
	
}


