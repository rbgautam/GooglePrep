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
		System.out.println("Menu List-------------");
		System.out.println(ReadXML.ReadTopMenu("Menu"));
//		;
		Console cObj = Console.CreateConsole();
		cObj.setData(ReadXML.getMenuCount());
		keyObj = cObj.getData();
		String userInput = keyObj.getStrUserInput();
		// print 1,2,3 
//		String useSelection = keyObj.getNumOption();
		System.out.println(userInput);
		
		
		
		
	
	}

}
