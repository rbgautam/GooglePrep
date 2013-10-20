package com.googleprep.algos;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class KeyboardInput {
	private String strUserInput;

	public KeyboardInput(String strUserInput) {
		this.strUserInput = ReadUserInput();
	}

	public String getStrUserInput() {
		return strUserInput;
	}

	public void setStrUserInput(String strUserInput) {
		this.strUserInput = strUserInput;
	}
	
	public String ReadUserInput() {
		
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			System.out.println("Enter your selection (1, 2 or 3): ");
			setStrUserInput(br.readLine());
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} 
		finally {
			
		}
		
		return getStrUserInput();
	}
}