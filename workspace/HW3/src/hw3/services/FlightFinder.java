package hw3.services;

import hw3.bean.Flight;
import hw3.bean.Route;
import hw3.store.AuthStore;
import hw3.store.FlightStore;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/findflights")
public class FlightFinder {
	
	@Path("/{from}/{to}/{token}")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Route> findFlights(@PathParam("from") String from, @PathParam("to") String to, @PathParam("token") String token) {
//		List<List<Flight>> result = new ArrayList<List<Flight>>();
		if(AuthStore.tokens.contains(token)) {
			if(FlightStore.flights == null)
				FlightStore.initStore();
			
			List<Flight> allFlights = findPaths(from, to);
			List<Route> result = structurePaths(allFlights, from, to);		
			return result;
		} else {
			System.err.println("INVALID AUTHORIZATION TOKEN");
			return null;
		}
	}
	
	private List<Flight> findPaths(String from, String to) {
        return findPaths(from, to, new ArrayList<>(), new ArrayList<>());
    }
	
	private List<Flight> findPaths(String current, String dest, List<Flight> flightsTaken, List<String> visitedCities) {
        if(current.equals(dest))
            return flightsTaken;
        
        List<Flight> path = new ArrayList<>();
        for(Flight f : FlightStore.flights.values()) {
            if(f.getFrom().equals(current) && !visitedCities.contains(f.getTo())) {
                List<Flight> newVisited = new ArrayList<>(flightsTaken);
                newVisited.add(f);
                List<String> newVisitedCities = new ArrayList<>(visitedCities);
//                newVisitedCities.add(f.getTo());
                newVisitedCities.add(f.getFrom());
                List<Flight> tail = findPaths(f.getTo(), dest, newVisited, newVisitedCities);
                path.addAll(tail);
            }
        }
        return path;
    }
	
	private List<Route> structurePaths(List<Flight> flights, String from, String to) {
//        List<Itinerary> itineraries = new ArrayList<>();
		List<Route> routes = new ArrayList<Route>();
//        Itinerary temp = new Itinerary();
//		List<Flight> temp = new ArrayList<Flight>();
		Route temp = new Route();
        
        for(Flight f : flights) {
            if(f.getFrom().equals(from)) {
            	temp = new Route();
            	temp.setFlights(new ArrayList<Flight>());
            }
            temp.getFlights().add(f);
            if(f.getTo().equals(to))
                routes.add(temp);
        }
        return routes;
    }
}
