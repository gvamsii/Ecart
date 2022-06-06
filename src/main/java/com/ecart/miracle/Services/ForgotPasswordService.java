package com.ecart.miracle.Services;

import java.math.BigInteger;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.ecart.miracle.Repo.UserRepo;
import com.ecart.miracle.Security.NewEncriptionTechnique;
import com.ecart.miracle.models.Otp;
import com.ecart.miracle.models.User;

@Service
public class ForgotPasswordService {

	@Autowired
	UserRepo userRepo;
	@Autowired
	MailService mailService;


	@Autowired
	NewEncriptionTechnique newEncriptionTechnique;

	String tempsendotp = "";

	/*
	 * This method is for forgot password. If user click on forgot password it will
	 * opens forgot password page, after enter the mobile and email it checks that
	 * email with user registered email based on the mobile if both are same it
	 * sends otp to that registered mail through mail service
	 */
	public String forgotPassword(long mobile, String mail) {

		List<User> user = userRepo.getByMobile(mobile);
		if (user.isEmpty()) {
			return "invalid mobile number";
		} else {
			User user1 = user.get(0);
			String tempmail = user1.getEmail();

			if (tempmail.equals(mail)) {
				Random random = new Random();
				int tempotp = 1000 + random.nextInt(9000);
				tempsendotp = Integer.toString(tempotp);
				String otpstr = "your one time password to verifiy email.Do not share your OTP with anyone- "
						+ tempsendotp;
				mailService.sendingMail(tempmail, otpstr);

				return "successfully sent otp";
			} else {
				return "invalid user credits";
			}
		}
	}

	/*
	 * This method is for update password. To verify otp, the user enter otp
	 * compared with sent otp if both are match the will update password in user
	 * table
	 */
	@SuppressWarnings("null")
	public boolean updatePassword(long mobile, String password) {
		// write update passord logic
		if(password != null || password.isEmpty()) {
			password = newEncriptionTechnique.encrpt(password);
			userRepo.updatePassword(password, mobile);
			tempsendotp = "";
			return true;
		}
		else {
			return false;
		}
		
		
	} 

	public String otpVerification(Otp otp) {
		if (otp.getOtp().equals(tempsendotp)) {
			return "true";
		} else {
			return "false";
		}
	}

}
