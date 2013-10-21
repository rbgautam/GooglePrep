package com.googleprep.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class KeyboardInput {
	private String strUserInput;
	private String numOption;

	public String getNumOption() {
		return numOption;
	}

	public void setNumOption(String numOption) {
		this.numOption = numOption;
	}

	public KeyboardInput(String strUserInput) {
		this.strUserInput = ReadUserInput(strUserInput);
	}

	public String getStrUserInput() {
		return strUserInput;
	}

	public void setStrUserInput(String strUserInput) {
		this.strUserInput = strUserInput;
	}
	
	public String ReadUserInput(String menuOptions) {
		
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			System.out.println("Enter your selection "+menuOptions+": ");
			setStrUserInput(br.readLine());
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} 
		finally {
			
		}
		
		return getStrUserInput();
	}
}