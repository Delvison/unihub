package com.unihub.app;

import javax.ejb.*;
import java.util.ArrayList;
/*Exception specific to hashing any types of string/characters*/
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**SecureRandom is a more secure way, 
aka cryptographically secure way to generate random numbers */
import java.security.SecureRandom;

/*KeySpec is the Specification for generating keys*/
import java.security.spec.KeySpec;
import java.util.Arrays;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

@Remote
@Stateless
public class AuthBeans implements Authenticate {





	public boolean authenticate(String userName, String password) 
		throws NoSuchAlgorithmException, InvalidKeySpecException {
		
			//Dbase dbase = Dbase.create();
			//User user = dbase.getUser(userName);
			/*Temporarily keeping encrypted password here locally
			to not change too much code until it is necessary
			since ideally I will have that sent from Auth.java
			after the Model returns the bytes I stored from
			the encrypted password*/
			//byte[] salt = user.getSalt();
			//byte[] encryptedPassword = user.getEncryptedPassword();

			/*looks like whatever is in bytes can be casted to a String
			with no loss of bits and back*/
			//String temp = new String(encryptedPassword);
			//encryptedPassword = temp.getBytes();




		/*if((userName == null || password == null) || 
			(userName.equals("") || password.equals(""))) {

			return false;
		}
		else {
			byte[] passwordAttempt = getEncryptedPassword(password, salt);
			return Arrays.equals(encryptedPassword, passwordAttempt);
		}*/

		//get rid of this return sinc its here to not mess anything up
		return false;

	}//end of authenticate method

	

	/*
	This method actually does the work in order to get
	a string turned into a hashed byte[] array*/
	public byte[] getEncryptedPassword(String password, byte[] salt)
		throws NoSuchAlgorithmException, InvalidKeySpecException {

		//String algorithm = "PBKDF2WithHmacSHA1";

		//int keyLength = 160; //needed because SHA1 generates 160 bit hashes :D

		/*
		iterations are needed because it increases the time
		taken to hash le password*/
		//int iterations = 10000;

		//KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 
		//								iterations, keyLength);

		//SecretKeyFactory f = SecretKeyFactory.getInstance(algorithm);

		//return f.generateSecret(spec).getEncoded();
		return null;


	}//end of getEncryptedPassword

	/*
	Method that generates a salt needed to prevent collisions
	and Rainbow table attacks on passwords
	or sensitive data in general*/
	public byte[] generateSalt() throws NoSuchAlgorithmException {

		//SecureRandom random = SecureRandom.getInstance("SHA1PRNG");

		//byte[] salt = new byte[8];
		//random.nextBytes(salt);

		//return salt;
		return null;

	}//end of generateSalt()













}//end of AuthBeans