package com.unihub.app;

import javax.ejb.*;
import java.util.ArrayList;
import javax.naming.*;
import javax.naming.directory.*;

@Stateless
@Remote
public interface SearchEJB {
	public ArrayList<String> amazonSearch(String keywords) throws RuntimeException;
	public String[] googleSearch(String keywords) throws Exception;
}
