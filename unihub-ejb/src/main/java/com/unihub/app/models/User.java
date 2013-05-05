package com.unihub.app;

import java.math.BigInteger;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.security.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.persistence.*;

/**
 *
 * @author Mark
 * 
 * A user model.
 */
@Entity
@Table(name="users")
public class User implements Serializable {
    
    @Column(name="name", nullable=false)
    private String name;
    @Column(name="school", nullable=false)
    private String school;
    @Column(name="email", nullable=false)
    private String email;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Transient
    private int reputation;

    @OneToMany(cascade={CascadeType.ALL},
               mappedBy="owner",
               targetEntity=Message.class)
    private List<Message> messages;
    @Transient
    private ArrayList<String> watched;
    @Transient
    private ArrayList<Integer> voted;

    /*
    The byte[] array will be the hashed password
    */
    @Column(name="password", nullable=false)
    byte[] encryptedPassword;
    @Column(name="salt", nullable=false)
    byte[] salt;

    /*
    DO NOT DELETE!
    */
    //@ManyToMany(mappedBy="followers")
        @ManyToMany(
        cascade={CascadeType.ALL},
        mappedBy="followers",
        targetEntity=Event.class
    )
    private List<Event> followedEvents = new ArrayList<Event>();


    public List<Event> getEventList(){
      return followedEvents;
    }
    public void setEventList(List<Event> list){
      followedEvents = list;
    }
    /*
    End of DO NOT DELETE
    */

    /*
    My version for byte[] password incase your code depends on it
    which I feel it does.*/
    public User(String n, byte[] p, String e, String s, byte[] sal) {
        name = n;
        encryptedPassword = p;
        salt = sal;
        email = e;
        school = s;
        reputation = 0;
        messages = new ArrayList<Message>();
        watched = new ArrayList<String>();
        voted = new ArrayList<Integer>();
    }

    public byte[] getEncryptedPassword() {
      return encryptedPassword;
    }//end of getEncryptedPassword()


    public User(String n, String e, String s) {
        name = n;
        email = e;
        school = s;
        reputation = 0;
        messages = new ArrayList<Message>();
        watched = new ArrayList<String>();
        voted = new ArrayList<Integer>();
    }

    public User() {
      /*
      id = -1;
      name = "bob";
      email = "bob@bob.com";
      school = "bobU";
      reputation = 9001;
      sentMessages = new ArrayList<Message>();
      receivedMessages = new ArrayList<Message>();
      watched = new ArrayList<String>();
      voted = new ArrayList<Integer>();
      */
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

    public void addToMessages(Message m) {
      messages.add(m);
    }

    public List<Message> getMessages() {
      return messages;
    }
    
    public void setMessages(List<Message> msgs) {
      messages = msgs;
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
