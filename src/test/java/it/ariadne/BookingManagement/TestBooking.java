package it.ariadne.BookingManagement;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.joda.time.Period;
import org.junit.Test;

import it.ariadne.BookingManagement.people.User;
import it.ariadne.BookingManagement.resorces.Projector;

public class TestBooking {
	@Test
	public void testBookingRequest() {
		List<Booking> l = new ArrayList<>();
		int colors = 256;
		Resource res = new Projector(l, colors);
		BookingsOrganizer ba = new BookingsOrganizer(res);
		DateTime start = new DateTime(2004, 12, 25, 0, 0, 0, 0);
		DateTime end = new DateTime(2005, 1, 1, 0, 0, 0, 0);		
		Interval interval = new Interval(start, end);
		Booking b = new Booking(null, "a", interval);
		l.add(b);
		DateTime start1 = new DateTime(2004, 12, 31, 0, 0, 0, 0);
		DateTime end1 = new DateTime(2005, 1, 1, 0, 0, 0, 0);
		boolean bookingreq = ba.bookingRequest(res, start1, end1);
		DateTime start2 = new DateTime(2014, 12, 26, 0, 0, 0, 0);
		DateTime end2 = new DateTime(2015, 1, 1, 0, 0, 0, 0);
		boolean bookingreq1 = ba.bookingRequest(res, start2, end2);
		// Assert first
		System.out.println(ba.getOrganizer());
		assertEquals("Se una risorsa è occupata la richiesta torna falso", false, bookingreq);
		//assertEquals("Se una risorsa è libera la richiesta torna vero", true, bookingreq1);
	}
	
	@Test
	public void testBooked() {
		List<Booking> l = new ArrayList<>();
		int colors = 256;
		Resource res = new Projector(l, colors);
		BookingsOrganizer ba = new BookingsOrganizer(res);
		DateTime start = new DateTime(2004, 12, 25, 0, 0, 0, 0);
		DateTime end = new DateTime(2005, 1, 1, 0, 0, 0, 0);
		int a1 = ba.addBooking(null, res, "a", start, end);
		int a2 = ba.addBooking(null, res, "b", start, end);		
		assertEquals("Se una prenotazione della risorsa è aggiunta il metodo ritorna 0", 0, a1);
		assertEquals("Se una prenotazione della risorsa non è aggiunta il metodo ritorna 1", 1, a2);
		
	}
	
	@Test
	public void testDeleteBooked() {
		List<Booking> l = new ArrayList<>();
		int colors = 256;
		Resource res = new Projector(l, colors);
		BookingsOrganizer ba = new BookingsOrganizer(res);
		DateTime start = new DateTime(2004, 12, 25, 0, 0, 0, 0);
		DateTime end = new DateTime(2005, 1, 1, 0, 0, 0, 0);
		int a1 = ba.addBooking(null, res, "a", start, end);
		int a3 = ba.deleteBooking(res, "a", start, end);
		int a2 = ba.deleteBooking(res, "b", start, end);	
		assertEquals("Se una prenotazione della risorsa è cancellata il metodo ritorna 0", 0, a3);
		assertEquals("Se una prenotazione della risorsa non è cancellata il metodo ritorna 1", 1, a2);
	}
	
