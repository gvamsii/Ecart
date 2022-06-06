package com.ecart.miracle.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.ecart.miracle.Services.ForgotPasswordService;
import com.ecart.miracle.models.Otp;
import com.ecart.miracle.models.User;

@CrossOrigin
@RestController
@RequestMapping
public class ForgotPasswordController {

	@Autowired
	ForgotPasswordService forgotPasswordService;

	@Autowired
	UserController userController;

	// This method is for forgot password. It sends otp to the registered mail
	@CrossOrigin
	@PostMapping("/sendotp/{mobile}/{email}")
	public String forgotPassword(@PathVariable long mobile, @PathVariable String email) {
		return forgotPasswordService.forgotPassword(mobile, email);

	}

	@CrossOrigin
	@PostMapping("/passwordUpdate/{mobile}/{password}")
	public boolean otpForPasswordReset(@PathVariable long mobile, @PathVariable String password) {
		return forgotPasswordService.updatePassword(mobile, password);
	} 

	@CrossOrigin
	@PostMapping("/otpVerification")
	public String otpVerification(@RequestBody Otp otp) {
		return forgotPasswordService.otpVerification(otp);

	}

	@ExceptionHandler(NullPointerException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity handleNullPointerException(NullPointerException exception, WebRequest request) {
		// Log.error("Failed to find the requested element", exception);
		return buildErrorResponse(exception, HttpStatus.INTERNAL_SERVER_ERROR, request);
	}

	private ResponseEntity buildErrorResponse(NullPointerException exception, HttpStatus internalServerError,
			WebRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
