package it.ariadne.BookingManagement.resorces;

import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Interval;

import it.ariadne.BookingManagement.Booking;
import it.ariadne.BookingManagement.Resource;

public class Projector implements Resource {
	
	private List<Booking> projectorList;
	private int colors;
	private String type = "Projector";
	public Projector(List<Booking> l, int colors) {
		this.projectorList = l;
		this.colors = colors;
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





}
