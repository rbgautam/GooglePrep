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
		String tagStr ="MenuRoot";
		System.out.println("Menu List\n----------");
		System.out.println(ReadXML.ReadTopMenu(tagStr)); //call to read  an xml file
		Console cObj = Console.CreateConsole();  // Create a console object
		cObj.setData(ReadXML.getMenuCount()); // display main menu read from an xml file
		keyObj = cObj.getData();  //  read user's choice from the keyboard
		
		String userInput = keyObj.getStrUserInput();
		System.out.println("User Choice is "+userInput);
		
		KeyboardInput keyObjNew = null;
		System.out.println(ReadXML.ReadSubMenu(userInput));
		
		cObj.setData(ReadXML.getMenuCount()); // display main menu read from an xml file
		keyObjNew = cObj.getData();  //  read user's choice from the keyboard
		String userInputSubMenu = keyObjNew.getStrUserInput();
		System.out.println("User Choice is "+userInputSubMenu);
		
	}

}
