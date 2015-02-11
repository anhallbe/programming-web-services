package hw3.bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Flight {
	private int id;
	private String from;
	private String to;
	private int seats;
	private int price;
	
	public Flight() {
		
	}

	public Flight(int id, String from, String to, int seats, int price) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.seats = seats;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