	@Test
	public void testFirstAvailability() {
		List<Booking> l = new ArrayList<>();
		int colors = 256;
		Resource res = new Projector(l, colors);
		BookingsOrganizer ba = new BookingsOrganizer(res);
		Period p = new Period().withHours(3);
		DateTime book1 = ba.firstAvailability(res, p);
		DateTime end = book1.withPeriodAdded(p, 1);
		ba.addBooking(null, res, "a", book1, end);
		DateTime book2 =  ba.firstAvailability(res, p);
		DateTime d = new DateTime();
		end = book2.withPeriodAdded(p, 1);
		ba.addBooking(null, res, "b", book2, end);
		DateTime start1 = new DateTime(2018, 1, 1, 1, 0, 0, 0);
		DateTime end1 = new DateTime(2018, 1, 1, 5, 0, 0, 0); 
		List<DateTime> book3 = ba.firstAvailability(res, p, start1, end1);
		if(!book3.isEmpty())
			ba.addBooking(null, res, "b", book3.get(0), book3.get(1));
		List<DateTime> book4 = ba.firstAvailability(res, p, start1, end1);
		assertEquals("Se una prenotazione di 3 ore a partire dal presente è possibile torna il"
				+ "datetime di quando inizia(dateTime corrente)", d.getHourOfDay(), book1.getHourOfDay());
		assertEquals("Se ho appena fatto una prenotazione di 3 ore a partire dal presente allora"
				+ "quella dopo parte 3 ore dopo", d.plus(p).getHourOfDay(), book2.getHourOfDay());
		
		assertEquals("Se una prenotazione di 3 ore a partire da start1 fino a end1 è possibile torna il"
				+ "datetime di quando inizia", start1.getHourOfDay(), book3.get(0).getHourOfDay());
		assertEquals("Se non si può fare la prenotazione la lista di inizio e fineè vuota"
				+ "null",true, book4.isEmpty());
		
	}
	@Test
	public void testFirstAvailabilityLimit() {
		List<Booking> l = new ArrayList<>();
		int colors = 256;
		Resource res = new Projector(l, colors);
		BookingsOrganizer ba = new BookingsOrganizer(res);
		Period p = new Period().withHours(3);
		List<DateTime> book1 = ba.firstAvailability("Projector", p, 256);
		DateTime start = book1.get(0);
		DateTime end = book1.get(1);
		DateTime d = new DateTime();
		List<DateTime> book2 = ba.firstAvailability("Projector", p, 512);
		assertEquals("Se una prenotazione di 3 ore a partire dal presente con il limite a 256 è possibile torna il"
				+ "datetime di quando inizia(dateTime corrente)", d.getHourOfDay(), book1.get(0).getHourOfDay());
		assertEquals("Se una prenotazione di 3 ore a partire dal presente con il limite a 256 non  è possibile torna il\"\r\n" + 
				"				+ una lista vuota", Collections.emptyList(), book2);
	}
	
	@Test
	public void TestUserAddBooking(){
		List<Booking> l = new ArrayList<>();
		int colors = 256;
		Resource res = new Projector(l, colors);
		BookingsOrganizer ba = new BookingsOrganizer(res);
		Person person = new User("Federica", "Bianchi", "abc@abc.it", "123");
		DateTime start = new DateTime(2004, 12, 25, 0, 0, 0, 0);
		DateTime end = new DateTime(2005, 1, 1, 0, 0, 0, 0);
		int a1 = ((User)person).addBooking(ba, res, "a", start, end);
		int a2 = ((User)person).addBooking(ba, res, "b", start, end);		
		assertEquals("Se una persona fa una prenotazione della risorsa e questa è aggiunta il metodo ritorna 0", 0, a1);
		assertEquals("Se una prenotazione della risorsa non è aggiunta il metodo ritorna 1", 1, a2);
	}
	
	@Test
	public void TestUserDeleteBooking(){
		List<Booking> l = new ArrayList<>();
		int colors = 256;
		Resource res = new Projector(l, colors);
		BookingsOrganizer ba = new BookingsOrganizer(res);
		Person person = new User("Federica", "Bianchi", "abc@abc.it", "123");
		DateTime start = new DateTime(2004, 12, 25, 0, 0, 0, 0);
		DateTime end = new DateTime(2005, 1, 1, 0, 0, 0, 0);
		int a1 = ((User)person).addBooking(ba, res, "a", start, end);
		int a3 = ((User)person).deleteBooking(ba, res, "a", start, end);
		int a2 = ((User)person).deleteBooking(ba, res, "b", start, end);	
		assertEquals("Se una prenotazione della risorsa è cancellata il metodo ritorna 0", 0, a3);
		assertEquals("Se una prenotazione della risorsa non è cancellata il metodo ritorna 1", 1, a2);
	}
	
