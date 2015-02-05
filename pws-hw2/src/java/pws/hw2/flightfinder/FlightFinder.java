/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pws.hw2.flightfinder;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import pws.hw2.flight.Flight;
import pws.hw2.flight.Itinerary;

/**
 *
 * @author andreas
 */
@WebService(serviceName = "FlightFinder")
public class FlightFinder {
    
    private List<Flight> allFlights;
    
    
    
    public FlightFinder() {
        allFlights = new ArrayList<>();
        allFlights.add(new Flight("A", "B"));
        allFlights.add(new Flight("B", "C"));
        allFlights.add(new Flight("A", "C"));
        allFlights.add(new Flight("C", "A"));
        allFlights.add(new Flight("A", "D"));
        allFlights.add(new Flight("B", "D"));
        allFlights.add(new Flight("C", "D"));
        allFlights.add(new Flight("D", "C"));
        allFlights.add(new Flight("D", "A"));
//        allFlights.add(new Flight("Oslo", "Stockholm"));
//        allFlights.add(new Flight("Stockholm", "Oslo"));
//        allFlights.add(new Flight("Oslo", "Stockholm"));
//        allFlights.add(new Flight("Stockholm", "Munich"));
//        allFlights.add(new Flight("Munich", "Stockholm"));
//        allFlights.add(new Flight("Oslo", "Paris"));
//        allFlights.add(new Flight("Paris", "Oslo"));
//        allFlights.add(new Flight("Stockholm", "Berlin"));
//        allFlights.add(new Flight("Berlin", "Stockholm"));
//        allFlights.add(new Flight("Berlin", "London"));
//        allFlights.add(new Flight("London", "Berlin"));
//        allFlights.add(new Flight("Berlin", "Paris"));
//        allFlights.add(new Flight("Paris", "Berlin"));
//        allFlights.add(new Flight("London", "New York"));
//        allFlights.add(new Flight("New York", "London"));
//        allFlights.add(new Flight("Miami", "Munich"));
//        allFlights.add(new Flight("Munich", "Miami"));
//        allFlights.add(new Flight("Miami", "Austin"));
//        allFlights.add(new Flight("Austin", "Miami"));
//        allFlights.add(new Flight("Austin", "Las Vegas"));
//        allFlights.add(new Flight("Las Vegas", "Austin"));
//        allFlights.add(new Flight("Las Vegas", "San Fransisco"));
//        allFlights.add(new Flight("San Fransisco", "Las Vegas"));
//        allFlights.add(new Flight("San Fransisco", "Denver"));
//        allFlights.add(new Flight("Denver", "San Fransisco"));
//        allFlights.add(new Flight("Denver", "Los Angeles"));
//        allFlights.add(new Flight("Los Angeles", "Denver"));
//        allFlights.add(new Flight("Los Angeles", "New York"));
//        allFlights.add(new Flight("New York", "Los Angeles"));
//        allFlights.add(new Flight("New York", "Madrid"));
//        allFlights.add(new Flight("Madrid", "New York"));
//        allFlights.add(new Flight("Los Angeles", "Tokyo"));
//        allFlights.add(new Flight("Tokyo", "Los Angeles"));
//        allFlights.add(new Flight("Tokyo", "Stockholm"));
//        allFlights.add(new Flight("Stockholm", "Tokyo"));
    }

    /**
     * This is a sample web service operation
     * @return itineraries
     */
    @WebMethod(operationName = "possibleItineraries")
    public List<Itinerary> possibleItineraries(@WebParam(name = "departure") String departure, @WebParam(name = "destination") String destination) {
//        findItineraries(s);
//        return itineraries;
        List<Flight> fl = new ArrayList<>();
        fl.addAll(findPaths(departure, destination, new ArrayList<>(), new ArrayList<>()));
        List<Itinerary> result = structurePaths(fl, departure, destination);
        return result;
//        Itinerary i = new Itinerary(fl);
//        List<Itinerary> l = new ArrayList<>();
//        l.add(i);
//        return l;
    }
    
    private List<Flight> findPaths(String current, String dest, List<Flight> flightsTaken, List<String> visitedCities) {
        if(current.equals(dest))
            return flightsTaken;
        
        List<Flight> path = new ArrayList<>();
        for(Flight f : allFlights) {
//            if(f.getFrom().equals(current) && !flightsTaken.contains(f)) {
            if(f.getFrom().equals(current) && !visitedCities.contains(f.getTo())) {
                //result = result + ...
                List<Flight> newVisited = new ArrayList<>(flightsTaken);
                newVisited.add(f);
                List<String> newVisitedCities = new ArrayList<>(visitedCities);
                newVisitedCities.add(f.getTo());
                List<Flight> tail = findPaths(f.getTo(), dest, newVisited, newVisitedCities);
                path.addAll(tail);
            }
        }
        return path;
    }
    
    private List<Itinerary> structurePaths(List<Flight> flights, String from, String to) {
        List<Itinerary> itineraries = new ArrayList<>();
        Itinerary temp = new Itinerary();
        
        for(Flight f : flights) {
            if(f.getFrom().equals(from)) {
                temp = new Itinerary();
                temp.addFlight(f);
            } else if(f.getTo().equals(to)) {
                temp.addFlight(f);
                itineraries.add(temp);
            } else
                temp.addFlight(f);
        }
        return itineraries;
    }
    
//    private List<Flight> findPaths(String current, String dest, List<Flight> visited) {
//        if(current.equals(dest))
//            return visited;
//        
//        List<Flight> path = new ArrayList<>();
//        for(Flight f : allFlights) {
//            if(f.getFrom().equals(current) && !visited.contains(f)) {
//                //result = result + ...
//                List<Flight> newVisited = new ArrayList<>(visited);
//                newVisited.add(f);
//                List<Flight> tail = findPaths(f.getTo(), dest, newVisited);
//                path.addAll(tail);
//            }
//        }
//        return path;
//    }
    
    
//    
//    private List<Itinerary> findItiniraries(String from, String to, List<Flight> flights, List<Flight> flightsTaken, List<Itinerary> itineraries) {
//        Flight flight = flights.remove(0);
//        flightsTaken.add(flight);
//        
//        //If the current flight plan has reached the destination
//        if(flightsTaken.get(0).getFrom().equals(from) && flightsTaken.get(flightsTaken.size()-1).getTo().equals(to)) {
//            itineraries.add(new Itinerary(flightsTaken));
//            return itineraries;
//        }
//    }
}