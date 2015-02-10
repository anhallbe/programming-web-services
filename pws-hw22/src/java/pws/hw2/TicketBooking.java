/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pws.hw2;

import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;

/**
 *
 * @author andreas
 */
@WebService(serviceName = "TicketBooking", portName = "TicketBookingPort", endpointInterface = "pws.hw2.TicketBooking", targetNamespace = "http://hw2.pws/", wsdlLocation = "WEB-INF/wsdl/TicketBooking/TicketBooking.wsdl")
public class TicketBooking {

    public java.util.List<pws.hw2.Ticket> ticketBooking(java.lang.String creditCard, pws.hw2.Itinerary itinerary) {
        List<pws.hw2.Ticket> tickets = new ArrayList<>();
        
        for(pws.hw2.Flight flight : itinerary.getFlights()) {
            pws.hw2.Ticket ticket = new pws.hw2.Ticket();
            ticket.setFlight(flight);
            if(flight.getSeats() > 1) {
                ticket.setBooked(true);
                flight.setSeats(flight.getSeats()-1);
            } else
                ticket.setBooked(false);
            tickets.add(ticket);
        }
        
        return tickets;
    }
    
}
