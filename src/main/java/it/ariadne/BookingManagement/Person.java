package it.ariadne.BookingManagement;

import org.joda.time.DateTime;

public abstract class Person {
	private String name;
	private String surname;
	private String email;
	private String password;
	public Person(String name, String surname, String email, String password) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
	}
}
