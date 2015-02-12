package hw3.services;

import hw3.bean.Flight;
import hw3.store.FlightStore;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/ticket")
public class TicketAvailability {

	@Path("/available")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String available(@QueryParam("flightIDs") List<String> flightIDs) {
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
	}
}
