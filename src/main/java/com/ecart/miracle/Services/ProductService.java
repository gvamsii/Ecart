package com.ecart.miracle.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecart.miracle.Repo.ProductRepo;
import com.ecart.miracle.models.Product;

@Service
public class ProductService {
	
	@Autowired
	ProductRepo productRepo;
	
	//This method is for seller to insert products into product table. 
	public Product insertProducts(Product product){
		return productRepo.save(product); 
		
	}
	
	
	//This method is for seller to update the price details. If seller want to update. 
	public String updatePriceDetails(int price,Long id) {
		productRepo.updatePrice(price,id);
		return "Price Details Updated";
	}

	
	//This method is for seller to update the quantity details. If seller want to update. 
	public String updateQuantityDetails(int quantity,Long id) {
		productRepo.updateQuantity(quantity,id);
		return "Quantity Details Updated";
	}

	
	//This method is for seller to update the color details. If seller want to update.
	public String updateColurDetails(String colour,Long id) {
		productRepo.updateColour(colour,id);
		return "Colour Details Updated";
	}
	
	
	//This method is for seller to delete the products from product table.
	public String deleteProduct(Long id) {
		productRepo.deleteById(id);
		return "Item Deleted";
	}
	
	
	//This method is for seller to get the all products from product table.
	public List<Product> getAllProducts( ){
		return productRepo.findAll();
		
	}
	
	//This meyhod is for get one product product table based on id.
	public Optional<Product> findById(long id) {
	    return productRepo.findById(id);
	    }
}
