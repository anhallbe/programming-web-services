/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pws.hw1;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import pws.hw1.Profile.Education.AcademicRecord.Courses;
import pws.hw1.Profile.Employments.Employment;
import pws.hw1.dom.CV;
import pws.hw1.dom.DOMParser;
import pws.hw1.dom.Reference;
import pws.hw1.jaxb.CompanyInfo;
import pws.hw1.jaxb.JAXBParser;
import pws.hw1.sax.Course;
import pws.hw1.sax.EmploymentRecord;
import pws.hw1.sax.SAXPParser;
import pws.hw1.sax.Transcript;
import pws.hw1.xslt.XSLTParser;

/**
 *
 * @author andreas
 */
public class Profiler {
    private CV cv;
    private EmploymentRecord employmentRecord;
    private CompanyInfo company;
    private Transcript transcript;
    private Profile profile;
    
    private final String PROFILE_PATH = "src/pws/hw1/xml/applicant-profile.xml";
    
    public Profiler() {
        initObjects();
        initProfile();
        
        try {
            File applicantProfileXML = new File(PROFILE_PATH);
            JAXBContext context = JAXBContext.newInstance(Profile.class);
            Marshaller marshaller = context.createMarshaller();
            
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(profile, applicantProfileXML);
            marshaller.marshal(profile, System.out);
        } catch (JAXBException ex) {
            Logger.getLogger(Profiler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        processGPA();
    }
    
    private void initObjects() {
        String cvSchema = "src/pws/hw1/xml/CV.xsd";
        String cvXML = "src/pws/hw1/xml/ronald-cv.xml";
        cv = DOMParser.parseCV(cvXML, cvSchema);
        
        String recordXML = "src/pws/hw1/xml/ronald-record.xml";
        employmentRecord = SAXPParser.parseEmploymentRecord(recordXML);
        
        String companyXML = "src/pws/hw1/xml/cauldrons-info.xml";
        company = JAXBParser.parseCompany(companyXML);
        
        String transcriptXML = "src/pws/hw1/xml/hogwarts-transcript.xml";
        transcript = SAXPParser.parseTranscript(transcriptXML);
    }
    
    private void processGPA() {
        String stylesheet = "src/pws/hw1/xslt/gpaStylesheet.xsl";
        String profileSource = PROFILE_PATH;
        String result = "src/pws/hw1/xml/result.xml";
        XSLTParser.processGPA(stylesheet, profileSource, result);
    }

    private void initProfile() {
        //Process CV
        profile = new Profile();
        profile.setSurname(cv.getSurName());
        profile.setLastname(cv.getLastName());
        profile.setBirthdate(toGregorian(cv.getBirthDate()));
        profile.setEmail(cv.getEmail());
        profile.setPhone(cv.getPhone());
        profile.setAddress(cv.getAddress());
        profile.setCity(cv.getCity());
        profile.setCountry(cv.getCountry());
        profile.setAbout(cv.getAbout());
        profile.setKeywords(new Profile.Keywords()); // @TODO: Fix this
        profile.setReferences(null);
        
        profile.setReferences(new Profile.References());
        for(Reference r : cv.getReferences()) {
            Profile.References.Reference profileReference = new Profile.References.Reference();
            profileReference.setRefName(r.getName());
            profileReference.setRefAbout(r.getAbout());
            profileReference.setRefContactInfo(r.getContactInfo());
            
            profile.getReferences().getReference().add(profileReference);
        }
        //process Transcript
        profile.setEducation(new Profile.Education());
        Profile.Education.AcademicRecord aRecord = new Profile.Education.AcademicRecord();
        List<Profile.Education.AcademicRecord.Courses> courses = new ArrayList<>();
        for(Course c : transcript.getCourses()) {
            Courses course = new Profile.Education.AcademicRecord.Courses();
            course.setCourseName(c.getName());
            course.setCourseCode(c.getCode());
            course.setGrade(c.getGrade());
            course.setCredits(c.getCredits());
            
            courses.add(course);
        }
        aRecord.setUniversity(transcript.getUniversity());
        aRecord.setDegree(transcript.getDegree());
        aRecord.setYear(transcript.getYear());
        aRecord.courses = courses;
        profile.getEducation().getAcademicRecord().add(aRecord);
        
        //process Employment Record
        profile.setEmployments(new Profile.Employments());
        for(pws.hw1.sax.Employment e : employmentRecord.getEmployments()) {
            Employment pEmployment = new Employment();
            pEmployment.setCompanyName(e.getCompany());
            pEmployment.setCompanyDescription("Some description");  //TODO: fix
            pEmployment.setStart(toGregorian(e.getStart()));
            pEmployment.setEnd(toGregorian(e.getEnd()));
            pEmployment.setMonthlySalary(e.getSalary());
            
            profile.getEmployments().getEmployment().add(pEmployment);
        }
        
        //Process company info, for recommended positions
        profile.setRecommendedJobs(new Profile.RecommendedJobs());
        for(CompanyInfo.AvailablePositions.Position recPos : company.getAvailablePositions().getPosition()) {
            Profile.RecommendedJobs.Job job = new Profile.RecommendedJobs.Job();
            job.setCompany(company.getName());
            job.setTitle(recPos.getTitle());
            job.setDescription(recPos.getDescription());
            
            profile.getRecommendedJobs().getJob().add(job);
        }
    }
    
    private XMLGregorianCalendar toGregorian(Date date) {
        GregorianCalendar gCal = new GregorianCalendar();
        gCal.setTime(date);
        XMLGregorianCalendar xmlCal = null;
        try {
            xmlCal = DatatypeFactory.newInstance().newXMLGregorianCalendar(gCal);
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(Profiler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return xmlCal;
    }
    
    public static void main(String[] args) {
        new Profiler();
    }
}
