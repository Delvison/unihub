package com.unihub.app;

import javax.ejb.*;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@Remote
public interface Authenticate {

	public boolean authenticate(String userName, String password) 
		throws NoSuchAlgorithmException, InvalidKeySpecException;

	public byte[] getEncryptedPassword(String password, byte[] salt)
		throws NoSuchAlgorithmException, InvalidKeySpecException;

	public byte[] generateSalt() throws NoSuchAlgorithmException;


}