package it.ariadne.BookingManagement;

import org.joda.time.Interval;
import org.joda.time.ReadableInterval;
import org.joda.time.base.AbstractInterval;

public class Booking {
	private Interval i;
	private String name;
	private Person u;
	
	public Person getUser() {
		return u;
	}



	public Booking(Person u, String name, Interval i) {
		this.name = name;
		this.i = i;
		this.u = u;
	}


	ReadableInterval getInterval() {
		return i;
	}


	public Interval getI() {
		return i;
	}


	public String getName() {
		return name;
	}



	@Override
	public String toString() {
		return "Prenotazione [data=" + i + ", nome=" + name + ", utente=" + u + "]";
	}
	
	

}
