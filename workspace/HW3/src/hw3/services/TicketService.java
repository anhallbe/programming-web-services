package hw3.services;

import hw3.bean.Flight;
import hw3.bean.Route;
import hw3.bean.Ticket;
import hw3.store.AuthStore;
import hw3.store.FlightStore;
import hw3.store.TicketStore;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

@Path("/ticket")
public class TicketService {

	@Path("/available/{authToken}")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String available(@QueryParam("flightIDs") List<String> flightIDs, @PathParam("authToken") String authToken) {
		if(AuthStore.tokens.contains(authToken)) {
			if(FlightStore.flights == null)
				FlightStore.initStore();
			int minSeats = Integer.MAX_VALUE;
			int totalPrice = 0;
			
			for(String fid : flightIDs) {
				int id = Integer.parseInt(fid);
				Flight flight = FlightStore.flights.get(id);
				if(flight.getSeats() < minSeats)
					minSeats = flight.getSeats();
				totalPrice += flight.getPrice();
			}
			return minSeats + "," + totalPrice;
		} else {
			System.err.println("INVALID AUTHORIZATION TOKEN");
			return "INVALID AUTHORIZATION TOKEN";
		}
	}
	
	@Path("/prices/{from}/{to}/{token}")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String prices(@PathParam("from") String from, @PathParam("to") String to, @PathParam("token") String token) {
		Client client = Client.create();
		
		WebResource flightfinder = client.resource("http://localhost:8080/HW3/rest/findflights/Stockholm/Madrid/" + token);
		GenericType<List<Route>> generic = new GenericType<List<Route>>() {};
		List<Route> routes = flightfinder.accept(MediaType.APPLICATION_XML).get(generic);
		
		String result = "Found " + routes.size() + " routes from " + from + " to " + to + ":\n";
		for(Route route : routes) {
			String routeIds = "(";
			int routePrice = 0;
			for(Flight flight : route.getFlights()) {
				routePrice += flight.getPrice();
				routeIds += flight.getId() + " ";
			}
			result += routeIds + ") at price " + routePrice + "\n";
			
		}
		
		return result;
	}

	@Path("/book/{flightId}/{creditcard}/{authToken}")
	@GET
	public String bookTicket(@PathParam("flightId") String flightID, @PathParam("creditcard") String creditcard, @PathParam("authToken") String authToken) {
		if(AuthStore.tokens.contains(authToken)) {
			if(FlightStore.flights == null)
				FlightStore.initStore();
			String bookingRef = authToken + flightID;
			Flight flight = FlightStore.flights.get(Integer.parseInt(flightID));
			if(flight.getSeats() > 0)
				flight.setSeats(flight.getSeats()-1);
			Ticket ticket = new Ticket(Integer.parseInt(flightID), false, creditcard);
			TicketStore.tickets.put(Long.parseLong(bookingRef), ticket);
			return bookingRef;
		} else {
			System.err.println("INVALID AUTHORIZATION TOKEN");
			return "INVALID AUTHORIZATION TOKEN";
		}
	}
	
	@Path("/issue/{ref}/{authToken}")
	@GET
	public Ticket issueTicket(@PathParam("ref") String ref, @PathParam("authToken") String authToken) {
		Ticket ticket = null;
		if(AuthStore.tokens.contains(authToken)) {
			Ticket temp = TicketStore.tickets.get(Long.parseLong(ref));
			if(temp == null || temp.isIssued())
				return null;
			else {
				temp.setIssued(true);
				ticket = temp;
			}
		} else
			System.err.println("INVALID AUTHORIZATION TOKEN");
		return ticket;
	}
}
