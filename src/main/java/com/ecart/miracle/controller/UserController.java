package com.ecart.miracle.controller;

import java.io.UnsupportedEncodingException;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.ObjectToStringHttpMessageConverter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecart.miracle.Repo.UserRepo;
import com.ecart.miracle.Security.NewEncriptionTechnique;
import com.ecart.miracle.Services.MailService;
import com.ecart.miracle.Services.UserService;
import com.ecart.miracle.models.Otp;
import com.ecart.miracle.models.User;

@CrossOrigin
@RestController
@RequestMapping
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	MailService mailService;

	@Autowired
	UserRepo userRepo;

	User user1;
 
	String tempSendOTP;

	@Autowired
	NewEncriptionTechnique newEncriptionTechnique;

	// This is for verifying user OTP which is sent to user mail then user data will
	// be saved in database.

	@CrossOrigin
	@PostMapping("/verify") 
	public boolean verification(@RequestBody Otp otp) {

		if (otp.getOtp().equals(tempSendOTP)) {

			userService.userRegistration(user1); 
			user1 = null;
			return true;
		} else {
			return false;
		}
	}

	// This API is for sending mail to user that contains OTP.

	@CrossOrigin
	@PostMapping("/userregistration")
	public boolean userRegistration(@RequestBody User user)
			throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException,
			BadPaddingException, UnsupportedEncodingException, Exception {
		user1 = user;
		String str = user1.getEmail();

		String firstname = user1.getFirstname();
		String lastname = user1.getLastname();
		String mobilenum = user1.getMobile().toString();
		String Userid = (lastname.charAt(0) + firstname + mobilenum);
		user.setUserid(Userid);

		String gotpassword = user1.getPassword();
		String password = newEncriptionTechnique.encrpt(gotpassword);
		System.out.println(password);
		user.setPassword(password);

		if (str != null) {
			Random random = new Random();
			int otpGen = 1000 + random.nextInt(9000);
			tempSendOTP = Integer.toString(otpGen);
			String otpstr = "Your one time password(OTP) to verifiy email. Do not share your OTP with anyone - "
					+ tempSendOTP;
			return mailService.sendingMail(str, otpstr);
		} else {
			return false;
		}
	}

	// This API is for user login

//	@CrossOrigin
//	@PostMapping("/login1")
//	public ResponseEntity<Optional<User>> login1(@RequestBody User user){
//		if(user.getMobile() != null) {
//			
//		}
//
//		Long userMobile = user.getMobile();
//		String userPassword = newEncriptionTechnique.encrpt(user.getPassword());
//		Optional<User> logindetails = userRepo.login(userMobile, userPassword);
//		if(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR) != null)
//		return ResponseEntity.ok(logindetails);
//		else {
//			return (ResponseEntity<Optional<User>>) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
	
	
	//This method is for login and password encryption
	@CrossOrigin
	@PostMapping("/login")
	public User login(@RequestBody User user) {
		
		List<User> user1;
		if(user.getMobile()!=null)
		{
		user1=userService.login(user.getMobile());
		}else {
			user1=userService.login1(user.getEmail());
		}
		User str=null;
		
		if (user1.isEmpty()) {
		return user;
		} else {
			 str = user1.get(0);
		if (str.getPassword().equals(newEncriptionTechnique.encrpt(user.getPassword()))) {
			System.out.println(str.getPassword());
		return str;
		} else {
		return null;
		}
	}


}}
