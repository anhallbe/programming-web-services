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
@WebService(serviceName = "PriceOutput", portName = "PriceOutputPort", endpointInterface = "pws.hw2.PriceOutput", targetNamespace = "http://hw2.pws/", wsdlLocation = "WEB-INF/wsdl/PriceOutput/PriceOutput.wsdl")
public class PriceOutput {

    public java.util.List<java.lang.Integer> priceOutput(java.util.List<pws.hw2.Itinerary> availableItinerary) {
        List<Integer> result = new ArrayList<>();
        for(Itinerary i : availableItinerary)
            result.add(i.getPrice());
        
        return result;
    }
    
}
