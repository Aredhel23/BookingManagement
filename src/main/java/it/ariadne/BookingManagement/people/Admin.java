package it.ariadne.BookingManagement.people;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import it.ariadne.BookingManagement.BookingsOrganizer;
import it.ariadne.BookingManagement.Person;
import it.ariadne.BookingManagement.Resource;

public class Admin extends Person {

	public Admin(String name, String surname, String email, String password) {
		super(name, surname, email, password);
	}

	public String userBookings(BookingsOrganizer ba, List<User> users) {
		String s = "";
		for (User us: users) {
			s = s + us.myBookings(ba);
		}
		return s;
	}

	public String resourceBookings(BookingsOrganizer ba) {
		Iterator it = ba.getOrganizer().entrySet().iterator();
		String s ="";
		 while (it.hasNext()) {
			    Map.Entry entry = (Map.Entry)it.next();
			    Resource r = (Resource)entry.getKey();
			    s = s + r.bookingPrintList();
		 }
		return s;
	}

	public int addResource(BookingsOrganizer ba, Resource res) {
		if(ba.getOrganizer().containsKey(res))
			return 1;
		else {
			ba.getOrganizer().put(res, res.getList());
			return 0;
		}
	}

	public int deleteResource(BookingsOrganizer ba, Resource res) {
		if(ba.getOrganizer().containsKey(res)) {
			ba.getOrganizer().remove(res);
			return 0;
		}
		else {
			return 1;
		}
	}

	public String readResource(BookingsOrganizer ba, Resource res) {
		String s = "Risorsa: \n";
		if(ba.getOrganizer().containsKey(res))
			s = s + res.bookingPrintList(); 
		return s;
	}

	public int updateResource(BookingsOrganizer ba, Resource res, Resource res1) {
		if(ba.getOrganizer().containsKey(res)) {
			ba.getOrganizer().remove(res);
			(ba.getOrganizer()).put(res1, res1.getList());
		return 0;
		}
		else
			return 1;
	}
	
	

}
