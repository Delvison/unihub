package com.unihub.app;

import javax.ejb.*;
import javax.annotation.Resource;
import java.util.ArrayList;
import javax.naming.*;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.util.HashMap;
import java.util.Map;


@Stateless (name="WeatherEJB")
@Remote 
@WebService
public class WeatherSession implements WeatherEJB {
	
    @WebMethod
	public ArrayList<String> weatherLookup(String q) throws RuntimeException{
		//Service: World Weather Online - http://developer.worldweatheronline.com/
		final String WWO_KEY = "j9v4a8vxgypbemrwz8bxsb99";
		String baseLink = "http://api.worldweatheronline.com/free/v1/weather.ashx?";
		ArrayList<String> result =  new ArrayList<String>();
		baseLink += "q="+q+"&";
		baseLink += "format=xml&num_of_days=1&includelocation=yes&";
		baseLink += "key="+WWO_KEY;
		try{
			result.add(fetch(baseLink, "temp_F")); // 0 temperature
			result.add(fetch(baseLink, "tempMaxF")); // 1 Max temperature
			result.add(fetch(baseLink, "tempMinF")); // 2 Min temperature
			result.add(fetch(baseLink, "weatherDesc")); // 3 Weather Condition
			result.add(fetch(baseLink, "weatherIconUrl")); // 4 Condition image
		}catch (Exception e){
			result.add("ERROR:Connection Problem");
            result.add("ERROR:Connection Problem");
            result.add("ERROR:Connection Problem");
            result.add("ERROR:Connection Problem");
		}	
		return result;
	}

	public String formatSearch(String userSearch){
        String[] holder = userSearch.split(" ");
        String appendies = "%22";
        for(int i = 0; i < holder.length; i++) {
            appendies+=holder[i];
            if(i != holder.length-1)
                appendies+="+";
        }
        appendies+="%22";
        return appendies;
    }

    private static String fetch(String requestUrl, String tagName){
        String celsius = null;
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(requestUrl);
            Node n = doc.getElementsByTagName(tagName).item(0);
            celsius = n.getTextContent();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return celsius;
    }
}




