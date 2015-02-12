package hw3.store;

import hw3.bean.Ticket;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class TicketStore {
	
	public static HashMap<Long, Ticket> tickets = new LinkedHashMap<Long, Ticket>();
	
//	public static void initStore() {
//		TicketStore.tickets = new LinkedHashMap<Integer, Ticket>();
//	}
}
