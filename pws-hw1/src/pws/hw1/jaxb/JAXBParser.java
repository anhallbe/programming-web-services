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
    public static CompanyInfo parseCompany(String xmlSource) {
        try {
            JAXBContext jc = JAXBContext.newInstance("pws.hw1.jaxb");
            Unmarshaller u = jc.createUnmarshaller();
            Source source = new StreamSource(new File(xmlSource));
            JAXBElement<CompanyInfo> root = u.unmarshal(source, CompanyInfo.class);
            CompanyInfo company = root.getValue();
            return company;
        } catch (JAXBException ex) {
            Logger.getLogger(JAXBParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
}
