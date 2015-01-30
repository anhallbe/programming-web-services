package pws.hw1.sax;

import java.io.File;
import java.io.IOException;
import java.util.Date;
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
    
    public static EmploymentRecord parseEmploymentRecord(String xmlPath) {
        SAXEmploymentRecordHandler handler = new SAXEmploymentRecordHandler();
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            
//            saxParser.parse(new File("/home/andreas/Development/programming-web-services/pws-hw1/src/pws/hw1/xml/ronald-record.xml"), handler);
            saxParser.parse(new File(xmlPath), handler);
            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(SAXPParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(SAXPParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SAXPParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return handler.record;
    }
    
    public static Transcript parseTranscript(String xmlPath) {
        SAXTranscriptHandler handler = new SAXTranscriptHandler();
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            
//            saxParser.parse(new File("/home/andreas/Development/programming-web-services/pws-hw1/src/pws/hw1/xml/ronald-record.xml"), handler);
            saxParser.parse(new File(xmlPath), handler);
            
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
//        EmploymentRecord record = SAXPParser.parseEmploymentRecord();
//        System.out.println(record);
//        System.out.println("______________________________________________________");
//        for(Employment e : record.getEmployments())
//            System.out.println(e.getCompany());
//    }
    
    private static class SAXEmploymentRecordHandler extends DefaultHandler {
        public EmploymentRecord record = new EmploymentRecord();
        private Employment employment;
        private String content = "";

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            content = String.copyValueOf(ch, start, length).trim();
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            switch(qName) {
                case "employment":
                    employment = new Employment();
                    break;
                case "employmentRecord":
                    record = new EmploymentRecord();
                    break;
            }
            content = "";
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            switch(qName) {
                case "surname":
                    record.setSurName(content);
                    break;
                case "lastname":
                    record.setLastName(content);
                    break;
                case "companyName":
                    employment.setCompany(content);
                    break;
                case "start":
                    employment.setStart(stringToDate(content));
                    break;
                case "end":
                    employment.setEnd(stringToDate(content));
                    break;
                case "monthlySalary":
                    employment.setSalary(Integer.parseInt(content));
                    break;
                case "employment":
                    record.addEmployment(employment);
                    break;
            }
        }
        
        private Date stringToDate(String date) {
            String[] dateStrings = date.split("-");
            int year = Integer.parseInt(dateStrings[0]);
            int month = Integer.parseInt(dateStrings[1]);
            int day = Integer.parseInt(dateStrings[2]);
            Date result = new Date(year, month, day);
            return result;
        }
    }
    
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
                case "transcript":
                    transcript = new Transcript();
                    break;
                case "courses":
                    course = new Course();
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
                case "credits":
                    course.setCredits(Integer.parseInt(content));
                    break;
                
                case "courses":
                    transcript.addCourse(course);
                    break;
            }
        }
    }
}
