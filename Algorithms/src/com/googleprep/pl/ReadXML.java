package com.googleprep.pl;

//import javax.print.Doc;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

/**
 * Class ReadXML is to read tags from a XML file and populated Menu's. So that
 * user can select subMenu
 * 
 **/
public class ReadXML {
	// menuCount is used in ReadTopMenu() to count number of tags with the
	// nodeName passes as a parameter in the function
	private static String menuCount = new String();

	public static String getMenuCount() {
		return menuCount;
	}

	public static void setMenuCount(String iCount) {
		// menuCount construct string for the choices user can make for the
		// subMenu(s)
		menuCount = menuCount + " " + iCount;
	}

	private static Document xmlFile() throws ParserConfigurationException,
			SAXException, IOException {
		try {
			File xmlFile = new File("Menu.XML");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);
			return doc;
		} finally {
			// xmlFile.Close();
		}
	}

	public static StringBuffer ReadTopMenu(String nodeName) {

		StringBuffer menuString = new StringBuffer();
		try {
			// XML File Reading
			Document doc = xmlFile();
			// formats or normalized the file in case it is not
			doc.getDocumentElement().normalize();

			NodeList nList, nSubList;
			Node nNode, nSubNode;
			Element eElement, eSubElement;
			String iCount, iSubCount;
			int i, j;
			int nListLength, nSubListLength;

			nList = doc.getElementsByTagName(nodeName);
			nListLength = nList.getLength();
			for (i = 0; i < nListLength; i++) {
				nNode = nList.item(i);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					eElement = (Element) nNode;
					iCount = ((Integer) (i + 1)).toString();
					menuString.append(iCount + "."
							+ eElement.getAttribute("text") + "\n");
					setMenuCount(iCount);
					
					// Test Block
					// nodeSubName == nSubNode.getNodeName()
					 //= eElement.getAttribute("text");
					
					String test = eElement.getAttribute("text");
					System.out.println(test);
					
//					if(eElement.getAttribute("text")==test)
//						System.out.println("True");
//					else
//						System.out.println("False");
					
					// End of test block
					
					String nodeSubName = "Sort";
					nSubList = doc.getElementsByTagName(nodeSubName);
					nSubListLength = nSubList.getLength();
					for (j = 0; j < nSubListLength; j++) {
						nSubNode = nSubList.item(j);

						if (nodeSubName == nSubNode.getNodeName()) { // Check for sub menu
							if (nSubNode.getNodeType() == Node.ELEMENT_NODE) {
								eSubElement = (Element) nSubNode;
								// System.out.println("Esub: "+eSubElement.getAttribute("Sort"));
								iSubCount = ((Integer) (i + 1)).toString();
								menuString.append( eSubElement.getAttribute("id")
										+ "\n");
								//System.out.println("E" +eSubElement.getAttribute("id"));
								setMenuCount(iSubCount);

							}// End of if nSubNode
						}
					}
				}// End of if nNode
			}
		}
		catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		} finally {

		}
		return menuString;
	}

}
