/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pws.hw1.dom;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author andreas
 */
public class DOMParser {
    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);
        factory.setNamespaceAware(true);
        factory.setIgnoringElementContentWhitespace(true);
        factory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");
        factory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaSource", "file:/home/andreas/Development/programming-web-services/pws-hw1/src/pws/hw1/xml/CV.xsd");
        
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("/home/andreas/Development/programming-web-services/pws-hw1/src/pws/hw1/xml/ronald-cv.xml"));
            
            Node root = document.getFirstChild();
            NodeList children = root.getChildNodes();
            
            for(Node child = root.getFirstChild(); child != null; child = child.getNextSibling()) {
                processNode(child);
            }
            
        } catch (ParserConfigurationException ex) {
            System.out.println(ex);
        } catch (SAXException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    private static void processNode(Node child) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
