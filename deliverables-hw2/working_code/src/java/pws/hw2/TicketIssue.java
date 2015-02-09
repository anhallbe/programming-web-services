/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pws.hw2;

import javax.jws.WebService;

/**
 *
 * @author andreas
 */
@WebService(serviceName = "TicketIssue", portName = "TicketIssuePort"/*, endpointInterface = "pws.hw2.TicketIssue", targetNamespace = "http://hw2.pws/", wsdlLocation = "WEB-INF/wsdl/TicketIssue/TicketIssue.wsdl"*/)
public class TicketIssue {

    public boolean ticketIssue(pws.hw2.Ticket ticket) {
        boolean success = false;
        
        if(ticket.isBooked())
            success = true;
        
        return success;
    }
    
}