	@Test
	public void testUserBookingRequest() {
		List<Booking> l = new ArrayList<>();
		int colors = 256;
		Person person = new User("Federica", "Bianchi", "abc@abc.it", "123");
		Resource res = new Projector(l, colors);
		BookingsOrganizer ba = new BookingsOrganizer(res);
		DateTime start = new DateTime(2004, 12, 25, 0, 0, 0, 0);
		DateTime end = new DateTime(2005, 1, 1, 0, 0, 0, 0);		
		Interval interval = new Interval(start, end);
		Booking b = new Booking((User)person, "a", interval);
		l.add(b);
		DateTime start1 = new DateTime(2004, 12, 31, 0, 0, 0, 0);
		DateTime end1 = new DateTime(2005, 1, 1, 0, 0, 0, 0);
		boolean bookingreq = ((User)person).bookingRequest(ba, res, start1, end1);
		DateTime start2 = new DateTime(2014, 12, 26, 0, 0, 0, 0);
		DateTime end2 = new DateTime(2015, 1, 1, 0, 0, 0, 0);
		boolean bookingreq1 = ((User)person).bookingRequest(ba, res, start2, end2);
		// Assert first
		assertEquals("Se una risorsa richiesta dall'utente è occupata la richiesta torna falso", false, bookingreq);
		assertEquals("Se una risorsa richiesta dall'utente è libera la richiesta torna vero", true, bookingreq1);
	}
	@Test
	public void testUserFirstAvailability() {
		List<Booking> l = new ArrayList<>();
		Person person = new User("Federica", "Bianchi", "abc@abc.it", "123");
		int colors = 256;
		Resource res = new Projector(l, colors);
		BookingsOrganizer ba = new BookingsOrganizer(res);
		Period p = new Period().withHours(3);
		DateTime book1 = ((User)person).firstAvailability(ba, res, p);
		DateTime end = book1.withPeriodAdded(p, 1);
		((User)person).addBooking(ba, res, "a", book1, end);
		DateTime book2 =  ba.firstAvailability(res, p);
		DateTime d = new DateTime();
		end = book2.withPeriodAdded(p, 1);
		((User)person).addBooking(ba, res, "b", book2, end);
		DateTime start1 = new DateTime(2018, 1, 1, 1, 0, 0, 0);
		DateTime end1 = new DateTime(2018, 1, 1, 5, 0, 0, 0); 
		List<DateTime> book3 = ((User)person).firstAvailability(ba, res, p, start1, end1);
		if(!book3.isEmpty())
			((User)person).addBooking(ba, res, "b", book3.get(0), book3.get(1));
		List<DateTime> book4 = ((User)person).firstAvailability(ba, res, p, start1, end1);
		assertEquals("Se una prenotazione di 3 ore a partire dal presente è possibile torna il"
				+ "datetime di quando inizia(dateTime corrente)", d.getHourOfDay(), book1.getHourOfDay());
		assertEquals("Se ho appena fatto una prenotazione di 3 ore a partire dal presente allora"
				+ "quella dopo parte 3 ore dopo", d.plus(p).getHourOfDay(), book2.getHourOfDay());
		
		assertEquals("Se l'utente può fare una prenotazione di 3 ore a partire da start1 fino a end1 è possibile torna il"
				+ "datetime di quando inizia", start1.getHourOfDay(), book3.get(0).getHourOfDay());
		assertEquals("Se l'utente non può fare la prenotazione la lista di inizio e fineè vuota"
				+ "null",true, book4.isEmpty());
		
	}
	
	@Test
	public void testUserFirstAvailabilityLimit() {
		List<Booking> l = new ArrayList<>();
		Person person = new User("Federica", "Bianchi", "abc@abc.it", "123");
		int colors = 256;
		Resource res = new Projector(l, colors);
		BookingsOrganizer ba = new BookingsOrganizer(res);
		Period p = new Period().withHours(3);
		List<DateTime> book1 = ((User)person).firstAvailability(ba, "Projector", p, 256);
		DateTime start = book1.get(0);
		DateTime end = book1.get(1);
		DateTime d = new DateTime();
		List<DateTime> book2 = ((User)person).firstAvailability(ba, "Projector", p, 512);
		assertEquals("Se una prenotazione di 3 ore a partire dal presente con il limite a 256 è possibile torna il"
				+ "datetime di quando inizia(dateTime corrente)", d.getHourOfDay(), book1.get(0).getHourOfDay());
		assertEquals("Se una prenotazione di 3 ore a partire dal presente con il limite a 256 non  è possibile torna il\"\r\n" + 
				"				+ una lista vuota", Collections.emptyList(), book2);
	}
	
	@Test
	public void testUserMyBookings() {
		List<Booking> l = new ArrayList<>();
		int colors = 256;
		Person person = new User("Federica", "Bianchi", "abc@abc.it", "123");
		Person person1 = new User("Federica", "Rossi", "abc@abc.it", "123");
		Resource res = new Projector(l, colors);
		BookingsOrganizer ba = new BookingsOrganizer(res);
		assertEquals("Se non ha mai fatto prenotazioni stampa dati utente: ", 
				"Federica Bianchi abc@abc.it: ", person.myBookings(ba));
		DateTime start = new DateTime(2004, 12, 25, 0, 0, 0, 0);
		DateTime end = new DateTime(2005, 1, 1, 0, 0, 0, 0);
		int a1 = ((User)person).addBooking(ba, res, "a", start, end);
		Booking book = new Booking(person, "a", new Interval(start, end));
		DateTime start1 = new DateTime(2009, 12, 25, 0, 0, 0, 0);
		DateTime end1 = new DateTime(2009, 1, 1, 0, 0, 0, 0);
		int a2 = ((User)person1).addBooking(ba, res, "a", start, end);
		System.out.println(person.myBookings(ba));
		assertEquals("Se hai fatto una prenotazione stampa dati utente e prenotazione ", 
				"Federica Bianchi abc@abc.it: " + book + "\n", person.myBookings(ba));		
		}
	
