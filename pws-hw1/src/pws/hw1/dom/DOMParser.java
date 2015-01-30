/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pws.hw1.dom;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

  //  private CV cv = new CV();
    
    public static CV parseCV(String xmlSource, String schema) {
        CV cv = new CV();
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);
        factory.setNamespaceAware(true);
        factory.setIgnoringElementContentWhitespace(true);
        factory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");
        factory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaSource", schema);
        
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
//            Document document = builder.parse(new File("/home/andreas/Development/programming-web-services/pws-hw1/src/pws/hw1/xml/ronald-cv.xml"));
            Document document = builder.parse(new File(xmlSource));
            
//            System.out.println("Root element :" + document.getDocumentElement().getNodeName());
            
            Node root = document.getFirstChild();
            NodeList children = root.getChildNodes();
            
            for(Node child = root.getFirstChild(); child != null; child = child.getNextSibling()) {
                processNode(child, cv);
            }
            
        } catch (ParserConfigurationException ex) {
            System.out.println(ex);
        } catch (SAXException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }
        
        return cv;
    }
    
//    public static void main(String[] args) {
//        CV cv = DOMParser.parseCV();
//        System.out.println("CV:\n" + cv);
//    }
    
    private static void processNode(Node node, CV cv) {
        switch(node.getNodeName()) {
            case "surname":
                cv.setSurName(node.getTextContent());
                break;
            case "lastname":
                cv.setLastName(node.getTextContent());
                break;
            case "birthdate":
                String[] dateStrings = node.getTextContent().split("-");
                int year = Integer.parseInt(dateStrings[0]);
                int month = Integer.parseInt(dateStrings[1]);
                int day = Integer.parseInt(dateStrings[2]);
                Date birthDate = new Date(year, month, day);
                cv.setBirthDate(birthDate);
                break;
            case "address":
                cv.setAddress(node.getTextContent());
                break;
            case "city":
                cv.setCity(node.getTextContent());
                break;
            case "country":
                cv.setCountry(node.getTextContent());
                break;
            case "phone":
                cv.setPhone(node.getTextContent());
                break;
            case "email":
                cv.setEmail(node.getTextContent());
                break;
            case "about":
                cv.setAbout(node.getTextContent());
                break;
            case "references":
                List<Reference> references = new ArrayList();
                for(Node child = node.getFirstChild(); child != null; child = child.getNextSibling()) {
                    Reference reference = new Reference();
                    for(Node ref = child.getFirstChild(); ref != null; ref = ref.getNextSibling()) {
                        switch(ref.getNodeName()) {
                            case "refName":
                                reference.setName(ref.getTextContent());
                            case "refAbout":
                                reference.setAbout(ref.getTextContent());
                            case "refContactInfo":
                                reference.setContactInfo(ref.getTextContent());
                        }
                    }
                    references.add(reference);
                }
                cv.setReferences(references);
                break;
            default:
                System.err.println("SOMETHING'S WRONG");
        }
    }
}
