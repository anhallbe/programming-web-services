package pws.hw2;

import java.util.List;
import java.util.ArrayList;

public class PriceOutputImpl implements PriceOutput {

	@Override
	public List<Integer> priceOutput(List<Itinerary> itineraries) {
		List<Integer> result = new ArrayList<>();
		for(Itinerary i : itineraries)
            		for(Flight f : i.getFlights())
				result.add(f.getPrice());
		return result;
	}

}