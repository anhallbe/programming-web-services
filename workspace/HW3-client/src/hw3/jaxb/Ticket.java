//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.02.12 at 07:35:56 PM CET 
//


package hw3.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ticket complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ticket">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="creditCard" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="flightID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="issued" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ticket", propOrder = {
    "creditCard",
    "flightID",
    "issued"
})
public class Ticket {

    protected String creditCard;
    protected int flightID;
    protected boolean issued;

    /**
     * Gets the value of the creditCard property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreditCard() {
        return creditCard;
    }

    /**
     * Sets the value of the creditCard property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreditCard(String value) {
        this.creditCard = value;
    }

    /**
     * Gets the value of the flightID property.
     * 
     */
    public int getFlightID() {
        return flightID;
    }

    /**
     * Sets the value of the flightID property.
     * 
     */
    public void setFlightID(int value) {
        this.flightID = value;
    }

    /**
     * Gets the value of the issued property.
     * 
     */
    public boolean isIssued() {
        return issued;
    }

    /**
     * Sets the value of the issued property.
     * 
     */
    public void setIssued(boolean value) {
        this.issued = value;
    }

}
