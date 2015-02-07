/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pws.hw2.deploy;

import javax.xml.ws.Endpoint;
import pws.hw2.auth.CustomerAuthenticationService;
import pws.hw2.flightfinder.FlightFinder;
import pws.hw2.price.ItineraryPrice;
import pws.hw2.ticket.TicketAppraiser;

/**
 *
 * @author andreas
 */
public class ServiceDeployer {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/pws-hw2/FlightFinder", new FlightFinder());
        Endpoint.publish("http://localhost:8080/pws-hw2/CustomerAuthenticationService", new CustomerAuthenticationService());
        Endpoint.publish("http://localhost:8080/pws-hw2/TicketAppraiser", new TicketAppraiser());
        Endpoint.publish("http://localhost:8080/pws-hw2/ItineraryPrice", new ItineraryPrice());
    }
}