	@Test
	public void testUserMyBookingsFuture() {
		List<Booking> l = new ArrayList<>();
		int colors = 256;
		Person person = new User("Federica", "Bianchi", "abc@abc.it", "123");
		Person person1 = new User("Federica", "Rossi", "abc@abc.it", "123");
		Resource res = new Projector(l, colors);
		BookingsOrganizer ba = new BookingsOrganizer(res);
		DateTime start1 = new DateTime(2009, 12, 25, 0, 0, 0, 0);
		DateTime end1 = new DateTime(2010, 1, 1, 0, 0, 0, 0);
		int a2 = ((User)person1).addBooking(ba, res, "a", start1, end1);
		assertEquals("Se hai fatto prenotazioni solo in passato stampa dati utente: ", 
				"Federica Bianchi abc@abc.it: ", person.myBookings(ba));
		DateTime start = new DateTime(2019, 12, 25, 0, 0, 0, 0);
		DateTime end = new DateTime(2020, 1, 1, 0, 0, 0, 0);
		int a1 = ((User)person).addBooking(ba, res, "a", start, end);
		Booking book = new Booking(person, "a", new Interval(start, end));
		System.out.println(person.myFutureBookings(ba));
		assertEquals("Se hai fatto una prenotazione futura stampa dati utente e prenotazione ", 
				"Federica Bianchi abc@abc.it: " + book + "\n", person.myFutureBookings(ba));		
		}
	
	@Test
	public void testUserMyBookingsPast() {
		List<Booking> l = new ArrayList<>();
		int colors = 256;
		Person person = new User("Federica", "Bianchi", "abc@abc.it", "123");
		Person person1 = new User("Federica", "Rossi", "abc@abc.it", "123");
		Resource res = new Projector(l, colors);
		BookingsOrganizer ba = new BookingsOrganizer(res);
		DateTime start1 = new DateTime(2019, 12, 25, 0, 0, 0, 0);
		DateTime end1 = new DateTime(2020, 1, 1, 0, 0, 0, 0);
		int a2 = ((User)person1).addBooking(ba, res, "a", start1, end1);
		assertEquals("Se hai fatto prenotazioni in futuro stampa dati utente: ", 
				"Federica Bianchi abc@abc.it: ", person.myBookings(ba));
		DateTime start = new DateTime(2009, 12, 25, 0, 0, 0, 0);
		DateTime end = new DateTime(2010, 1, 1, 0, 0, 0, 0);
		int a1 = ((User)person).addBooking(ba, res, "a", start, end);
		Booking book = new Booking(person, "a", new Interval(start, end));
		assertEquals("Se hai fatto una prenotazione passata stampa dati utente e prenotazione ", 
				"Federica Bianchi abc@abc.it: " + book + "\n", person.myPastBookings(ba));		
		}
	@Test
	public void testAdminUserBookings() {
		List<Booking> l = new ArrayList<>();
		int colors = 256;
		Person person = new User("Federica", "Bianchi", "abc@abc.it", "123");
		Person person1 = new User("Federica", "Rossi", "abc@abc.it", "123");
		List<User> users = new ArrayList<>();
		users.add((User)person);
		users.add((User)person1);
		Admin admin = new Admin("Mario", "Rossi", "cde@cde.it", "1234");
		Resource res = new Projector(l, colors);
		BookingsOrganizer ba = new BookingsOrganizer(res);
		System.out.println(admin.userBookings(ba, users));
		assertEquals("Se non ha mai fatto prenotazioni stampa dati utenti: ", 
				"Federica Bianchi abc@abc.it: \nFederica Rossi abc@abc.it: \n", admin.userBookings(ba, users));
		DateTime start = new DateTime(2004, 12, 25, 0, 0, 0, 0);
		DateTime end = new DateTime(2005, 1, 1, 0, 0, 0, 0);
		int a1 = ((User)person).addBooking(ba, res, "a", start, end);
		Booking book = new Booking(person, "a", new Interval(start, end));		
		DateTime start1 = new DateTime(2009, 12, 25, 0, 0, 0, 0);
		DateTime end1 = new DateTime(2010, 1, 1, 0, 0, 0, 0);
		Booking book1 = new Booking(person1, "a", new Interval(start1, end1));
		int a2 = ((User)person1).addBooking(ba, res, "a", start1, end1);
		System.out.println(person.myBookings(ba));
		assertEquals("Se hai fatto una prenotazione stampa dati utente sue prenotazioni ", 
				"Federica Bianchi abc@abc.it: \n" + book + "\n" + "Federica Rossi abc@abc.it: \n"
						+ book1 + "\n",admin.userBookings(ba, users));
	}
	
}


