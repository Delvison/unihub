package com.unihub.app;

import javax.ejb.*;
import javax.jws.WebService;
import javax.jws.WebMethod;
import java.util.Arrays;
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
@WebService
public class NakedAuthBeans implements NakedAuthenticate {
	@EJB
	Authenticate bean;

	@WebMethod
	public byte[] getSalt(String username) {
		Dbase dbase = Dbase.create();
		User user = dbase.getUser(username);

		return user.getSalt();

	}//end of authenticate

	@WebMethod
	public boolean authenticate(String username, String password, byte[] salt) 
		throws NoSuchAlgorithmException, InvalidKeySpecException{
			
		Dbase dbase = Dbase.create();
		User user = dbase.getUser(username);

		byte[] passwordAttempt = bean.getEncryptedPassword(password, salt);

		return Arrays.equals(user.encryptedPassword, passwordAttempt);


	}//end of authenticate


}//end of class