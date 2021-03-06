package pws.hw2;

import java.util.ArrayList;
import java.util.List;
import pws.hw2.Flight;
import pws.hw2.Itinerary;
import pws.hw2.Ticket;

public class FlightServiceTestClient {
    
    private static final String departure = "Stockholm";
    private static final String destination = "Madrid";
    private static final String userID = "user1";
    private static final String password = "password1";

    public static void main(String[] args) {
        //TASK 1
        boolean authenticated = authenticate(userID, password);
        System.out.println("Task 1:");
        System.out.println("authenticated: " + authenticated);
        
        //TASK 2
        List<Itinerary> possibleItineraries = possibleItineraries(departure, destination);
//        List<Itinerary> possibleItineraries = new ArrayList<>();
//        Itinerary it = new Itinerary();
//        Flight fl = new Flight();
//        fl.setFrom("A");
//        fl.setTo("B");
//        fl.setID(123);
//        fl.setPrice(100);
//        fl.setSeats(100);
//        it.getFlights().add(fl);
//        possibleItineraries.add(it);
        System.out.println("Task 2:");
        System.out.println("itineraries:");
        for(Itinerary i : possibleItineraries) {
            System.out.println("________");
            for(Flight f : i.getFlights())
                System.out.println("\t" + f.getFrom() + "-->" + f.getTo());
        }
//        
        
        //TASK 3
        List<Integer> allSeats = new ArrayList<>();
        List<Integer> allPrices = new ArrayList<>();
        for(Itinerary i : possibleItineraries) {
            allSeats.add(availableSeats(i));
            allPrices.add(ticketPrice(i));
        }
        System.out.println("Task 3:");
        System.out.println("prices:");
        for(Integer s : allSeats)
            System.out.println(s);
        System.out.println("available seats");
        for(Integer p : allPrices)
            System.out.println(p);
        
        //TASK 4
        List<Integer> availablePrices = priceOutput(possibleItineraries);
        System.out.println("Task 4:");
        System.out.println("available prices:");
        for(Integer p : availablePrices)
            System.out.println(p);
        
        //TASK 5
        List<Ticket> tickets = ticketBooking("MY CREDIT CARD NUMBER IS NOT A NUMBER LOL", possibleItineraries.get(0));
        System.out.println("Task 5:");
        System.out.println("tickets:");
        for(Ticket t : tickets)
            System.out.println("Flight " + t.getFlight().getID() + ", booked: " + t.isBooked());
            
        //TASK 6
        List<Boolean> successfulIssues = new ArrayList<>();
        for(Ticket t : tickets)
            successfulIssues.add(ticketIssue(t));
        System.out.println("Task 6:");
        System.out.println("booked tickets:");
        for(Boolean i : successfulIssues)
            System.out.println(i); 
    }

    private static java.util.List<pws.hw2.Itinerary> possibleItineraries(java.lang.String departure, java.lang.String destination) {
        pws.hw2.FlightFinder_Service service = new pws.hw2.FlightFinder_Service();
        pws.hw2.FlightFinder port = service.getFlightFinderPort();
        return port.possibleItineraries(departure, destination);
    }

    private static boolean authenticate(java.lang.String userID, java.lang.String password) {
        pws.hw2.CustomerAuthenticationService_Service service = new pws.hw2.CustomerAuthenticationService_Service();
        pws.hw2.CustomerAuthenticationService port = service.getCustomerAuthenticationPort();
        return port.authenticate(userID, password);
    }

    private static int availableSeats(pws.hw2.Itinerary itinerary) {
        pws.hw2.TicketAppraiser_Service service = new pws.hw2.TicketAppraiser_Service();
        pws.hw2.TicketAppraiser port = service.getTicketAppraiserPort();
        return port.availableSeats(itinerary);
    }

    private static int ticketPrice(pws.hw2.Itinerary itinerary) {
        pws.hw2.TicketAppraiser_Service service = new pws.hw2.TicketAppraiser_Service();
        pws.hw2.TicketAppraiser port = service.getTicketAppraiserPort();
        return port.ticketPrice(itinerary);
    }

    private static java.util.List<java.lang.Integer> priceOutput(java.util.List<pws.hw2.Itinerary> arg0) {
        pws.hw2.PriceOutput_Service service = new pws.hw2.PriceOutput_Service();
        pws.hw2.PriceOutput port = service.getPriceOutputPort();
        return port.priceOutput(arg0);
    }

    private static java.util.List<pws.hw2.Ticket> ticketBooking(java.lang.String arg0, pws.hw2.Itinerary arg1) {
        pws.hw2.TicketBooking_Service service = new pws.hw2.TicketBooking_Service();
        pws.hw2.TicketBooking port = service.getTicketBookingPort();
        return port.ticketBooking(arg0, arg1);
    }

    private static boolean ticketIssue(pws.hw2.Ticket arg0) {
        pws.hw2.TicketIssue_Service service = new pws.hw2.TicketIssue_Service();
        pws.hw2.TicketIssue port = service.getTicketIssuePort();
        return port.ticketIssue(arg0);
    }
   
}
