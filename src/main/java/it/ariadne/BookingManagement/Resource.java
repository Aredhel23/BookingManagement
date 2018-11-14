package it.ariadne.BookingManagement;

import java.util.List;
import org.joda.time.DateTime;
import org.joda.time.Interval;

public interface Resource {
	public List<Booking> getList();
	public String getType();
	public int getLimit();
	public String bookingPrintList();
	
}
