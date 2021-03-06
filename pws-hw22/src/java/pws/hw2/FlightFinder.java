/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pws.hw2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author andreas
 */
@WebService(serviceName = "FlightFinder", 
        portName = "FlightFinderPort")
public class FlightFinder {
    
    private List<Flight> allFlights;
    
    
    public FlightFinder() {
        
    }
    /**
     * 
     * @return itineraries
     */
    @WebMethod(operationName = "possibleItineraries")
    public List<Itinerary> possibleItineraries(@WebParam(name = "departure") String departure, @WebParam(name = "destination") String destination) {
        System.out.println("possibleItineraries(" + departure + ", " + destination + ") called.");
        initFlights();
        List<Flight> fl = new ArrayList<>();
        fl.addAll(findPaths(departure, destination));
        List<Itinerary> result = structurePaths(fl, departure, destination);
        
        return result;
    }
    
    private List<Flight> findPaths(String from, String to) {
        return findPaths(from, to, new ArrayList<>(), new ArrayList<>());
    }
    
    private List<Flight> findPaths(String current, String dest, List<Flight> flightsTaken, List<String> visitedCities) {
        if(current.equals(dest))
            return flightsTaken;
        
        List<Flight> path = new ArrayList<>();
        for(Flight f : allFlights) {
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
    
    private List<Itinerary> structurePaths(List<Flight> flights, String from, String to) {
        List<Itinerary> itineraries = new ArrayList<>();
        Itinerary temp = new Itinerary();
        
        for(Flight f : flights) {
            if(f.getFrom().equals(from))
                temp = new Itinerary();
//            temp.addFlight(f);
            temp.getFlights().add(f);
            if(f.getTo().equals(to))
                itineraries.add(temp);
        }
        return itineraries;
    }
    
    private void addFlight(String from, String to) {
        Random rand = new Random();
        Flight f = new Flight();
        f.setFrom(from);
        f.setTo(to);
        f.setID(rand.nextInt(100));
        f.setPrice(rand.nextInt(100));
        f.setSeats(rand.nextInt(100));
        allFlights.add(f);
    }
    
    private void initFlights() {
        allFlights = new ArrayList<>();
        addFlight("Oslo", "Stockholm");
        addFlight("Stockholm", "Oslo");
        addFlight("Oslo", "Stockholm");
        addFlight("Stockholm", "Munich");
        addFlight("Munich", "Stockholm");
        addFlight("Oslo", "Paris");
        addFlight("Paris", "Oslo");
        addFlight("Stockholm", "Berlin");
        addFlight("Berlin", "Stockholm");
        addFlight("Berlin", "London");
        addFlight("London", "Berlin");
        addFlight("Berlin", "Paris");
        addFlight("Paris", "Berlin");
        addFlight("London", "New York");
        addFlight("New York", "London");
        addFlight("Miami", "Munich");
        addFlight("Munich", "Miami");
        addFlight("Miami", "Austin");
        addFlight("Austin", "Miami");
        addFlight("Austin", "Las Vegas");
        addFlight("Las Vegas", "Austin");
        addFlight("Las Vegas", "San Fransisco");
        addFlight("San Fransisco", "Las Vegas");
        addFlight("San Fransisco", "Denver");
        addFlight("Denver", "San Fransisco");
        addFlight("Denver", "Los Angeles");
        addFlight("Los Angeles", "Denver");
        addFlight("Los Angeles", "New York");
        addFlight("New York", "Los Angeles");
        addFlight("New York", "Madrid");
        addFlight("Madrid", "New York");
        addFlight("Los Angeles", "Tokyo");
        addFlight("Tokyo", "Los Angeles");
        addFlight("Tokyo", "Stockholm");
        addFlight("Stockholm", "Tokyo");
    }
}




//        for(Flight f : flights) {
//            if(f.getFrom().equals(from)) {
//                temp = new Itinerary();
//                temp.addFlight(f);
//            } else if(f.getTo().equals(to)) {
//                temp.addFlight(f);
//                itineraries.add(temp);
//            } else
//                temp.addFlight(f);
//        }
        