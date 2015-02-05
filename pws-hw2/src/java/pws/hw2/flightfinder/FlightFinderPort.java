/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pws.hw2.flightfinder;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

/**
 * REST Web Service
 *
 * @author andreas
 */
@Path("flightfinderport")
public class FlightFinderPort {
    private pws.hw2.flightfinder_client.FlightFinder port;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of FlightFinderPort
     */
    public FlightFinderPort() {
        port = getPort();
    }

    /**
     * Invokes the SOAP method possibleItineraries
     * @param departure resource URI parameter
     * @param destination resource URI parameter
     * @return an instance of javax.xml.bind.JAXBElement<pws.hw2.flightfinder_client.PossibleItinerariesResponse>
     */
    @GET
    @Produces("application/xml")
    @Consumes("text/plain")
    @Path("possibleitineraries/")
    public JAXBElement<pws.hw2.flightfinder_client.PossibleItinerariesResponse> getPossibleItineraries(@QueryParam("departure") String departure, @QueryParam("destination") String destination) {
        try {
            // Call Web Service Operation
            if (port != null) {
                java.util.List<pws.hw2.flightfinder_client.Itinerary> result = port.possibleItineraries(departure, destination);

                class PossibleItinerariesResponse_1 extends pws.hw2.flightfinder_client.PossibleItinerariesResponse {

                    PossibleItinerariesResponse_1(java.util.List<pws.hw2.flightfinder_client.Itinerary> _return) {
                        this._return = _return;
                    }
                }
                pws.hw2.flightfinder_client.PossibleItinerariesResponse response = new PossibleItinerariesResponse_1(result);
                return new pws.hw2.flightfinder_client.ObjectFactory().createPossibleItinerariesResponse(response);
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     *
     */
    private pws.hw2.flightfinder_client.FlightFinder getPort() {
        try {
            // Call Web Service Operation
            pws.hw2.flightfinder_client.FlightFinder_Service service = new pws.hw2.flightfinder_client.FlightFinder_Service();
            pws.hw2.flightfinder_client.FlightFinder p = service.getFlightFinderPort();
            return p;
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }
}
