package pws.hw2.flight;


public class Flight {
    private String from;
    private String to;
    private int seats;
    private int price;
    private int flightID;

    public static final int MAX_SEATS = 100;
    public static final int MAX_PRICE = 1000;
    
    public Flight(String from, String to) {
        this.from = from;
        this.to = to;
        seats = MAX_SEATS;
        price = (int) (MAX_PRICE * Math.random());
        flightID = (int) (Integer.MAX_VALUE * Math.random());
    }
    
    /**
     * Try to book this flight. Returns true if there were available seats, otherwise false.
     * @return 
     */
    public boolean book() {
        if(seats > 0) {
            seats--;
            return true;
        } else
            return false;
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
    
    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
    
    public int getID() {
        return flightID;
    }
    
    public void setID(int flightID) {
        this.flightID = flightID;
    }
}
