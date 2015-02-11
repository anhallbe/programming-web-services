package hw3.bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Ticket {
	private int flightID;
	private boolean issued;
	private String creditCard;
	
	public Ticket() {
		
	}
	
	public Ticket(int flightID, boolean issued, String creditCard) {
		super();
		this.flightID = flightID;
		this.issued = issued;
		this.creditCard = creditCard;
	}

	public int getFlightID() {
		return flightID;
	}

	public void setFlightID(int flightID) {
		this.flightID = flightID;
	}

	public boolean isIssued() {
		return issued;
	}

	public void setIssued(boolean issued) {
		this.issued = issued;
	}

	public String getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}
}
