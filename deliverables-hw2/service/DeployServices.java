package pws.hw2;

import javax.xml.ws.Endpoint;

/**
 *
 * @author andreas
 */
public class DeployServices {
    public static void main(String[] args) {
	System.out.println("Starting Authentification service at http://localhost:8082/CustomerAuthentificationService/authenticate ...");
        Endpoint.publish("http://localhost:8082/CustomerAuthentificationService/authenticate", new CustomerAuthenticationService());
//	System.out.println("Authentication service started, url: http://localhost:8082/CustomerAuthentificationService/authenticate");
        
        System.out.println("Starting Flight Finder at http://localhost:8082/FlightFinder/flightfinder ...");
        Endpoint.publish("http://localhost:8082/FlightFinder/flightfinder", new FlightFinder());
        
        System.out.println("Starting Ticket Appraiser at http://localhost:8082/TicketAppraiser/ticketappraiser ...");
        Endpoint.publish("http://localhost:8082/TicketAppraiser/ticketappraiser", new TicketAppraiser());

	System.out.println("Starting Price Output at http://localhost:8082/PriceOutput/priceoutput ...");
        Endpoint.publish("http://localhost:8082/PriceOutput/priceoutput", new PriceOutputImpl());

	System.out.println("Starting Ticket Booking at http://localhost:8082/TicketBooking/ticketbooking ...");
        Endpoint.publish("http://localhost:8082/TicketBooking/ticketbooking", new TicketBookingImpl());

	System.out.println("Starting Ticket Issue at http://localhost:8082/TicketIssue/ticketissue ...");
        Endpoint.publish("http://localhost:8082/TicketIssue/ticketissue", new TicketIssueImpl());
        
        System.out.println("Done !");
    }
}
