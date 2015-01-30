/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pws.hw1.jaxb;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

/**
 *
 * @author andreas
 */
public class JAXBParser {
    public static CompanyType parseCompany(String xmlSource) {
        try {
            JAXBContext jc = JAXBContext.newInstance("pws.hw1.jaxb");
            Unmarshaller u = jc.createUnmarshaller();
//            Source source = new StreamSource(new File("/home/andreas/Development/programming-web-services/pws-hw1/src/pws/hw1/xml/cauldrons-info.xml"));
            Source source = new StreamSource(new File(xmlSource));
            JAXBElement<CompanyType> root = u.unmarshal(source, CompanyType.class);
            CompanyType company = root.getValue();
            
            System.out.println(company.getName());
            System.out.println(company.getDescription());
            System.out.println(company.getKeywords());
        } catch (JAXBException ex) {
            Logger.getLogger(JAXBParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public static void main(String[] args) {
        String path = "/home/andreas/Development/programming-web-services/pws-hw1/src/pws/hw1/xml/cauldrons-info.xml";
        parseCompany(path);
    }
}
