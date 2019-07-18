package com.example.tdd;

import java.util.HashMap;

public class MathFactory {
	
	static HashMap<String, String> classNames = new HashMap<String, String>();
	
	static {
		classNames.put("+", "com.example.tdd.Addition");
		classNames.put("-", "com.example.tdd.Subtraction");
		classNames.put("*", "com.example.tdd.Multiplication");
		classNames.put("/", "com.example.tdd.Division");
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
