package it.ariadne.BookingManagement.people;

import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Period;

import it.ariadne.BookingManagement.BookingsOrganizer;
import it.ariadne.BookingManagement.Person;
import it.ariadne.BookingManagement.Resource;

public class User extends Person {

	public User(String name, String surname, String email, String password) {
		super(name, surname, email, password);
	}


	public int addBooking(BookingsOrganizer b, Resource r, String name, DateTime start, DateTime end) {
		return b.addBooking(r, name, start, end);
	}


	public int deleteBooking(BookingsOrganizer b, Resource r, String string, DateTime start, DateTime end) {
		return b.deleteBooking(r, string, start, end);
	}


	public boolean bookingRequest(BookingsOrganizer b, Resource res, DateTime start1, DateTime end1) {
		return b.bookingRequest(res, start1, end1);
	}


	public DateTime firstAvailability(BookingsOrganizer b, Resource res, Period p) {
		return b.firstAvailability(res, p);
	}


	public List<DateTime> firstAvailability(BookingsOrganizer b, Resource res, Period p, DateTime start1, DateTime end1) {
		return b.firstAvailability(res, p, start1, end1);
	}


	public List<DateTime> firstAvailability(BookingsOrganizer b, String string, Period p, int limit) {
		
		return b.firstAvailability(string, p, limit);
	}

}
