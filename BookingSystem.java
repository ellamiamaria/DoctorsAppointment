package de.buw.se4de;

import java.util.Scanner;

public class BookingSystem {

	// main Method
	public static void main(String[] args) {	
		boolean programrunning = true;
		Scanner sc = new Scanner(System.in);
		
		while(programrunning) {
			System.out.println("Welcome to the main menu! What do you want to do?");
			System.out.println("	(a) Register or check my patient file entrys");
			System.out.println(" 	(b) Schedule or cancel an appointment");
			System.out.println("	(c) Leave application");
			
			String entry = sc.nextLine();			
			if (entry.toLowerCase().equals("a")) {
				Patient p = new Patient();
			}			
			else if(entry.toLowerCase().equals("b")) {
				//Hier kommt Appointment rein
			}
			else if(entry.toLowerCase().equals("c")) {
				System.out.println("Thanks! Have a good day.");
				programrunning = false;
				
			}
			else {
				System.out.println("Wrong input, try again!");
			}
		}
		
		
	}

	
	// class Appointment for Doctors schedule
	

}
