package it.ariadne.BookingManagement;

import org.joda.time.Interval;
import org.joda.time.ReadableInterval;
import org.joda.time.base.AbstractInterval;

public class Booking {
	private Interval i;
	private String name;
	
	
	public Booking(String name, Interval i) {
		this.name = name;
		this.i = i;
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
	

}
