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
        
        System.out.println("Done !");
    }
}