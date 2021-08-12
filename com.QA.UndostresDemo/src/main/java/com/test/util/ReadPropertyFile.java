package com.test.util;

import java.io.*;
import org.apache.log4j.Logger;
import java.util.*;

public class ReadPropertyFile {
	
	String result = "";
	InputStream inputStream;
	
	public static final Logger log =	Logger.getLogger(ReadPropertyFile.class.getName());
	
	public String getPropValue(String propFileName, String key)	throws IOException	{
		
	try {
		Properties properties = new Properties();
		inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
		if (inputStream!=null)	{
			properties.load(inputStream);
			result = properties.getProperty(key);
		}
		else {
			System.out.println("Property file not found " + propFileName );
			throw new FileNotFoundException(propFileName);
		}
		
		}	catch (Exception e)	{
		log.error("Error getting Property Value" + propFileName + "-" + key );
		}
		return result;
	}

	
}
