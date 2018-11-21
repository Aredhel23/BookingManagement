package it.ariadne.BookingManagement;

import java.util.List;
import org.joda.time.DateTime;
import org.joda.time.Interval;

public interface Resource {
	/***
	 * it gets the list of the booking of the resource.
	 * @return the list of the booking of the resource.
	 */
	public List<Booking> getList();
	/***
	 * it gets the type of the resource.
	 * @return the type of the resource.
	 */
	public String getType();
	/***
	 * it gets the limit of the resource.
	 * @return gets the limit of the resource.
	 */
	public int getLimit();
	/***
	 * it prints the list of all the bookings of the resource. 
	 * @return the String of all the bookings of the resource. 
	 */
	public String bookingPrintList();
	
	public int setLimit(int lim);
}
