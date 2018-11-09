package it.ariadne.BookingManagement;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.joda.time.DateTime;

public class BookingsOrganizer {
	private Map<Resource, Booking> organizer= new LinkedHashMap<>();

	public Map<Resource, Booking> getOrganizer() {
		return organizer;
	}
	
	public boolean bookingRequest(Resource r, DateTime start, DateTime end) {
		Iterator it = organizer.entrySet().iterator();
		 while (it.hasNext()) {
			    Map.Entry entry = (Map.Entry)it.next();
			    if(entry.getKey().equals(r)) {
			    	Booking bookings = (Booking) entry.getValue();
			    	
			    }
		 }
		  
		return false;
	}

	
	
}

