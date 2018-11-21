package it.ariadne.BookingManagement.people;

import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Period;

import it.ariadne.BookingManagement.BookingsOrganizer;
import it.ariadne.BookingManagement.Person;
import it.ariadne.BookingManagement.Resource;
/***
 * Class thats represent a simple user of the program.
 * @author amato
 *
 */
public class User extends Person {
	/***
	 * User constructor:
	 * @param name
	 * @param surname
	 * @param email
	 * @param password
	 */
	public User(String name, String surname, String email, String password) {
		super(name, surname, email, password);
	}

	/***
	 * it adds a booking of a resource between two date.
	 * @param b organizer where are stored bookings and resources.
	 * @param r resource you want to book.
	 * @param name name of the booking.
	 * @param start start date.
	 * @param end end date.
	 * @return 0 if the booking is added, 1 if the booking is not added
	 */
	public int addBooking(BookingsOrganizer b, Resource r, String name, DateTime start, DateTime end) {
		return b.addBooking(this, r, name, start, end);
	}

	/***
	 * it deletes a booking of a resource.
	 * @param b organizer where are stored bookings and resources.
	 * @param r resource you want to delete booking.
	 * @param string name of the booking.
	 * @param start start date.
	 * @param end end date.
	 * @return  0 if the booking is deleted, 1 if the booking is not deleted
	 */
	public int deleteBooking(BookingsOrganizer b, Resource r, String string, DateTime start, DateTime end) {
		return b.deleteBooking(r, string, start, end);
	}

	/***
	 * it verifies the availability between two date-time. 
	 * @param b organizer where are stored bookings and resources.
	 * @param res resource you want to book.
	 * @param start1 start date.
	 * @param end1 end date.
	 * @return true if it is available, false if the resource is busy.
	 */
	public boolean bookingRequest(BookingsOrganizer b, Resource res, DateTime start1, DateTime end1) {
		return b.bookingRequest(res, start1, end1);
	}

	/***
	 * It finds the first dateTime when the resource is available for the selected period
	 * @param b organizer where are stored bookings and resources.
	 * @param res resource you want to book.
	 * @param p period you want to book.
	 * @return the first dateTime starting from the resource is available for the period selected.
	 */
	public DateTime firstAvailability(BookingsOrganizer b, Resource res, Period p) {
		return b.firstAvailability(res, p);
	}

	/***
	 * It finds the first dateTime when the resource is available for the selected period 
	 * between two date.
	 * @param b organizer where are stored bookings and resources.
	 * @param res resource you want to book.
	 * @param p period you want to book.
	 * @param start1 start date you check from.
	 * @param end1 max date you want.
	 * @return list with the start dateTime and the endTime.
	 */
	public List<DateTime> firstAvailability(BookingsOrganizer b, Resource res, Period p, DateTime start1, DateTime end1) {
		return b.firstAvailability(res, p, start1, end1);
	}

	/***
	 * It finds the first dateTime when the type resource with the limit selected is available
	 * @param b organizer where are stored bookings and resources.
	 * @param string type of resource you want to book.
	 * @param p period you want to book.
	 * @param limit under limit you want to be satisfied 
	 * @return list with the start dateTime and the endTime.
	 */
	public List<DateTime> firstAvailability(BookingsOrganizer b, String string, Period p, int limit) {
		
		return b.firstAvailability(string, p, limit);
	}

}
