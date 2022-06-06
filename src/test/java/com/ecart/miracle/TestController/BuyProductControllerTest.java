package com.ecart.miracle.TestController;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.ecart.miracle.Services.BuyProductService;
import com.ecart.miracle.controller.BuyProductController;
import com.ecart.miracle.models.Product;
import com.ecart.miracle.models.User;

@SpringBootTest
public class BuyProductControllerTest {
	
	@InjectMocks
	BuyProductController buyProductController;
	
	@Mock
	BuyProductService buyProductService;
	
	@Mock
	Product product;
	
	@Mock
	User user;
	
	@Test
	void buyProductTest() { 
		product.setId(8);
	    Long id=product.getId();
		Mockito.when(buyProductService.buyProduct(Mockito.anyLong())).thenReturn(product);
		Product response=buyProductController.buyProduct(id);
		assertEquals(product,response);
	}
	@Test
	void checkoutTest() {
		user.setMobile(1236547890);
		Long mobile=user.getMobile();
		Mockito.when(buyProductService.checkout(Mockito.anyLong())).thenReturn("order placed");
		String response=buyProductController.checkout(mobile);
		assertEquals("order placed",response);
		
	}
	
//	@Test
//	void confirmOrderTest() {
//		product.setQuantity(25);
//		product.setId(8);
//		user.setEmail("prasanna@gmail.com");
//		int quantity=product.getQuantity();
//		Long id=product.getId();
//		String mail=user.getEmail();
//		Mockito.when(buyProductService.confirmorder(Mockito.anyInt(),Mockito.anyLong(), Mockito.anyString())).thenReturn("order placed successfully");
//		String response=buyProductController.confirmOrder(quantity, id, mail);
//
//		assertEquals("order placed successfully",response);
//	}
	

}
