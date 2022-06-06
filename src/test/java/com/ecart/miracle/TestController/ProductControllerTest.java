package com.ecart.miracle.TestController;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.boot.test.context.SpringBootTest;

import com.ecart.miracle.Repo.ProductRepo;
import com.ecart.miracle.Services.ProductService;
import com.ecart.miracle.controller.ProductController;
import com.ecart.miracle.models.Product;

@SpringBootTest
public class ProductControllerTest {
	
	@InjectMocks
	ProductController productController;
	
	@Mock
	ProductRepo productRepo;
	
	@Mock
	ProductService productService;
	
	Product product;
	
	@Test
    void insertProducts() {
		Product product = new Product(2,"vamsi",12000,"brand","size",2,"green","description","image","seller");
		Mockito.when(productService.insertProducts(Mockito.any(Product.class))).thenReturn(product);
		Product response = productController.insertProducts(product);
		assertEquals(product, response);  
	}
	
	@Test
	void updatePriceDetails() {
		Product product = new Product(2,"vamsi",12000,"brand","size",2,"green","description","image","seller");
		Mockito.when(productService.updatePriceDetails(Mockito.anyInt(),Mockito.anyLong())).thenReturn("Price Details Updated");
		String response = productController.updatePriceDetails(product);
		assertEquals("Price Details Updated",response);
		
	}
	
	@Test
	void updateQuantityDetails() {
		Product product = new Product(2,"vamsi",12000,"brand","size",2,"green","description","image","seller");
		Mockito.when(productService.updateQuantityDetails(Mockito.anyInt(),Mockito.anyLong())).thenReturn("Quantity Updated");
		String response=productController.updateQuantityDetails(product);
		assertEquals("Quantity Updated",response);
	}
	
	@Test
	void updateColourDetails() {
		Product product = new Product(2,"vamsi",12000,"brand","size",2,"green","description","image","seller");
		Mockito.when(productService.updateColurDetails(Mockito.anyString(), Mockito.anyLong())).thenReturn("colour details updated");
		String response=productController.updateColourDetails(product);
		assertEquals("colour details updated",response);
	}
	
	@Test
	void deleteProduct() {
		Product product = new Product(2,"vamsi",12000,"brand","size",2,"green","description","image","seller");
		Mockito.when(productService.deleteProduct(Mockito.anyLong())).thenReturn("deleted");
		String response=productController.deleteProductDetails(product);
		assertEquals("deleted",response);
	}
	
	@Test
	void getAllProducts() {
		Product product = new Product(2,"vamsi",12000,"brand","size",2,"green","description","image","seller");
		Mockito.when(productService.getAllProducts()).thenReturn(getall());
		List<Product> response=productController.getAllProductDetails();
		assertEquals(getall(),response);
		
	}
	
	public List<Product> getall() {
		List list=new ArrayList<>();
		list.add(product); 
		return list;
	}

}
