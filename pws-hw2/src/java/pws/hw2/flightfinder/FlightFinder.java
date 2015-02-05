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
    
    List<Flight> allFlights;
    
    public FlightFinder() {
        allFlights = new ArrayList<>();
        
        allFlights.add(new Flight("Stockholm", "Oslo"));
        allFlights.add(new Flight("Oslo", "Stockholm"));
        allFlights.add(new Flight("Stockholm", "Munich"));
        allFlights.add(new Flight("Munich", "Stockholm"));
        allFlights.add(new Flight("Oslo", "Paris"));
        allFlights.add(new Flight("Paris", "Oslo"));
        allFlights.add(new Flight("Stockholm", "Berlin"));
        allFlights.add(new Flight("Berlin", "Stockholm"));
        allFlights.add(new Flight("Berlin", "London"));
        allFlights.add(new Flight("London", "Berlin"));
        allFlights.add(new Flight("Berlin", "Paris"));
        allFlights.add(new Flight("Paris", "Berlin"));
        allFlights.add(new Flight("London", "New York"));
        allFlights.add(new Flight("New York", "London"));
        allFlights.add(new Flight("Miami", "Munich"));
        allFlights.add(new Flight("Munich", "Miami"));
        allFlights.add(new Flight("Miami", "Austin"));
        allFlights.add(new Flight("Austin", "Miami"));
        allFlights.add(new Flight("Austin", "Las Vegas"));
        allFlights.add(new Flight("Las Vegas", "Austin"));
        allFlights.add(new Flight("Las Vegas", "San Fransisco"));
        allFlights.add(new Flight("San Fransisco", "Las Vegas"));
        allFlights.add(new Flight("San Fransisco", "Denver"));
        allFlights.add(new Flight("Denver", "San Fransisco"));
        allFlights.add(new Flight("Denver", "Los Angeles"));
        allFlights.add(new Flight("Los Angeles", "Denver"));
        allFlights.add(new Flight("Los Angeles", "New York"));
        allFlights.add(new Flight("New York", "Los Angeles"));
        allFlights.add(new Flight("New York", "Madrid"));
        allFlights.add(new Flight("Madrid", "New York"));
        allFlights.add(new Flight("Los Angeles", "Tokyo"));
        allFlights.add(new Flight("Tokyo", "Los Angeles"));
        allFlights.add(new Flight("Tokyo", "Stockholm"));
        allFlights.add(new Flight("Stockholm", "Tokyo"));
        
        
        allFlights.add(new Flight("Stockholm", "Oslo"));
        allFlights.add(new Flight("Oslo", "Stockholm"));
    }

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "possibleItineraries")
    public List<Itinerary> possibleItineraries(@WebParam(name = "departure") String departure, @WebParam(name = "destination") String destination) {
        List<Itinerary> itineraries = new ArrayList<>();
        
        List<Flight> flights = new ArrayList<>();
        for(Flight f : allFlights)
            if(f.getFrom().equals(departure) && f.getTo().equals(destination))
                flights.add(f);
        itineraries.add(new Itinerary(flights));
        return itineraries;
    }
    
    private List<Flight> findItinirary(String from, String to, List<Flight> flights, List<Flight> flightsTaken) {
//        List<Flight> temp = new ArrayList<>();
        for(int i=0; i<flights.size(); i++) {
            Flight f = flights.get(i);
            
            if(flightsTaken.contains(f))
                return flightsTaken;
            
            if(f.getFrom().equals(from) && f.getTo().equals(to)) {
//                temp.add(f);
                flightsTaken.add(f);
                
            }
            
            if(f.getTo().equals(to)) {
                flightsTaken.add(f);
                return flightsTaken;
            }
        }
    }
}

//            if(!flightsTaken.contains(f)) {
//                if(f.getFrom().equals(from) && f.getTo().equals(to)) {
//                    flightsTaken.add(f);
//                }
//                if(f.getFrom().equals(from)) {
//
//                }
//            }