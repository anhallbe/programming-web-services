
package pws.hw2;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "TicketBooking", targetNamespace = "http://hw2.pws/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface TicketBooking {


    /**
     * 
     * @param itinerary
     * @param creditCard
     * @return
     *     returns java.util.List<pws.hw2.Ticket>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "ticketBooking", targetNamespace = "http://hw2.pws/", className = "pws.hw2.TicketBooking_Type")
    @ResponseWrapper(localName = "ticketBookingResponse", targetNamespace = "http://hw2.pws/", className = "pws.hw2.TicketBookingResponse")
    @Action(input = "http://hw2.pws/TicketBooking/ticketBooking", output = "http://hw2.pws/TicketBooking/ticketBookingResponse")
    public List<Ticket> ticketBooking(
        @WebParam(name = "creditCard", targetNamespace = "")
        String creditCard,
        @WebParam(name = "itinerary", targetNamespace = "")
        Itinerary itinerary);

}
