package com.googleprep.algos;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class ReadXML {

	public static StringBuffer ReadTopMenu() {

		StringBuffer menuString = new StringBuffer();

		try {
			// File Reading
			File xmlFile = new File("Menu.XML");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);
			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName("Menu");
			for (int i = 0; i < nList.getLength(); i++) {
				Node nNode = nList.item(i);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					menuString.append(eElement.getAttribute("Text"));
				}
			}
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		} finally {
			return menuString;
		}
	}

}
