/**
 * 
 */
package com.googleprep.algos;

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

		System.out.println(ReadXML.ReadTopMenu("Menu"));
		Console cObj = Console.CreateConsole();
		String userInput = cObj.ReadUserInput();
		System.out.println(userInput);
		
		
		
		
	
	}

}
