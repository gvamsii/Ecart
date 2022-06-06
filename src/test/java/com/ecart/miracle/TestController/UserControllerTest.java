package com.ecart.miracle.TestController;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.ecart.miracle.Repo.UserRepo;
import com.ecart.miracle.Services.MailService;
import com.ecart.miracle.Services.UserService;
import com.ecart.miracle.controller.UserController;

@SpringBootTest
public class UserControllerTest {
	@InjectMocks
	UserController userController;
	
	@Mock
	UserService userService;
	
	@Mock
	MailService mailService;
	
	@Mock
	UserRepo userRepo;
	
	@Test
	
	void p () {
		
	}
	
	

}
