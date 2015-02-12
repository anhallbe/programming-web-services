package hw3.services;

import hw3.bean.Flight;
import hw3.store.FlightStore;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/findflights")
public class FlightFinder {
	
	@Path("/{from}/{to}")
	@GET
	public List<List<Flight>> findFlights(@PathParam("from") String from, @PathParam("to") String to) {
//		List<List<Flight>> result = new ArrayList<List<Flight>>();
		if(FlightStore.flights == null)
			FlightStore.initStore();
		
		List<Flight> allFlights = findPaths(from, to);
		List<List<Flight>> result = structurePaths(allFlights, from, to);		
		return result;
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
	
	private List<List<Flight>> structurePaths(List<Flight> flights, String from, String to) {
//        List<Itinerary> itineraries = new ArrayList<>();
		List<List<Flight>> itineraries = new ArrayList<List<Flight>>();
//        Itinerary temp = new Itinerary();
		List<Flight> temp = new ArrayList<Flight>();
        
        for(Flight f : flights) {
            if(f.getFrom().equals(from))
            	temp = new ArrayList<Flight>();
//                temp = new Itinerary();
            //temp.addFlight(f);
//		temp.getFlights().add(f);
            temp.add(f);
            if(f.getTo().equals(to))
                itineraries.add(temp);
        }
        return itineraries;
    }
}
