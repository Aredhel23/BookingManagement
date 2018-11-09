package it.ariadne.BookingManagement;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.junit.Test;

import it.ariadne.BookingManagement.resorces.Projector;

public class TestBooking {
	@Test
	public void testBookingRequest() {
		
		List<Booking> l = new ArrayList<>();
		Resource res = new Projector(l);
		DateTime start = new DateTime(2004, 12, 25, 0, 0, 0, 0);
		DateTime end = new DateTime(2005, 1, 1, 0, 0, 0, 0);		
		Interval interval = new Interval(start, end);
		Booking b = new Booking("a", interval);
		l.add(b);
		DateTime start1 = new DateTime(2004, 12, 31, 0, 0, 0, 0);
		DateTime end1 = new DateTime(2005, 1, 1, 0, 0, 0, 0);
		boolean bookingreq = res.bookingRequest(start1, end1);
		DateTime start2 = new DateTime(2014, 12, 26, 0, 0, 0, 0);
		DateTime end2 = new DateTime(2015, 1, 1, 0, 0, 0, 0);
		Resource res1 = new Projector(l);
		boolean bookingreq1 = res1.bookingRequest(start2, end2);
		// Assert first
		assertEquals("Se una risorsa è occupata la richiesta torna falso", false, bookingreq);
		assertEquals("Se una risorsa è libera la richiesta torna vero", true, bookingreq1);
	}
}
