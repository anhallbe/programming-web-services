
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

    private final static QName _PriceOutputResponse_QNAME = new QName("http://hw2.pws/", "priceOutputResponse");
    private final static QName _PriceOutput_QNAME = new QName("http://hw2.pws/", "priceOutput");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: pws.hw2
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PriceOutputResponse }
     * 
     */
    public PriceOutputResponse createPriceOutputResponse() {
        return new PriceOutputResponse();
    }

    /**
     * Create an instance of {@link PriceOutput_Type }
     * 
     */
    public PriceOutput_Type createPriceOutput_Type() {
        return new PriceOutput_Type();
    }

    /**
     * Create an instance of {@link Flight }
     * 
     */
    public Flight createFlight() {
        return new Flight();
    }

    /**
     * Create an instance of {@link Itinerary }
     * 
     */
    public Itinerary createItinerary() {
        return new Itinerary();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PriceOutputResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hw2.pws/", name = "priceOutputResponse")
    public JAXBElement<PriceOutputResponse> createPriceOutputResponse(PriceOutputResponse value) {
        return new JAXBElement<PriceOutputResponse>(_PriceOutputResponse_QNAME, PriceOutputResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PriceOutput_Type }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hw2.pws/", name = "priceOutput")
    public JAXBElement<PriceOutput_Type> createPriceOutput(PriceOutput_Type value) {
        return new JAXBElement<PriceOutput_Type>(_PriceOutput_QNAME, PriceOutput_Type.class, null, value);
    }

}
