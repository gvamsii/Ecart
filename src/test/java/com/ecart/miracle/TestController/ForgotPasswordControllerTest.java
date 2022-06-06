package com.ecart.miracle.TestController;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.ecart.miracle.Services.ForgotPasswordService;
import com.ecart.miracle.controller.ForgotPasswordController;
import com.ecart.miracle.models.User;

@SpringBootTest
public class ForgotPasswordControllerTest {
	
	@InjectMocks
    ForgotPasswordController forgotPasswordController;
	
	@Mock
	ForgotPasswordService forgotPasswordService;
	
	@Test
	void forgotPasswordTest() {
		
		User user=new User(); 
		user.setMobile(1614704577); 
		user.setEmail("prasannapolisetti7@gmail.com"); 
		Long mobile=user.getMobile();
		String mail=user.getEmail();
		Mockito.when(forgotPasswordService.forgotPassword(Mockito.anyLong(), Mockito.anyString())).thenReturn("otp sent");
		String response=forgotPasswordController.forgotPassword(mobile,mail);
		assertEquals("otp sent",response);
		
	}
	
	@Test
	void verifyOTPTest() {
		User user=new User();
		user.setMobile(1614704577);
		user.setPassword("hai");;
		Long mobile=user.getMobile();
		String password=user.getPassword();
		String otp="3625";
		Mockito.when(forgotPasswordService.updatePassword(Mockito.anyString(),Mockito.anyLong(),Mockito.anyString())).thenReturn("verified OTP");
		String response=forgotPasswordController.verifyOTP(otp, mobile, password);
		assertEquals("verified OTP",response);
	}
}


