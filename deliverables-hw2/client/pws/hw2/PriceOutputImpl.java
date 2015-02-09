
package pws.hw2;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "PriceOutputImpl", targetNamespace = "http://hw2.pws/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface PriceOutputImpl {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<java.lang.Integer>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "priceOutput", targetNamespace = "http://hw2.pws/", className = "pws.hw2.PriceOutput")
    @ResponseWrapper(localName = "priceOutputResponse", targetNamespace = "http://hw2.pws/", className = "pws.hw2.PriceOutputResponse")
    @Action(input = "http://hw2.pws/PriceOutputImpl/priceOutputRequest", output = "http://hw2.pws/PriceOutputImpl/priceOutputResponse")
    public List<Integer> priceOutput(
        @WebParam(name = "arg0", targetNamespace = "")
        List<Itinerary> arg0);

}
