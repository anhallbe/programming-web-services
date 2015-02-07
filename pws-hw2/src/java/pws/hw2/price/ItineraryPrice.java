package pws.hw2.price;

import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import pws.hw2.flight.Itinerary;
import pws.hw2.flightfinder.FlightFinder;
import pws.hw2.ticket.TicketAppraiser;

/**
 *
 * @author andreas
 */
@WebService(serviceName = "ItineraryPrice", portName = "ItineraryPricePort", endpointInterface = "pws.hw2.price.ItineraryPrice", targetNamespace = "http://price.hw2.pws/", wsdlLocation = "WEB-INF/wsdl/ItineraryPrice/ItineraryPrice.wsdl")
public class ItineraryPrice {

    public java.util.List<java.lang.Integer> itineraryPrices(java.lang.String departure, java.lang.String destination) {
        System.out.println("itineraryPrices(" + departure + ", " + destination + ") called.");
        List<Integer> resultOffline = new ArrayList<>();
        resultOffline = offlineInvocation(departure, destination);
        return resultOffline;
    }
    
    private List<Integer> offlineInvocation(String from, String to) {
        FlightFinder flightFinder = new FlightFinder();
        TicketAppraiser appraiser = new TicketAppraiser();
        List<Integer> prices = new ArrayList<>();
        
        List<Itinerary> possibleItineraries = flightFinder.possibleItineraries(from, to);
        System.out.println("Possible itineraries = " + possibleItineraries.size());
        
        for(Itinerary i : possibleItineraries) {
            int seats = appraiser.availableSeats(i);
            if(seats > 0)
                prices.add(i.getPrice());
        }
        return prices;
    }
}
