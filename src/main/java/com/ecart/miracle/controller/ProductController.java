package com.ecart.miracle.controller;

import java.awt.Image;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ecart.miracle.Repo.ProductRepo;
import com.ecart.miracle.Services.ProductService;
import com.ecart.miracle.models.Product;

@CrossOrigin
@RestController
@RequestMapping
public class ProductController {

	@Autowired
	ProductService productService;
	
	//This method is for seller to insert products into product table 
	@CrossOrigin
	@PostMapping("/addProducts")
	public Product insertProducts(@RequestBody Product product) {
		return productService.insertProducts(product); 
	} 

	//This method is for seller to update the price details. If seller want to update. 
	@CrossOrigin
	@PutMapping("/updatePriceDetails")
	public String updatePriceDetails(@RequestBody Product product) {
		int price = product.getPrice();
		long id = product.getId();
		return productService.updatePriceDetails(price, id);
 
	}

	//This method is for seller to update the quantity details. If seller want to update. 
	@CrossOrigin
	@PutMapping("/updateQuantityDetails")
	public String updateQuantityDetails(@RequestBody Product product) {
		int quantity = product.getQuantity();
		long id = product.getId();
		return productService.updateQuantityDetails(quantity, id); 

	}

	//This method is for seller to update the color details. If seller want to update. 
	@CrossOrigin
	@PutMapping("/updateColourDetails")
	public String updateColourDetails(@RequestBody Product product) {
		String colour = product.getColour();
		long id = product.getId();
		return productService.updateColurDetails(colour, id);

	}

	//This method is for seller to delete the products from product table. 
	@CrossOrigin
	@DeleteMapping("/deleteProduct")
	public String deleteProductDetails(@RequestBody Product product) {
		long id = product.getId();
		return productService.deleteProduct(id);
	}
	
	//This method is for seller to get the all products from product table. 
	@CrossOrigin
	@GetMapping("/getAllProducts")
	public List<Product> getAllProductDetails( ) {
		return productService.getAllProducts();
	}
}
