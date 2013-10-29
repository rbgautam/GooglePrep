package com.googleprep.pl;

//import javax.print.Doc;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
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
	private static Document xmlFile() // throws
										// ParserConfigurationException,SAXException,
										// IOException {
	{
		Document doc = null;
		try {
			File xmlFile = new File("Menu.XML");
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			doc = builder.parse(xmlFile);
			return doc;
		} catch (Exception e) {
			System.err.println("Error : " + e);
		} finally {
			return doc;
		}
	}

	public static StringBuffer ReadTopMenu(String nodeName) {
		StringBuffer menuString = new StringBuffer();
		try {
			// XML File Reading
			Document doc = xmlFile();
			// formats or normalized the file in case it is not
			doc.getDocumentElement().normalize();
			Element root = doc.getDocumentElement();
			// System.out.println("-" + root.getTagName() + "-");
			String iCount;

			NodeList children = root.getChildNodes();

			// Parsing through all the child elements
			for (int i = 0; i < children.getLength(); i++) {

				Node child = children.item(i);
				// Only parse through the ELEMENT nodes
				if (child instanceof Element) {
					Element childElement = (Element) child;
					// Fetching the attributes for the element
					displayAttributes(childElement, "text");
					// System.out.println(childElement.getTagName());

				}

			}

		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		} finally {

		}
		return menuString;
	}

	/**
	 * @param childElement
	 * @param attrName
	 *            displays the value of the passed attribute
	 */
	private static void displayAttributes(Element childElement, String attrName) {
		NamedNodeMap attrs = childElement.getAttributes();
		for (int j = 0; j < attrs.getLength(); j++) {
			Node attribute = attrs.item(j);
			if (attribute.getNodeName() != attrName)
				System.out.println();
			System.out.print(" " + attribute.getNodeValue());
		}
	}

	public static StringBuffer ReadSubMenu(String userInput) {
		StringBuffer menuString = new StringBuffer();
		try {
			// XML File Reading
			Document doc = xmlFile();
			// formats or normalized the file in case it is not
			doc.getDocumentElement().normalize();
			Element root = doc.getDocumentElement();
			// System.out.println("-" + root.getTagName() + "-");
			String iCount;

			NodeList children = root.getChildNodes();

			// Parsing through all the child elements
			for (int i = 0; i < children.getLength(); i++) {

				Node child = children.item(i);
				// Only parse through the ELEMENT nodes
				if (child instanceof Element) {
					Element childElement = (Element) child;
					// Fetching the attributes for the element
					NamedNodeMap attrs = childElement.getAttributes();
					for (int j = 0; j < attrs.getLength(); j++) {
						Node attribute = attrs.item(j);
						//if the attribute "id" matches the userinput then parse the next level
						if (attribute.getNodeName() == "id" && attribute.getNodeValue().equals(userInput)) {
							//get the children of the current element
							NodeList subMenu = childElement.getChildNodes();
							for (int k = 0; k < subMenu.getLength(); k++) {
								Node subMenuChild = subMenu.item(k);
								if (subMenuChild instanceof Element) {
									Element subMenuChildElement = (Element) subMenuChild;
									Text subMenuText = (Text) subMenuChildElement.getFirstChild();
									menuString.append("\n"+subMenuText.getData().trim());
								}
							}
						}
					}

				}
			}

		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		} finally {

		}
		return menuString;
	}

}
