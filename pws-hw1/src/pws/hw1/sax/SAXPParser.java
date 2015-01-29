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
    
    public static Transcript parseTranscript() {
        SAXTranscriptHandler handler = new SAXTranscriptHandler();
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            
            saxParser.parse(new File("/home/andreas/Development/programming-web-services/pws-hw1/src/pws/hw1/xml/hogwarts-transcript.xml"), handler);
            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(SAXPParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(SAXPParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SAXPParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return handler.transcript;
    }
    
//    public static void main(String[] args) {
//        Transcript transcript = SAXPParser.parseTranscript();
//        System.out.println(transcript);
//    }
    
    private static class SAXTranscriptHandler extends DefaultHandler {
        public Transcript transcript = new Transcript();
        private Course course;
        private String content = "";

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            content = String.copyValueOf(ch, start, length).trim();
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            switch(qName) {
                case "courses":
                    course = new Course();
                    break;
                case "transcript":
                    transcript = new Transcript();
                    break;
            }
            content = "";
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            switch(qName) {
                case "name":
                    transcript.setName(content);
                    break;
                case "university":
                    transcript.setUniversity(content);
                    break;
                case "degree":
                    transcript.setDegree(content);
                    break;
                case "year":
                    transcript.setYear(Integer.parseInt(content));
                    break;
                case "courseName":
                    course.setName(content);
                    break;
                case "courseCode":
                    course.setCode(content);
                    break;
                case "grade":
                    course.setGrade(Integer.parseInt(content));
                    break;
                case "courses":
                    transcript.addCourse(course);
                    break;
            }
        }
    }
}
