package com.googleprep.algos;

import java.io.*;

public class Console {
	private static Console instance = null;
	private Console() {
		
		//System.out.println(ReadXML.ReadTopMenu("Menu"));
	}

	public static Console CreateConsole(){
		if (instance==null)
			instance=new Console();
		
		return instance;
	}
	String ReadUserInput() {
		String str= new String();
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			System.out.println("Enter your selection (1, 2 or 3): ");
			str = br.readLine();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} 
		finally {
			
		}
		
		return str;
	}

}
