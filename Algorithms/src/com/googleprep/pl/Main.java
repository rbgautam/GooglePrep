/**
 * 
 */
package com.googleprep.pl;

import com.googleprep.utils.KeyboardInput;

/**
 * @author Deltaman
 * 
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		KeyboardInput keyObj;
		String tagStr ="Menu";
		System.out.println("Menu List\n----------");
		System.out.println(ReadXML.ReadTopMenu(tagStr));
		Console cObj = Console.CreateConsole();
		cObj.setData(ReadXML.getMenuCount());
		keyObj = cObj.getData();
		String userInput = keyObj.getStrUserInput();
		
		System.out.println("User Choice is "+userInput);
		
//		int intUserInput =Integer.parseInt(userInput);
//		//System.out.println(ReadXML.readSubMenu(tagStr, intUserInput));
//		cObj = Console.CreateConsole();
//		cObj.setData(ReadXML.getMenuCount());
//		keyObj = cObj.getData();
		

	}

}
