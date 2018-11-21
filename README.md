# BookingManagement

The aim of this project is to create a site that manages bookings and rentals of different objects using a back-end part written in Java.

## Actors

There can be two different type of actors:

+ The user,
+ The admin.

The user can verify availability of a resource, book it in a time, check its availability for a period and print the list of his bookings.

The admin manages the resources, adding, deleting and updating them. He can also print all the booking divided by user o by resource.

## The Organizer

All the bookings of each Resource are saved in an organizer. The organizer makes all the action dealing with bookings.

## A Booking

A booking is formed by a name, the dateTime interval it occupies and by the User that makes it.
