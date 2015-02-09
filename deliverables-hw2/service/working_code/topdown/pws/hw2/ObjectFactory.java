
package pws.hw2;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the pws.hw2 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _TicketIssueResponse_QNAME = new QName("http://hw2.pws/", "ticketIssueResponse");
    private final static QName _TicketIssue_QNAME = new QName("http://hw2.pws/", "ticketIssue");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: pws.hw2
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TicketIssueResponse }
     * 
     */
    public TicketIssueResponse createTicketIssueResponse() {
        return new TicketIssueResponse();
    }

    /**
     * Create an instance of {@link TicketIssue_Type }
     * 
     */
    public TicketIssue_Type createTicketIssue_Type() {
        return new TicketIssue_Type();
    }

    /**
     * Create an instance of {@link Flight }
     * 
     */
    public Flight createFlight() {
        return new Flight();
    }

    /**
     * Create an instance of {@link Ticket }
     * 
     */
    public Ticket createTicket() {
        return new Ticket();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TicketIssueResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hw2.pws/", name = "ticketIssueResponse")
    public JAXBElement<TicketIssueResponse> createTicketIssueResponse(TicketIssueResponse value) {
        return new JAXBElement<TicketIssueResponse>(_TicketIssueResponse_QNAME, TicketIssueResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TicketIssue_Type }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hw2.pws/", name = "ticketIssue")
    public JAXBElement<TicketIssue_Type> createTicketIssue(TicketIssue_Type value) {
        return new JAXBElement<TicketIssue_Type>(_TicketIssue_QNAME, TicketIssue_Type.class, null, value);
    }

}
