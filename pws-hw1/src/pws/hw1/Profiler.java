/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pws.hw1;

import pws.hw1.dom.CV;
import pws.hw1.dom.DOMParser;
import pws.hw1.jaxb.CompanyInfo;
import pws.hw1.jaxb.JAXBParser;
import pws.hw1.sax.EmploymentRecord;
import pws.hw1.sax.SAXPParser;
import pws.hw1.xslt.XSLTParser;

/**
 *
 * @author andreas
 */
public class Profiler {
    private CV cv;
    private EmploymentRecord employmentRecord;
    private CompanyInfo company;
    
    private final String PROFILE_PATH = "src/pws/hw1/xml/applicant-profile.xml";
    
    public Profiler() {
        initObjects();
    }
    
    private void initObjects() {
        String cvSchema = "src/pws/hw1/xml/CV.xsd";
        String cvXML = "src/pws/hw1/xml/ronald-cv.xml";
        cv = DOMParser.parseCV(cvXML, cvSchema);
        
        String recordXML = "src/pws/hw1/xml/ronald-record.xml";
        employmentRecord = SAXPParser.parseEmploymentRecord(recordXML);
        
        String companyXML = "src/pws/hw1/xml/cauldrons-info.xml";
        company = JAXBParser.parseCompany(companyXML);
    }
    
    private void processTranscript() {
        String stylesheet = "src/pws/hw1/xslt/transcriptStylesheet.xml";
        String transcriptSource = "src/pws/hw1/xml/hogwarts-transcript.xml";
        XSLTParser.parseTranscript(stylesheet, transcriptSource, PROFILE_PATH);
    }
    
    public static void main(String[] args) {
        new Profiler();
    }
}
