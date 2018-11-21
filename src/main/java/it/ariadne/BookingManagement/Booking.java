package it.ariadne.BookingManagement;

import org.joda.time.Interval;
import org.joda.time.ReadableInterval;
import org.joda.time.base.AbstractInterval;
/***
 * class that represent the single booking
 * @author amato
 *
 */
public class Booking {
	private Interval i;
	private String name;
	private Person u;

	/***
	 * Constructor of the booking.
	 * @param u person that makes the booking.
	 * @param name name of the booking.
	 * @param i interval where there is the booking.
	 */
	public Booking(Person u, String name, Interval i) {
		this.name = name;
		this.i = i;
		this.u = u;
	}
	
	/***
	 * Gets the Person that makes the booking.
	 * @return the Person that makes the booking.
	 */
	public Person getUser() {
		return u;
	}

	/***
	 * It gets the interval where there is the booking.
	 * @return the interval where there is the booking.
	 */
	ReadableInterval getInterval() {
		return i;
	}

	/***
	 * It gets the interval where there is the booking.
	 * @return the interval where there is the booking.
	 */
	public Interval getI() {
		return i;
	}

	/***
	 * It gets the name of the booking.
	 * @return the name of the booking.
	 */
	public String getName() {
		return name;
	}



	@Override
	public String toString() {
		return "Prenotazione [data=" + i + ", nome=" + name + ", utente=" + u + "]";
	}
	
	

}
