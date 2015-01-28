/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pws.hw1.dom;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

    private CV cv = new CV();
    
    public DOMParser() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);
        factory.setNamespaceAware(true);
        factory.setIgnoringElementContentWhitespace(true);
        factory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");
        factory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaSource", "/home/andreas/Development/programming-web-services/pws-hw1/src/pws/hw1/xml/CV.xsd");
        
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("/home/andreas/Development/programming-web-services/pws-hw1/src/pws/hw1/xml/ronald-cv.xml"));
            
//            System.out.println("Root element :" + document.getDocumentElement().getNodeName());
            
            Node root = document.getFirstChild();
            NodeList children = root.getChildNodes();
            
            for(Node child = root.getFirstChild(); child != null; child = child.getNextSibling()) {
                processNode(child);
            }
            System.out.println("CV:\n" + cv);
            
        } catch (ParserConfigurationException ex) {
            System.out.println(ex);
        } catch (SAXException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    
    public static void main(String[] args) {
        new DOMParser();
    }
    
    private void processNode(Node node) {
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
    
    private class CV {
        public String surName, lastName, address, city, country, phone, email, about;
        public Date birthDate;
        public List<Reference> references;

        @Override
        public String toString() {
            String result = "";
            result += "surname: " + surName;
            result += "\nlastname: " + lastName;
            result += "\naddress: " + address;
            result += "\ncity: " + city;
            result += "\ncountry: " + country;
            result += "\nphone: " + phone;
            result += "\nemail: " + email;
            result += "\nabout: " + about;
            result += "\nbirthdate: " + birthDate;
            result += "\nreferences: ";
            for(Reference ref : references) {
                result += "\n------------";
                result += "\n" + ref.name;
                result += "\n" + ref.about;
                result += "\n" + ref.contactInfo;
            }
            return result;
        }
        
        public String getSurName() {
            return surName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getAddress() {
            return address;
        }

        public String getCity() {
            return city;
        }

        public String getCountry() {
            return country;
        }

        public String getPhone() {
            return phone;
        }

        public String getEmail() {
            return email;
        }

        public String getAbout() {
            return about;
        }

        public Date getBirthDate() {
            return birthDate;
        }

        public List<Reference> getReferences() {
            return references;
        }

        public void setAbout(String about) {
            this.about = about;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public void setBirthDate(Date birthDate) {
            this.birthDate = birthDate;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public void setReferences(List<Reference> references) {
            this.references = references;
        }

        public void setSurName(String surName) {
            this.surName = surName;
        }
    }
    
    private class Reference {
        public String name, about, contactInfo;

        public void setAbout(String about) {
            this.about = about;
        }

        public void setContactInfo(String contactInfo) {
            this.contactInfo = contactInfo;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
