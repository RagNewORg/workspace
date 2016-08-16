package com.amazon.search.tool;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;


public class ItemSearch {

	
 
     private final String ENDPOINT = "webservices.amazon.com";
	// private final String ENDPOINT = "ecs.amazonaws.com";
    

    public List<Product> itemSearch(String accesKey, String secretKey, String keywords) {
        
        
        SignedRequestsHelper helper = null;
        try {
            helper = SignedRequestsHelper.getInstance(ENDPOINT, accesKey, secretKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        String requestUrl = null;


        
        System.out.println("Map form example:");
        Map<String, String> params = new HashMap<String, String>();
        params.put("Service", "AWSECommerceService");
        params.put("Operation", "ItemSearch");
        params.put("Keywords", keywords);
        params.put("SearchIndex", "Toys");
        params.put("AssociateTag", "Toys");
        requestUrl = helper.sign(params);
        System.out.println("Signed Request is \"" + requestUrl + "\"");

       
        
        /*
        System.out.println("String form example:");
        
        
        String queryString = "Service=AWSECommerceService&Operation=ItemSearch&Keywords=Rocket&SearchIndex=Toys&AssociateTag=Toys";
        requestUrl = helper.sign(queryString);
        System.out.println("Request is \"" + requestUrl + "\"");

        title = fetchTitle(requestUrl);
        System.out.println("Title is \"" + title + "\"");
        System.out.println();
        */
        
        return itemData(requestUrl);
    }

    
    private List<Product> itemData (String requestUrl) {

        List<Product> table = new ArrayList<Product>();
        
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(requestUrl);
   
            
            
            for (int i = 0 ;i < doc.getElementsByTagName("Title").getLength(); i++ )
            {
            	Product item = new Product();
            	item.setItemDetails(doc.getElementsByTagName("DetailPageURL").item(i).getTextContent());
            	item.setItemManufacturer(doc.getElementsByTagName("Manufacturer").item(i).getTextContent());
            	item.setItemName(doc.getElementsByTagName("Title").item(i).getTextContent());
            	item.setAsin(doc.getElementsByTagName("ASIN").item(i).getTextContent());
            	table.add(item);           
            	
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return table;
    }
    
          
    
    	       

}