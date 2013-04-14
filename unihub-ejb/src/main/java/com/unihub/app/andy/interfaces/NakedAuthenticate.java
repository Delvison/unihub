package com.unihub.app;

import javax.ejb.*;
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
public interface NakedAuthenticate {

	public byte[] getSalt(String username);

	public boolean authenticate(String username, String password, byte[] salt)
		throws NoSuchAlgorithmException, InvalidKeySpecException;

}//end of NakedAuthenticate