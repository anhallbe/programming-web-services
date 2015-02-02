package pws.hw1.xslt;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    /**
     * Processes any XML (inputPath) using the xslt stylesheet (stylesheetPath)
     * and generates a new xml at outputPath. This is really only used to 
     * calculate the GPA from the applicant profile and insert it into
     * the resulting XML.
     * @param stylesheetPath
     * @param inputPath
     * @param outputPath 
     */
    public static void processGPA(String stylesheetPath, String inputPath, String outputPath) {
        File inputXML = new File(inputPath);
        File outputXML = new File(outputPath);
        File stylesheet = new File(stylesheetPath);
        
        TransformerFactory factory = TransformerFactory.newInstance();
        Source xslt = new StreamSource(stylesheet);
        try {
            Transformer transformer = factory.newTransformer(xslt);
            Source input = new StreamSource(inputXML);
            transformer.transform(input, new StreamResult(outputXML));
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(XSLTParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(XSLTParser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}