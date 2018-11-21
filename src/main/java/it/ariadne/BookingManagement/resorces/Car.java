package it.ariadne.BookingManagement.resorces;

import java.util.ArrayList;
import java.util.List;

import it.ariadne.BookingManagement.Booking;
import it.ariadne.BookingManagement.Resource;

public class Car implements Resource {
	private int seats;
	private List<Booking> bookings;
	private String type;
	private String name;
	
	
	public Car(String name, int seats) {
		this.name = name;
		this.seats = seats;
		this.bookings = new ArrayList<>();
		this.type = "Car";
	}

	@Override
	public List<Booking> getList() {
		
		return bookings;
	}

	@Override
	public String getType() {
	
		return type;
	}

	@Override
	public int getLimit() {
		return seats;
	}

	@Override
	public String bookingPrintList() {
		String s = this.toString();
		for(Booking b:bookings) {
			s = s + b.toString() + "\n";
		}
		return s;
	}
	
	@Override
	public String toString() {
		return "Car [name =" + name + "seats=" + seats + ", type=" + type + "]:\n";
	}

}
