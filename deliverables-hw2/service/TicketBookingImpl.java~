package pws.hw2;

import java.util.List;
import java.util.ArrayList;
import javax.jws.WebService;

@WebService()
public class TicketBookingImpl implements TicketBooking {

	@Override
	public List<Ticket> ticketBooking(String creditCard, Itinerary itinerary) {
		List<Ticket> tickets = new ArrayList<>();
		
		for(Flight flight : itinerary.getFlights()) {
		    Ticket ticket = new Ticket();
		    ticket.setFlight(flight);
		    if(flight.getSeats() > 1) {
		        ticket.setBooked(true);
		        flight.setSeats(flight.getSeats()-1);
		    } else
		        ticket.setBooked(false);
		    tickets.add(ticket);
		}
		
		return tickets;
    }
}
