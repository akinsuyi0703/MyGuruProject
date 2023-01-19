package com.myguruproject.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
Properties pro;
	
	public ReadConfig() {
	
	File src =new File("./Configuration/config.properties");
	
	try {
		FileInputStream fis=new FileInputStream(src);
		
		pro=new Properties();
		
		pro.load(fis);
	} catch (Exception e) {
		System.out.println("Not able to load config file >>"+e.getMessage());
	
	}
	
	}
	
	 public String  getBrowser() {
		 
	    	String browser=pro.getProperty("browser"); // we can write it this way or
			return browser;
			
	}
	 public String getBaseURL() {
	    	String baseURL=pro.getProperty("baseURL");
			return baseURL;
		
	}

	 public String getUsername(){
	    	return pro.getProperty("username"); //this can be use too
	    	
	}
	    
	 public String getPassword() {
	    	return pro.getProperty("password");
	}

      

}
