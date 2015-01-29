package pws.hw1.sax;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author andreas
 */
public class SAXPParser {
    
    public SAXPParser() {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            
            saxParser.parse(new File("/home/andreas/Development/programming-web-services/pws-hw1/src/pws/hw1/xml/hogwarts-transcript.xmll"), new SAXTranscriptHandler());
            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(SAXPParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(SAXPParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SAXPParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    private class SAXTranscriptHandler extends DefaultHandler {
        public Transcript transcript = new Transcript();
        
        @Override
        public void startDocument() throws SAXException {
            super.startDocument(); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void endDocument() throws SAXException {
            super.endDocument(); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            super.characters(ch, start, length); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            super.startElement(uri, localName, qName, attributes); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            super.endElement(uri, localName, qName); //To change body of generated methods, choose Tools | Templates.
        }
    }
}
