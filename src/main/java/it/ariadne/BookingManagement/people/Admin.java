package it.ariadne.BookingManagement.people;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import it.ariadne.BookingManagement.BookingsOrganizer;
import it.ariadne.BookingManagement.Person;
import it.ariadne.BookingManagement.Resource;

/***
 * Class Admin, that extends Person, to manage the administrator tasks.
 * @author Aredhel23
 *
 */
public class Admin extends Person {

	/***
	 * Administrator constructor
	 * @param name
	 * @param surname
	 * @param email
	 * @param password
	 */
	public Admin(String name, String surname, String email, String password) {
		super(name, surname, email, password);
	}
	
	/***
	 * method to generate the string with the bookings divided by user
	 * @param ba booking organizer with the bookings of all the resources.
	 * @param users List of the users that have done bookings.
	 * @return the String that lists the bookings divided by users.
	 */
	public String userBookings(BookingsOrganizer ba, List<User> users) {
		String s = "";
		for (User us: users) {
			s = s + us.myBookings(ba);
		}
		return s;
	}
	
	/***
	 * method to generate the string with the bookings divided by resource
	 * @param ba booking organizer with the bookings of all the resources.
	 * @return the String that lists the bookings divided by users.
	 */
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

	/***
	 * method to add a resource.
	 * @param ba booking organizer where are resources and booking lists of them.
	 * @param res the resource to add.
	 * @return 0 if the resource is added, 1 otherwise.
	 */
	public int addResource(BookingsOrganizer ba, Resource res) {
		if(ba.getOrganizer().containsKey(res))
			return 1;
		else {
			ba.getOrganizer().put(res, res.getList());
			return 0;
		}
	}
	/***
	 * method to delete a resource.
	 * @param ba booking organizer where are resources and booking lists of them.
	 * @param res the resource to delete.
	 * @return 0 if the resource is deleted, 1 otherwise.
	 */
	public int deleteResource(BookingsOrganizer ba, Resource res) {
		if(ba.getOrganizer().containsKey(res)) {
			ba.getOrganizer().remove(res);
			return 0;
		}
		else {
			return 1;
		}
	}
	/***
	 * method to read the booking of a resource.
	 * @param ba booking organizer where are resources and booking lists of them.
	 * @param res resource to be read. 
	 * @return the string listing the bookings of the resource.
	 */
	public String readResource(BookingsOrganizer ba, Resource res) {
		String s = "Risorsa: \n";
		if(ba.getOrganizer().containsKey(res))
			s = s + res.bookingPrintList(); 
		return s;
	}
	/***
	 * method to update a resource.
	 * @param ba booking organizer where are resources and booking lists of them.
	 * @param res the resource that has to be updated.
	 * @param res1 the new resource to update.
	 * @return 0 if the resource is updated, 1 otherwise.
	 */
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
