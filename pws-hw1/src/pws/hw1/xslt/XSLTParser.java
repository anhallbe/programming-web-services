package pws.hw1.xslt;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 *
 * @author andreas
 */
public class XSLTParser {
    public static void parseXSLT(String stylesheetPath, String transcriptPath, String profilePath) {
        File transcript = new File(transcriptPath);
        File profile = new File(profilePath);
        File stylesheet = new File(stylesheetPath);
        
        TransformerFactory factory = TransformerFactory.newInstance();
        Source xslt = new StreamSource(stylesheet);
        try {
            Transformer transformer = factory.newTransformer(xslt);
            Source input = new StreamSource(transcript);
            transformer.transform(input, new StreamResult(profile));
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(XSLTParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(XSLTParser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
//    public static void main(String[] args) {
//        String stylesheet = "/home/andreas/Development/programming-web-services/pws-hw1/src/pws/hw1/xslt/transcriptStylesheet.xml";
//        String input = "/home/andreas/Development/programming-web-services/pws-hw1/src/pws/hw1/xml/hogwarts-transcript.xml";
//        String output = "/home/andreas/Development/programming-web-services/pws-hw1/src/pws/hw1/xslt/applicant-profile-test.xml";
//        
//        parseXSLT(stylesheet, input, output);
//        System.out.println("Done!");
//    }
}