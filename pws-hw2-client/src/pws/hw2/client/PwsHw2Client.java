/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pws.hw2.client;

import java.util.List;
import pws.hw2.flightfinder.Flight;
import pws.hw2.flightfinder.Itinerary;

/**
 *
 * @author andreas
 */
public class PwsHw2Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Client started.");
        
        //_____________________Task 1_______________________
        System.out.println("_________________Task 1__________________");
        String uid = "user1";
        String password = "password1";
        System.out.println("Authenticating user1-password1");
        boolean authenticated = authenticate(uid, password);
        System.out.println("Authenticated: " + authenticated);
        
        //_____________________Task 2______________________
        System.out.println("_________________Task 2__________________");
        String departure = "Stockholm";
        String destination = "Madrid";
        System.out.println("Flights between " + departure + " and " + destination);
        List<Itinerary> result = possibleItineraries(departure, destination);
        for(Itinerary i : result) {
            System.out.println("________________________________");
            for(Flight f : i.getFlights())
                System.out.println("\t" + f.getFrom() + "-->" + f.getTo());
        }
        
        //_____________________Task 3______________________
//        System.out.println("_________________Task 3__________________");
//        System.out.println("Available seats and prices for itineraries:");
//        for(Itinerary i : result) {
//            pws.hw2.ticket.Itinerary it = new pws.hw2.ticket.Itinerary();
//            int seats = availableSeats(i);
//        }
//        
//        pws.hw2.ticket.Itinerary i = new pws.hw2.ticket.Itinerary();
    }

    private static java.util.List<pws.hw2.flightfinder.Itinerary> possibleItineraries(java.lang.String departure, java.lang.String destination) {
        pws.hw2.flightfinder.FlightFinder_Service service = new pws.hw2.flightfinder.FlightFinder_Service();
        pws.hw2.flightfinder.FlightFinder port = service.getFlightFinderPort();
        return port.possibleItineraries(departure, destination);
    }

    private static boolean authenticate(java.lang.String userID, java.lang.String password) {
        hw2.pws.auth.CustomerAuthenticationService_Service service = new hw2.pws.auth.CustomerAuthenticationService_Service();
        hw2.pws.auth.CustomerAuthenticationService port = service.getCustomerAuthenticationPort();
        return port.authenticate(userID, password);
    }

    private static int availableSeats(pws.hw2.ticket.Itinerary itinerary) {
        pws.hw2.ticket.TicketAppraiser_Service service = new pws.hw2.ticket.TicketAppraiser_Service();
        pws.hw2.ticket.TicketAppraiser port = service.getTicketAppraiserPort();
        return port.availableSeats(itinerary);
    }

    private static int ticketPrice(pws.hw2.ticket.Itinerary itinerary) {
        pws.hw2.ticket.TicketAppraiser_Service service = new pws.hw2.ticket.TicketAppraiser_Service();
        pws.hw2.ticket.TicketAppraiser port = service.getTicketAppraiserPort();
        return port.ticketPrice(itinerary);
    }
    
    
}
