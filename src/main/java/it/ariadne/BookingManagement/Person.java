package it.ariadne.BookingManagement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
/***
 * Abstract Class that picks general attributes of a real person.
 * @author amato
 *
 */
public abstract class Person {
	private String name;
	private String surname;
	private String email;
	private String password;
	/***
	 * Person constructor.
	 * @param name
	 * @param surname
	 * @param email
	 * @param password
	 */
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
	
	/***
	 * method to print the list of the booking of a Person.
	 * 
	 * @param ba: an instance of the booking organizer where are the bookings. 
	 * @return the String listing of all the bookings of the Person.
	 */
	public String myBookings(BookingsOrganizer ba) {
		String s = this.toString() + "\n";
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
	/***
	 * method to generate the string containing the bookings done for the future.
	 * @param ba: an instance of the booking organizer where are the bookings.
	 * @return The String listing of all the future bookings of the Person.
	 */
	public String myFutureBookings(BookingsOrganizer ba) {
		String s = this.toString() + "\n";
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
	
	/***
	 * method to generate the string containing the bookings done in the past.
	 * @param ba: an instance of the booking organizer where are the bookings.
	 * @return The String listing of all the past bookings of the Person.
	 */
	public String myPastBookings(BookingsOrganizer ba) {

		String s = this.toString() + "\n";
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
