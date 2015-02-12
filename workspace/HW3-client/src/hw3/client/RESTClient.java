package hw3.client;

import hw3.jaxb.Flight;
import hw3.jaxb.Route;

import java.util.List;

import javax.ws.rs.core.MediaType;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

public class RESTClient {
	public static void main(String[] args) {
		Client client = Client.create();
		
		//___________TASK 1 AUTH_________________
		System.out.println("Testing authenticator service");
		WebResource authenticator = client.resource("http://localhost:8080/HW3/rest/auth/user/pass");
		String authToken = authenticator.accept(MediaType.TEXT_PLAIN).get(String.class);
		System.out.println("Received auth token: " + authToken);
		
		//___________TASK 2 FLIGHTFINDER__________
		System.out.println("Testing FlightFinder service");
		WebResource flightfinder = client.resource("http://localhost:8080/HW3/rest/findflights/Stockholm/Madrid/" + authToken);
		GenericType<List<Route>> generic = new GenericType<List<Route>>() {};
		List<Route> routes = flightfinder.accept(MediaType.APPLICATION_XML).get(generic);
		System.out.println("Flight routes:");
		for(Route route : routes) {
			System.out.println("---------------------------------");
			for(Flight flight : route.getFlights())
				System.out.println(flight.getFrom() + "-->" + flight.getTo());
		}
	}
}
