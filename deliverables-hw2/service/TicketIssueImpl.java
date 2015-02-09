package pws.hw2;

import java.util.List;
import java.util.ArrayList;
import javax.jws.WebService;

@WebService()
public class TicketIssueImpl implements TicketIssue {

    public boolean ticketIssue(Ticket ticket) {
        boolean success = false;
        
        if(ticket.isBooked())
            success = true;
        
        return success;
    }
    
}
