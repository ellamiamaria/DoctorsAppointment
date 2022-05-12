package de.buw.se4de;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


// class Patient for storing Patient's information
	public class Patient {

		private ArrayList<String> p = new ArrayList<String>();
		private Scanner sc = new Scanner(System.in);
		private String registered;
		public String name;
		public String bd;
		public String in;
		public static String PATH = "src/main/resources/patients.csv";

		// Instance of Patient for getting the Users information from consul
		public Patient() {
			System.out.println("Are you already registered as a Patient? Type 'y' or 'n': ");
			this.registered = sc.nextLine();
			
			if (this.registered.toLowerCase().equals("y")) {
				checkPatient();
			}			
			else if(this.registered.toLowerCase().equals("n")) {
				generatePatient();
			}
			else {
				System.out.println("Wrong input, try again!");
				Patient a = new Patient();
			}

			
		}
		
		// Generates new patient & adds to CSVfile 
		public void generatePatient() {
			
			System.out.println("Enter your Full name: ");
			this.name = sc.nextLine();
			p.add(this.name);
			System.out.println("Enter your date of birth(DD/MM/YYYY): ");
			this.bd = sc.nextLine();
			p.add(this.bd);
			System.out.println("Enter your insurance No.: ");
			this.in = sc.nextLine();
			p.add(this.in);
			
			CSVScanner scanni = new CSVScanner();
			scanni.addToFile(this, p);
		}
		
		//Searches CSV for Patient, if found prints data, if not registers patient as new one
		public void checkPatient() {
			
			boolean patientRegistered = false;
			
			System.out.println("Welcome back! Please enter your insurance no.: ");
			this.in = sc.nextLine();
			
			CSVScanner scanni = new CSVScanner();
			List<ArrayList<String>> patient_list = scanni.readCSV(PATH);
			System.out.println(patient_list);
			
			for(ArrayList<String> list : patient_list) {
				if(list.contains(this.in)) {
					this.name = list.get(0);
					this.bd = list.get(1);
					patientRegistered = true;		
				}
			}
			if (patientRegistered = false) {
				System.out.println("Sorry, can't find your patient record, please register!");
				generatePatient();
			}
			else {
				printRecord();
			}
			
		}
		
		//Prints complete Patient Record
		public void printRecord() {
			System.out.println("Patient record found! Your data: ");
			System.out.println("Name: " + getName());
			System.out.println("Birthday: " + getBirthday());
			System.out.println("Insurance no.: " + getInsureNo());
		}

		public String getName() {
			return this.name;
		}

		public String getBirthday() {
			return this.bd;
		}

		public String getInsureNo() {
			return this.in;
		}

		public void setName(String name) {
			this.name = name;
		}

		public void setBirthday(String dateOfBirth) {
			this.bd = dateOfBirth;
		}

		public void setInsurNo(String InsureNo) {
			this.in = InsureNo;
		}

	}
