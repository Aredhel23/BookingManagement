package it.ariadne.BookingManagement.people;

import java.util.List;

import it.ariadne.BookingManagement.BookingsOrganizer;
import it.ariadne.BookingManagement.Person;

public class Admin extends Person {

	public Admin(String name, String surname, String email, String password) {
		super(name, surname, email, password);
	}

	public Object userBookings(BookingsOrganizer ba, List<User> users) {
		String s = "";
		for (User us: users) {
			s = s + us.myBookings(ba);
		}
		return s;
	}

}
