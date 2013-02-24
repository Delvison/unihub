package com.unihub.app;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author Mark
 * 
 * A user model.
 */
public class User implements javax.servlet.http.HttpSessionBindingListener {
    
    private String name, school, email, password;
    
    public User(String n, String p, String e, String s) {
        name = n;
        password = p;
        email = e;
        school = s;
    }

    public boolean isLoggedIn(HttpSession session) {
        String foundName = (String)session.getAttribute("username");
        return (foundName.equals(this.name));	
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

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.println("Successfully Logged Out");
    }
    
    
}
