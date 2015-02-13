package hw3.client;

import hw3.jaxb.Flight;
import hw3.jaxb.Route;
import hw3.jaxb.Ticket;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class RESTClient {
	public static void main(String[] args) {
		Client client = Client.create();
		
		
		
		//___________TASK 1 AUTH_________________
		System.out.println("Testing authenticator service...");
		WebResource authenticator = client.resource("http://localhost:8080/HW3/rest/auth/user/pass");
		String authToken = authenticator.accept(MediaType.TEXT_PLAIN).get(String.class);
		System.out.println("Received auth token: " + authToken);
		
		
		
		//___________TASK 2 FLIGHTFINDER__________
		System.out.println("\nTesting FlightFinder service...");
		WebResource flightfinder = client.resource("http://localhost:8080/HW3/rest/findflights/Stockholm/Madrid/" + authToken);
		GenericType<List<Route>> generic = new GenericType<List<Route>>() {};
		List<Route> routes = flightfinder.accept(MediaType.APPLICATION_XML).get(generic);
		System.out.println("Flight routes:");
		for(Route route : routes) {
			System.out.println("---------------------------------");
			for(Flight flight : route.getFlights())
				System.out.println(flight.getFrom() + "-->" + flight.getTo());
		}
		System.out.println("---------------------------------");
		
		
		
		//___________TASK 3 TICKET AVAILABILITY____
		System.out.println("\nTesting ticket availibility service...");
		MultivaluedMap<String, String> flightIDs = new MultivaluedMapImpl();
		Route testRoute = routes.get(0);
		List<String> ids = new ArrayList<String>();
		for(Flight f : testRoute.getFlights())
			ids.add("" + f.getId());
		flightIDs.put("flightIDs", ids);
		
		WebResource ticketAvail = client.resource("http://localhost:8080/HW3/rest/ticket/available/" + authToken);
		ClientResponse ticketAvailResponse = ticketAvail.queryParams(flightIDs).get(ClientResponse.class);
		String seatsPrice[] = ticketAvailResponse.getEntity(String.class).split(",");
		String seats = seatsPrice[0];
		String price = seatsPrice[1];
		System.out.println("Requested ticket availability and pricing for flights: " + flightIDs.get("flightIDs"));
		System.out.println("Available tickets: " + seats + " at price " + price);
		
		
		//___________TASK 4 PRICE OUTPUT_____________
		System.out.println("\nTesting price output service...");
		WebResource priceRes = client.resource("http://localhost:8080/HW3/rest/ticket/prices/Stockholm/Madrid/" + authToken);
		String output = priceRes.accept(MediaType.TEXT_PLAIN).get(String.class);
		System.out.println("Result: " + output);
		
		
		//___________TASK 5 TICKET BOOKING_________________
		System.out.println("\nTesting ticket booking service...");
		List<String> ticketRefs = new ArrayList<String>();
		for(Flight flight : routes.get(0).getFlights()) {
			String id = "" + flight.getId();
			WebResource ticketBooker = client.resource("http://localhost:8080/HW3/rest/ticket/book/" + id + "/mycredit/" + authToken);
			String ticketRef = ticketBooker.accept(MediaType.TEXT_PLAIN).get(String.class);
			ticketRefs.add(ticketRef);
			System.out.println("Booked ticket for flight " + id + ", from " + flight.getFrom() + " to " + flight.getTo() + ". Reference: " + ticketRef);
		}
		
		
		//___________TASK 6 TICKET ISSUING_________________
		System.out.println("\nTesting ticket booking service...");
		for(String ref : ticketRefs) {
			WebResource ticketIssuer = client.resource("http://localhost:8080/HW3/rest/ticket/issue/" + ref + "/" + authToken);
			GenericType<Ticket> gen = new GenericType<Ticket>() {};
			Ticket ticket = ticketIssuer.accept(MediaType.APPLICATION_XML).get(gen);
			System.out.println("Issued ticket for flight " + ticket.getFlightID());
		}
		
		System.out.println("Done!");
	}
}
