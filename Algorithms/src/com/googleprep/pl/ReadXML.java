package com.googleprep.pl;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class ReadXML {
	
	private static String menuCount= new String();

	public static String getMenuCount() {
		return menuCount;
	}

	public static void setMenuCount(String count) {
		menuCount = menuCount + " " +count;
	}

	public static StringBuffer ReadTopMenu(String nodeName) {

		StringBuffer menuString = new StringBuffer();
		

		try {
			// File Reading
			File xmlFile = new File("Menu.XML");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);
			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName(nodeName);
			String iCount;
			for (int i = 0; i < nList.getLength(); i++) {
				
				Node nNode = nList.item(i);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					iCount = ((Integer)(i+1)).toString();
					menuString.append(iCount+"."+  eElement.getAttribute("text")+"\n");
					setMenuCount(iCount);
				}
			}
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		} finally {
			
		}
		return menuString;
	}

}
