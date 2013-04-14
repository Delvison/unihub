package com.unihub.app;

import java.math.BigInteger;
import java.io.*;
import java.util.ArrayList;
import java.security.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author Mark
 * 
 * A user model.
 */
public class User implements Serializable {
    
    private String name, school, email;
    private int id, reputation;
    private ArrayList<Message> sentMessages, receivedMessages;
    private ArrayList<String> watched;
    private ArrayList<Integer> voted;

    /*
    The byte[] array will be the hashed password
    */
    byte[] encryptedPassword;
    byte[] salt;

    /*
    My version for byte[] password incase your code depends on it
    which I feel it does.*/
    public User(String n, byte[] p, String e, String s, byte[] sal) {
        //id = -1;
        name = n;
        encryptedPassword = p;
        salt = sal;
        email = e;
        school = s;
        reputation = 0;
        sentMessages = new ArrayList<Message>();
        receivedMessages = new ArrayList<Message>();
        watched = new ArrayList<String>();
        voted = new ArrayList<Integer>();
    }

    public byte[] getEncryptedPassword() {
      return encryptedPassword;
    }//end of getEncryptedPassword()


    public User(String n, String e, String s) {
        id = -1;
        name = n;
        email = e;
        school = s;
        reputation = 0;
        sentMessages = new ArrayList<Message>();
        receivedMessages = new ArrayList<Message>();
        watched = new ArrayList<String>();
        voted = new ArrayList<Integer>();
    }

    public User() {
      id = -1;
      name = "bob";
      email = "bob@bob.com";
      school = "bobU";
      reputation = 9001;
      sentMessages = new ArrayList<Message>();
      receivedMessages = new ArrayList<Message>();
      watched = new ArrayList<String>();
      voted = new ArrayList<Integer>();
    }

    public boolean isLoggedIn(HttpSession session) {
        String foundName = (String)session.getAttribute("username");
        return (foundName.equals(this.name));	
    }

    public String gravatar() throws NoSuchAlgorithmException {
      String plaintext = email;
      MessageDigest m = MessageDigest.getInstance("MD5");
      m.reset();
      m.update(plaintext.getBytes());
      byte[] digest = m.digest();
      BigInteger bigInt = new BigInteger(1,digest);
      String hashtext = bigInt.toString(16);
      // Now we need to zero pad it if you actually want the full 32 chars.
      while(hashtext.length() < 32 ){
        hashtext = "0"+hashtext;
      }
      return "http://www.gravatar.com/avatar/" + hashtext;  
    }

    public String sizedGravatar(int size) throws NoSuchAlgorithmException {
      return this.gravatar() + "?size=" + size;
    }

    public int getId() {
      return id;
    }

    public void setId(int id) {
      this.id = id;
    }

    public int getReputation() {
      return reputation;
    }

    public void setReputation(int rep) {
      reputation = rep;
    }

    public void incRep() {
      reputation += 1;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the school
     */
    public String getSchool() {
        return school;
    }

    /**
     * @param school the school to set
     */
    public void setSchool(String school) {
        this.school = school;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getSalt() {
      return salt;
    }//end of getSalt()

    public void addToSent(Message m) {
      sentMessages.add(m);
    }

    public void addToReceived(Message m) {
      receivedMessages.add(m);
    }

    public ArrayList<Message> getSentMessages() {
      return sentMessages;
    }
    
    public ArrayList<Message> getReceivedMessages() {
      return receivedMessages;
    }
 
    public ArrayList<String> getWatched() {
      return watched;
    }
    
    public void watch (String uname) {
      watched.add(uname);
    }

    public void unwatch (String uname) {
      watched.remove(uname);
    }

    public boolean isWatching (String n) {
      if (watched.contains(n)) return true;
      return false;
    }

    public void addToVoted(Integer i) {
      voted.add(i);
    }

    public boolean hasVoted(Integer i) {
      return voted.contains(i);
    }

    public boolean owns(int i_id) {
      ListingsObj listings = ListingsObj.create();
      Stuff stuff = listings.getStuff(i_id);
      String stuffuser = stuff.getUser();
      if(stuffuser.equals(this.name)) return true;
      return false;
    }
 
    public void update(String name, String email, byte[] pass, String school) {
      this.name = name;
      this.email = email;
      this.encryptedPassword = pass;
      this.school = school;
    }

}
