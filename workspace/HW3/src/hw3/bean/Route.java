package hw3.bean;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Route {
	private List<Flight> flights;

	public Route() {
		
	}
	
	public Route(List<Flight> flights) {
		super();
		this.flights = flights;
	}

	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}
}
