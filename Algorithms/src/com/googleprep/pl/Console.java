package com.googleprep.pl;

import com.googleprep.utils.KeyboardInput;
/**
 * 
 * Purpose of the console is to create a class to dealt with console 
 * User's Input output
 *
 */

public class Console {
	private static Console instance = null;
	private KeyboardInput data;
	private Console() {
		
		//System.out.println(ReadXML.ReadTopMenu("Menu"));
	}

	public static Console CreateConsole(){
		if (instance==null)
			instance=new Console();
		
		return instance;
	}

	public void setData(String menuOptions) {
		this.data = new KeyboardInput(menuOptions);
	}

	public KeyboardInput getData() {
		return data;
	}
	

}
