package com.googleprep.pl;

//import javax.print.Doc;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;


import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
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

	@SuppressWarnings("finally")
	private static Document xmlFile() //throws ParserConfigurationException,SAXException, IOException {
	{
		Document doc = null;
		try {
			File xmlFile = new File("Menu.XML");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			doc = builder.parse(xmlFile);
			return doc;
		} catch(Exception e) {
			System.err.println("Error : "+e);
		}
		finally{
			return doc;
		}
	}

	public static StringBuffer ReadTopMenu(String nodeName) {
		StringBuffer menuString = new StringBuffer();
		try {
			int i;
			// XML File Reading
			Document doc = xmlFile();
			// formats or normalized the file in case it is not
			doc.getDocumentElement().normalize();
			Element root = doc.getDocumentElement();
			System.out.println("-"+root.getTagName()+"-");
			String iCount;
			
			NodeList childern = root.getChildNodes();
			//System.out.println(root.getNodeName());
			//System.out.println("*"+root.getChildNodes()+"*");
			//System.out.println("FirstChild"+root.getFirstChild());
			System.out.println("childern.getLength()"+childern.getLength());
			for (Node childNode = root.getFirstChild();childNode != null;childNode = childNode.getNextSibling())
			{
				System.out.println(" Child "+childNode.getLocalName());
			}

		}
		catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		} finally {

		}
		return menuString;
	}

}

//
//
//for(i = 0; i <childern.getLength(); i++)
//{
//	Node child = childern.item(i);
//	
//	if(child instanceof Element)
//	{
//		//System.out.println(i+"*"+childern.item(i)+"*");
//		Element childElement = (Element) child; 
//		Text textNode = (Text) childElement.getFirstChild();
//		String text = textNode.getData().trim();
//		//System.out.println(i+"**"+text);
//		if (childElement.getTagName().equals("Menu"))
//		{
//			String name = text;;
//			iCount = ((Integer) (i + 1)).toString();
//			menuString.append(iCount + "."+ name + "\n");
//			setMenuCount(iCount);
//			
//		}
//			
//			
//	}
//}



//
//NodeList nList; //, nSubList;
//Node nNode ; //, nSubNode;
//Element eElement;//, eSubElement;
//String iCount;//, iSubCount;
//int i;//, j;
//int nListLength;//, nSubListLength;
//
//nList = doc.getElementsByTagName(nodeName);
//nListLength = nList.getLength();
//for (i = 0; i < nListLength; i++) {
//	nNode = nList.item(i);
//
//	if (nNode.getNodeType() == Node.ELEMENT_NODE) {
//		eElement = (Element) nNode;
//		iCount = ((Integer) (i + 1)).toString();
//		menuString.append(iCount + "."
//				+ eElement.getAttribute("text") + "\n");
//		setMenuCount(iCount);
//		
//	}// End of if nNode
//}

