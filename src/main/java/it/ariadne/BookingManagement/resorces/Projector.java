package it.ariadne.BookingManagement.resorces;

import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Interval;

import it.ariadne.BookingManagement.Booking;
import it.ariadne.BookingManagement.Resource;

public class Projector implements Resource {
	
	private List<Booking> projectorList;
	private int colors;
	private String name;
	private String type = "Projector";
	/***
	 * constructor of the projector.
	 * @param l list of the bookings of the projector.
	 * @param colors limit of the projector.
	 * @param name  the name of the projector.
	 */
	public Projector(List<Booking> l, int colors, String name) {
		this.projectorList = l;
		this.colors = colors;
		this.name = name;
	}
	

	@Override
	public List<Booking> getList() {
		return projectorList;
	}


	@Override
	public int getLimit() {
		return colors;
	}


	@Override
	public String getType() {
		
		return type;
	}


	@Override
	public String bookingPrintList() {
		String s = this.toString();
		for(Booking b:projectorList) {
			s = s + b.toString() + "\n";
		}
		return s;
	}


	@Override
	public String toString() {
		return "Projector [colors=" + colors + ", type=" + type + "]:\n";
	}


	@Override
	public int setLimit(int lim) {
		if (lim == this.colors)
			return 1;
		else {
			this.colors = lim;
			return 0;
		}
	}
	





}
