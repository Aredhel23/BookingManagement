package it.ariadne.BookingManagement.resources;

import java.util.ArrayList;
import java.util.List;

import it.ariadne.BookingManagement.Booking;
import it.ariadne.BookingManagement.Resource;

public class Projector implements Resource {
	
	private List<Booking> projectorList;
	private int colors;
	private String name;
	private String type = "Projector";
	/***
	 * constructor of the projector.
	 */
	public Projector() {
		this.projectorList = new ArrayList<>();
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

	public int getColors() {
		return colors;
	}
	@Override
	public String getName() {
		return name;
	}

	public void setColors(int colors) {
		this.colors = colors;
	}
	@Override
	public void setName(String name) {
		this.name = name;
	}
	





}
