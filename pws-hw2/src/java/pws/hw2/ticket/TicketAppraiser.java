package pws.hw2.ticket;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import pws.hw2.flight.Flight;
import pws.hw2.flight.Itinerary;

/**
 *
 * @author andreas
 */
@WebService(serviceName = "TicketAppraiser")
public class TicketAppraiser {

    @WebMethod(operationName = "availableSeats")
    public int availableSeats(@WebParam(name = "itinerary") Itinerary itinerary) {
        int minimumSeats = Integer.MAX_VALUE;
        for(Flight f : itinerary.getFlights())
            if(f.getSeats() < minimumSeats)
                minimumSeats = f.getSeats();
        return minimumSeats;
    }
    
    @WebMethod(operationName = "ticketPrice")
    public int ticketPrice(@WebParam(name = "itinerary") Itinerary itinerary) {
        return itinerary.getPrice();
    }
}
