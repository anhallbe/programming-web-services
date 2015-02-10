package pws.hw2;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author andreas
 */
@WebService(serviceName = "TicketAppraiser",
        portName = "TicketAppraiserPort")
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
//        return itinerary.getPrice();
        int total = 0;
        for(Flight f : itinerary.getFlights())
            total += f.getPrice();
        return total;
    }
}
