package it.ariadne.BookingManagement;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import it.ariadne.BookingManagement.resorces.Projector;

public class TestBooking {
	@Test
	public void testBookingRequest() {
		// Assert first
		Resource res = new Projector();
		boolean bookingreq = res.bookingRequest();
		Resource res1 = new Projector();
		boolean bookingreq1 = res1.bookingRequest();
		assertEquals("Se una risorsa è occupata la richiesta torna falso", false, bookingreq);
		assertEquals("Se una risorsa è libera la richiesta torna vero", true, bookingreq1);
	}
}
