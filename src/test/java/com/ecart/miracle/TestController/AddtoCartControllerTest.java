package com.ecart.miracle.TestController;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.ecart.miracle.Services.AddToCartService;
import com.ecart.miracle.controller.AddToCartController;
import com.ecart.miracle.models.Product;
import com.ecart.miracle.models.User;

@SpringBootTest
public class AddtoCartControllerTest {
	 
	@InjectMocks
	AddToCartController addToCartController;
	
	@Mock
	AddToCartService addToCartService;
	
	@Mock
	User user;
	
	@Mock
	Product product;
	
	@Test 
	void addToCartTest() {
		user.setMobile(1369851237);
		product.setId(456);
		Long mobile=user.getMobile();
		Long id=product.getId();
		Mockito.when(addToCartService.addToCart(Mockito.anyLong(),Mockito.anyLong())).thenReturn("added");
		String response=addToCartController.addToCart(mobile, id);
		assertEquals("added",response);
	} 
	
	@Test
	void myCartTest() {
		user.setMobile(1369851237);
		Long mobile=user.getMobile();
		List<User> list=new ArrayList<>();
		list.add(user);
		Mockito.when(addToCartService.myCart(Mockito.anyLong())).thenReturn(list);
		List response=addToCartController.myCart(mobile);
		assertEquals(list,response);
	}
	
	@Test
	void deleteCartTest() {
		user.setMobile(1369851237);
		product.setId(456);
		Long mobile=user.getMobile();
		Long id=product.getId();
		Mockito.when(addToCartService.deleteCartProduct(Mockito.anyLong(), Mockito.anyLong())).thenReturn("deleted");
		String response=addToCartController.deleteCart(mobile, id);
		assertEquals("deleted",response); 
	}

}
