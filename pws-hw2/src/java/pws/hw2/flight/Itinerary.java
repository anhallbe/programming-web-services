package pws.hw2.flight;

import java.util.ArrayList;
import java.util.List;

public class Itinerary {
    private List<Flight> flights;

    public Itinerary(List<Flight> flights) {
        this.flights = flights;
    }
    
    public Itinerary() {
        flights = new ArrayList<>();
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }
    
    public void addFlight(Flight flight) {
        this.flights.add(flight);
    }
    
    /**
     * Get the total price of this itinerary.
     * @return 
     */
    public int getPrice() {
        int total = 0;
        for(Flight f : flights)
            total += f.getPrice();
        return total;
    }
}
