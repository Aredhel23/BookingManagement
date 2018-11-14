package it.ariadne.BookingManagement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;

public abstract class Person {
	private String name;
	private String surname;
	private String email;
	private String password;
	public Person(String name, String surname, String email, String password) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
	}
	@Override
	public String toString() {
		String s = name + " " + surname + " " + email + ": ";
		return s;
	}
	
	public String myBookings(BookingsOrganizer ba) {
		String s = this.toString();
		Iterator it = ba.getOrganizer().entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry)it.next();
		    List<Booking> bookings = (List)entry.getValue();
		    for (Booking b:bookings) {
		    	if(b.getUser().equals(this)) {
		    		s = s + b.toString() + "\n";		    		
		    	}
		    }
		}
		return s;
	}
	public String myFutureBookings(BookingsOrganizer ba) {
		String s = this.toString();
		Iterator it = ba.getOrganizer().entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry)it.next();
		    List<Booking> bookings = (List)entry.getValue();
		    DateTime now = new DateTime();
		    for (Booking b:bookings) {
		    	if(b.getUser().equals(this) && b.getInterval().isAfter(now)) {
		    		s = s + b.toString() + "\n";		    		
		    	}
		    }
		}
		return s;
	}
	public String myPastBookings(BookingsOrganizer ba) {

		String s = this.toString();
		Iterator it = ba.getOrganizer().entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry)it.next();
		    List<Booking> bookings = (List)entry.getValue();
		    DateTime now = new DateTime();
		    for (Booking b:bookings) {
		    	if(b.getUser().equals(this) && b.getInterval().isBefore(now)) {
		    		s = s + b.toString() + "\n";		    		
		    	}
		    }
		}
		return s;
	}
	
}
