package com.unihub.app;

import java.util.*;
import javax.ejb.*;
import javax.naming.*;
import javax.naming.directory.*;
import java.security.*;

@Remote
public interface UserStatelessBI {
 
  public void createUser(String name, String pass, String email, String school);

}
