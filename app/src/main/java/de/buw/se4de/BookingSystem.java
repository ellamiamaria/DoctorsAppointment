////////////////////////Software Engineering Assignment 2 //////////////////
///////////////////////////////////Group 3//////////////////////////////////
/////////////////////////////Doctor Appointment Booking System/////////////

import java.util.ArrayList; // importing java Array 
import java.util.Arrays;
import java.util.Scanner; // importing java scanner for getting input from User

public class BookingSystem {

	// main Method
	public static void main(String[] args) {

		Patient p = new Patient();
		Appointment a = new Appointment();
		a.setDoctor();
		a.setSpeciality();
		a.setDate();
		a.setTime();
		System.out.println("Dear " + p.getName() + "!" + " You have successfully booked an appointment with " + "Dr. "
				+ a.getDocName() + " on " + a.getDate() + " at " + a.getTime() + "!");
	}

	
	// class Appointment for Doctors schedule
	

}
