/**
 * 
 */
package com.googleprep.pl;

import com.googleprep.utils.KeyboardInput;
import com.slist.SLinkedList;

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
		/**
		 * To generate menu and sub menu from an XML file
		 */
		// KeyboardInput keyObj;
		// String tagStr ="MenuRoot";
		// System.out.println("Menu List\n----------");
		// System.out.println(ReadXML.ReadTopMenu(tagStr)); //call to read an
		// xml file
		// Console cObj = Console.CreateConsole(); // Create a console object
		// cObj.setData(ReadXML.getMenuCount()); // display main menu read from
		// an xml file
		// keyObj = cObj.getData(); // read user's choice from the keyboard
		//
		// String userInput = keyObj.getStrUserInput();
		// System.out.println("User Choice is "+userInput);
		//
		// KeyboardInput keyObjNew = null;
		// System.out.println(ReadXML.ReadSubMenu(userInput));
		//
		// cObj.setData(ReadXML.getMenuCount()); // display main menu read from
		// an xml file
		// keyObjNew = cObj.getData(); // read user's choice from the keyboard
		// String userInputSubMenu = keyObjNew.getStrUserInput();
		// System.out.println("User Choice is "+userInputSubMenu);

		/**
		 * To test Slist
		 */

		// //addFirst
//		DeleteLater_AddFirst();
		//addLast
//		DeleteLater_AddLast();
		// getNth
//		DeleteLater_getNth();
		//addAtNth
//		DeleteLater_addAtNth(2,111);
		//replaceNth
//		DeleteLater_replaceNth();

	}

	public static void DeleteLater_replaceNth()
	{
		SLinkedList sll = new SLinkedList();
		int result=9999;
		//Empty List
		result = sll.replaceNth(0,100);
		System.out.println("Cannot Insert "+result);
		
		sll.addFirst(1);
		result= sll.replaceNth(-1,100);
		System.out.println("Cannot Insert MIN_VALUE "+result+ " List "+sll.toString());
		result= sll.replaceNth(0,100);
		System.out.println("Replaced MAN_VALUE "+result+ " List "+sll.toString());
		result= sll.replaceNth(1,100);
		System.out.println("Replaced MAN_VALUE "+result+ " List "+sll.toString());
		
	}
	public static void DeleteLater_addAtNth(int index,int intData)
	{
		SLinkedList sll = new SLinkedList();
		sll.addFirst(1);
		sll.addFirst(2);
		sll.addLast(10);
		sll.addLast(20);
		sll.addLast(30);
		sll.addLast(40);
		sll.addLast(50);
		sll.addLast(60);
		System.out.println("List before insertion "+sll.toString());
		
		Integer result;
		Integer data = (Integer)intData;
		
		result = sll.addAtNth(index,data);
		
		if (result == Integer.MAX_VALUE)
			System.out.println("Returned Value "+result + " List "+sll.toString());
		else
			System.out.println("Node not inserted Returned Value "+result +" List remains the same "+sll.toString());
		//System.out.println("Data inserted "+"Returned Value "+result + " List "+sll.toString());
	}
	
	public static void DeleteLater_getNth()
	{
		int found, index =1 ;
		SLinkedList sll = new SLinkedList();
		found = sll.getNth(index);
		System.out.println("List"+ sll.toString());
		for(index = -1;index<=sll.length(); index++)
		{
			found = sll.getNth(index);
			if(found == Integer.MAX_VALUE)
			{
				System.out.println("Index is negative or larger than lenght of list");
			}
			else if(found == Integer.MIN_VALUE)
			{
					System.out.println("List is empty");
			}
			else{
					System.out.println("Index "+ index+  " Found Result " + found );
			}
		}
	
		sll.addFirst(1);
		sll.addFirst(2);
		sll.addFirst(3);
		sll.addFirst(4);
		sll.addFirst(5);
		sll.addFirst(6);
		
		System.out.println("\nList "+ sll.toString());
		for(index = -1;index<=sll.length(); index++)
		{
			found = sll.getNth(index);
			if(found == Integer.MAX_VALUE)
			{
				System.out.println("Index is negative or larger than lenght of list");
			}
			else if(found == Integer.MIN_VALUE)
			{
					System.out.println("List is empty");
			}
			else{
					System.out.println("Index "+ index+  " Found Result " + found );
			}
		}
		
	}

	public static void DeleteLater_AddFirst() {
		SLinkedList sll = new SLinkedList();
		System.out.println(sll.isEmpty());
		System.out.println(sll.toString());
		sll.addFirst(1);
		sll.addFirst(2);
		sll.addFirst(3);
		sll.addFirst(4);
		sll.addFirst(5);
		sll.addFirst(6);
		System.out.println(sll.toString());
		System.out.println(sll.length());
	}

	public static void DeleteLater_AddLast() {
		SLinkedList sll = new SLinkedList();
		System.out.println(sll.isEmpty());
		System.out.println(sll.toString());
		sll.addLast(1);
		sll.addLast(2);
		sll.addLast(3);
		sll.addLast(4);
		sll.addLast(5);
		sll.addLast(6);
		System.out.println(sll.toString());
		System.out.println(sll.length());
	}

}
