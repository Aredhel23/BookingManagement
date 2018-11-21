package it.ariadne.BookingManagement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.joda.time.Period;
import it.ariadne.BookingManagement.people.User;
/***
 * Class where are stored all the bookings for each resource.
 * @author amato
 *
 */
public class BookingsOrganizer {
	private Map<Resource, List> organizer= new LinkedHashMap<>();
	/***
	 * Constructor of a Booking Organizer
	 */
	public BookingsOrganizer() {
		
	}
	/***
	 * it gets the map of the entire booking organizer.
	 * @return the map of the entire booking organizer.
	 */
	public Map<Resource, List> getOrganizer() {		
		return organizer;
	}
	/***
	 * It finds the first dateTime when the resource is available for the selected period
	 * @param r resource you want to book.
	 * @param start start date.
	 * @param end end date.
	 * @return true if it is available, false if the resource is busy.
	 */
	public boolean bookingRequest(Resource r, DateTime start, DateTime end) {

		List<Booking> bookings = organizer.get(r);
		Interval interval = new Interval(start, end);
		for (Booking i:bookings) {
			if(i.getInterval().overlaps(interval)) {
				return false;
			}
		}
		return true;		 
	}
	
	/***
	 * it adds a booking of a resource between two date.
	 * @param u user that makes the booking.
	 * @param r resource you want to book.
	 * @param name name of the booking.
	 * @param start start date.
	 * @param end end date.
	 * @return  0 if the booking is added, 1 if the booking is not added.
	 */
	public int addBooking(Person u, Resource r, String name, DateTime start, DateTime end) {
		
    	List<Booking> bookings = organizer.get(r);
		if(bookingRequest(r, start, end)) {
			Interval interval = new Interval(start, end);
			Booking p = new Booking(u, name, interval);
			bookings.add(p);
			return 0;
		}
		else 
			return 1;
	}
	
	/***
	 * it deletes a booking of a resource.
	 * @param r resource you want to delete booking.
	 * @param string name of the booking.
	 * @param start start date.
	 * @param end end date.
	 * @return  0 if the booking is deleted, 1 if the booking is not deleted
	 */
	public int deleteBooking(Resource r, String name, DateTime start, DateTime end) {	
		
    	List<Booking> bookings = organizer.get(r);
		for (Booking b:bookings) {
			if(b.getName().equals(name))
				if(b.getI().getStart().equals(start) && b.getI().getEnd().equals(end)) {
					bookings.remove(b);
					return 0;
				}
		}
		return 1;
	}
	
	/***
	 * It finds the first dateTime when the resource is available for the selected period.
	 * @param res resource you want to book.
	 * @param p period you want to book.
	 * @return the first dateTime starting from the resource is available for the period selected.
	 */
	public DateTime firstAvailability(Resource r, Period p) {
    	boolean ret = true;
    	DateTime start = new DateTime();
    	Period defPeriod = new Period().withHours(1);
    	while(ret) {
    		DateTime end = start.plus(p); 
    		if (bookingRequest(r, start, end))
    			return start;
    		else {
	    		ret = !bookingRequest(r, start, end);
	    		start = start.plus(defPeriod);
    		}
    		
    	}
		return null;
	}
	
	/***
	 * It finds the first dateTime when the resource is available for the selected period 
	 * between two date.
	 * @param res resource you want to book.
	 * @param p period you want to book.
	 * @param start1 start date you check from.
	 * @param end1 max date you want.
	 * @return list with the start dateTime and the endTime.
	 */
	public List<DateTime> firstAvailability(Resource r, Period p, DateTime start, DateTime end) {
		List<DateTime> dates = new ArrayList<>();
    	boolean ret = true;
    	Period defPeriod = new Period().withHours(1);
    	DateTime start1 = start;
    	while(ret) {
    		DateTime end1 = start1.plus(p); 
    		if (end1.isBefore(end)) {
	    		if (bookingRequest(r, start1, end1)) {
	    			dates.add(start1);
	    			dates.add(end1);
	    			return dates;
	    		}
	    		ret = !bookingRequest(r, start1, end1);
	    		start1 = start1.plus(defPeriod);
    		}
    		else {
    			break;
    		}
    		
    	}
			    
			    
		 
		return  Collections.emptyList();
	}
	
	/***
	 * It finds the first dateTime when the type resource with the limit selected is available
	 * @param string type of resource you want to book.
	 * @param p period you want to book.
	 * @param limit under limit you want to be satisfied 
	 * @return list with the start dateTime and the endTime.
	 */
	public List<DateTime> firstAvailability(String string, Period p, int limit) {
		Iterator it = organizer.entrySet().iterator();
		List<DateTime> dates = new ArrayList<>();
		 while (it.hasNext()) {
			    Map.Entry entry = (Map.Entry)it.next();
			    Resource r = ((Resource) entry.getKey());
			    if((r.getType()).equals(string) && r.getLimit() >= limit) {
			    	DateTime start = firstAvailability((Resource)entry.getKey(), p);
			    	DateTime end = start.plus(p);
		    		dates.add(start);
		    		dates.add(end);
			    	return dates;	
			    	}
			    }		 
		return  Collections.emptyList();
	}


	
}


