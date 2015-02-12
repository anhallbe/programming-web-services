package hw3.store;

import hw3.bean.Flight;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Random;

public class FlightStore {
	public static HashMap<Integer, Flight> flights = null;
	
	public static void initStore() {
		FlightStore.flights = new LinkedHashMap<Integer, Flight>();
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
	
	private static void addFlight(String from, String to) {
		Random rand = new Random();
		int id = rand.nextInt(100000);
		int seats = rand.nextInt(300);
		int price = rand.nextInt(2000);
		FlightStore.flights.put(id, new Flight(id, from, to, seats, price));
	}
}