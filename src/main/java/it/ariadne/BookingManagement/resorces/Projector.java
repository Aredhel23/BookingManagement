package it.ariadne.BookingManagement.resorces;

import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Interval;

import it.ariadne.BookingManagement.Booking;
import it.ariadne.BookingManagement.Resource;

public class Projector implements Resource {
	
	private List<Booking> projectorList;
	
	public Projector(List<Booking> l) {
		this.projectorList = l;
	}
	

	@Override
	public List<Booking> getList() {
		return projectorList;
	}





}
