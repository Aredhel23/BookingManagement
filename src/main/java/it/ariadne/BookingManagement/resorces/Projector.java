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
	public boolean bookingRequest(DateTime start, DateTime end) {
		return Resource.bookingRequest(projectorList, start, end);
	}
	
	@Override
	public List<Booking> getList() {
		return projectorList;
	}

	@Override
	public int addBooking(String name, DateTime start, DateTime end) {
		if(bookingRequest(start, end)) {
			Interval interval = new Interval(start, end);
			Booking p = new Booking(name, interval);
			projectorList.add(p);
			return 0;
		}
		else 
			return 1;
	}

	@Override
	public int deleteBooking(String name, DateTime start, DateTime end) {
		for (Booking b:projectorList) {
			if(b.getName().equals(name))
				if(b.getI().getStart().equals(start) && b.getI().getEnd().equals(end)) {
					projectorList.remove(b);
					return 0;
				}
		}
		return 1;
	}



}
