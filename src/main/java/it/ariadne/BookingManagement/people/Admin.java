package it.ariadne.BookingManagement.people;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;

import it.ariadne.BookingManagement.BookingsOrganizer;
import it.ariadne.BookingManagement.Person;
import it.ariadne.BookingManagement.Resource;

public class Admin extends Person {

	public Admin(String name, String surname, String email, String password) {
		super(name, surname, email, password);
	}

	public String userBookings(BookingsOrganizer ba, List<User> users) {
		String s = "";
		for (User us: users) {
			s = s + us.myBookings(ba);
		}
		return s;
	}

	public String resourceBookings(BookingsOrganizer ba) {
		Iterator it = ba.getOrganizer().entrySet().iterator();
		String s ="";
		 while (it.hasNext()) {
			    Map.Entry entry = (Map.Entry)it.next();
			    Resource r = (Resource)entry.getKey();
			    s = s + r.bookingPrintList();
		 }
		return s;
	}
	
	

}
