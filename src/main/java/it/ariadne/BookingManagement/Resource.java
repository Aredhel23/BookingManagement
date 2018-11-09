package it.ariadne.BookingManagement;

import java.util.List;
import org.joda.time.DateTime;
import org.joda.time.Interval;

public interface Resource {
	 static boolean bookingRequest(List<Booking> list, DateTime start, DateTime end) {
		Interval interval = new Interval(start, end);
		for (Booking i:list) {
			if(i.getInterval().overlaps(interval)) {
				return false;
			}
		}
		return true;
		
	}

	boolean bookingRequest(DateTime start1, DateTime end1);;
	public List<Booking> getList();
	int addBooking(String name, DateTime start, DateTime end);
	int deleteBooking(String string, DateTime start, DateTime end);
}
