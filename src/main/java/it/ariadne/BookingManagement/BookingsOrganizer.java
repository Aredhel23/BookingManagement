package it.ariadne.BookingManagement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.joda.time.Interval;

public class BookingsOrganizer {
	private Map<Resource, List> organizer= new LinkedHashMap<>();
	
	
	public BookingsOrganizer(Resource r) {
		organizer.put(r, r.getList());
	}

	public Map<Resource, List> getOrganizer() {		
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

