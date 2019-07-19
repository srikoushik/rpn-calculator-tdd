package com.example.tdd;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class MathFactory {
	
	private static HashMap<String, String> classNames;
	
	static {
		classNames = new HashMap<String, String>();
		FileInputStream file = null;
		try {
		 file = new FileInputStream("src/main/resources/config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		Properties properties = new Properties(); 
		
		try {
			properties.load(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		properties.forEach((key,value) -> {
			classNames.put((String)key,(String) value);
		});
	
	}	
	
	public static IMathOperation getObject(String token) {
		
		IMathOperation mathOperation = null;
		
		String className = classNames.get(token);
		
		try {
			mathOperation = (IMathOperation)Class.forName(className).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mathOperation;
	}
}
