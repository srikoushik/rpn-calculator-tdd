package com.example.tdd;

import java.util.Stack;

public class RpnCalculator {
	
	private Stack<Double> operands;
	private double firstOperand, secondOperand;
	
	public RpnCalculator() {
		operands = new Stack<Double>();
	}
	
	public double solve(String expression) {
		String [] tokens = expression.split(" ");
		
		IMathOperation mathOperation;
		for (String token: tokens) {
			
			if( isMathOperator(token) ) {
				secondOperand = operands.pop();
				firstOperand = operands.pop();
				mathOperation = MathFactory.getObject(token);
				double result = mathOperation.evaluate(firstOperand, secondOperand);
				operands.push(result);				
			} else {
				operands.push(Double.parseDouble(token));
			}
		}
		return operands.pop();
	}

	private boolean isMathOperator(String token) {		
		String operators = "+-/*";
		return operators.contains(token);
	}

}
