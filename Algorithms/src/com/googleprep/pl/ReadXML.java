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
		try
		{
			File xmlFile = new File("Menu.XML");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);
			return doc;
		}
		 finally {
			 //xmlFile.Close();
		}
	}

	public static StringBuffer ReadTopMenu(String nodeName) {

		StringBuffer menuString = new StringBuffer();
		try {
			// XML File Reading
			Document doc = xmlFile();
			// formats or normalized the file in case it is not
			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName(nodeName);
			NodeList nSubList = doc.getElementsByTagName("SubMenu");
			String iCount, XMLstr;
			int nListLength = nList.getLength();

			for (int i = 0; i < nListLength; i++) {
				Node nNode = nList.item(i);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					iCount = ((Integer) (i + 1)).toString();
					menuString.append(iCount + "."
							+ eElement.getAttribute("text") + "\n");
					setMenuCount(iCount);

					XMLstr = eElement.getAttribute("text");

					for (int j = 0; j < nSubList.getLength(); j++) {
						Node nSubNode = nSubList.item(j);

						if (nSubNode.getNodeType() == Node.ELEMENT_NODE) {
							Element element = (Element) nSubNode;
							if (element.getAttribute(XMLstr) != "")
								menuString.append(element.getAttribute(XMLstr)
										+ "\n");

							// System.out.println("Element: " +
							// ((Element)nSubList.item(j)).getNodeName());
							// System.out.println("SubMenu"+element.getAttribute(XMLstr));

						}

					}
				}
			}
		}

		catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		} finally {

		}
		return menuString;
	}

	/**
	 * @return
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */

}
