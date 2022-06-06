package com.ecart.miracle.Security;

import org.springframework.stereotype.Service;

@Service
public class NewEncriptionTechnique {
	
	//This method is for the password encryption. when user enter password it internally encrypted after verification of mail.
	public String encrpt(String password) {
		String encryiptedpassword="";
		for(int i=0;password.length()>i;i++)
		{
			char ch=password.charAt(i);
			int pass=(int)ch;
			String engpassword=""+pass;
	
			encryiptedpassword=encryiptedpassword+engpassword;
		}
		return encryiptedpassword;  
		
	}

}
