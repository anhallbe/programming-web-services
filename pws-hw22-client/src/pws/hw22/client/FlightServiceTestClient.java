package pws.hw22.client;

public class FlightServiceTestClient {

    public static void main(String[] args) {
        // TODO code application logic here
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
