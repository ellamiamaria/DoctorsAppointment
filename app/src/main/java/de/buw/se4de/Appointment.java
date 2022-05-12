package de.buw.se4de;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Appointment {

		private String[] doctors = { "Schmidt", "Koch", "Ringert", "Schneider", "Fischer", "Weber", "Meyer", "Wagner",
				"Hoffmann", "Schulz" };

		private String[] speciality = { "Physiologist", "Dentist", "ENT", "Interal", "Orthopedist", "Neurologist",
				"Radiologist", "Dermatologist", "Urologist", "Oncologist" };

		private String[] date = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" };

		private String[] time = { "10", "11", "13", "14", "15", "16", "17", "18" };

		private ArrayList<String[]> schedule = new ArrayList<>();
		private ArrayList<String> patientChoice = new ArrayList<>();
		private Scanner sc = new Scanner(System.in);
		private String doc = "";
		private String spec = "";
		private String day = "";
		private String hr = "";

		// class for adding the Patient appointment to schedule
		public Appointment() {
			this.schedule.add(this.doctors);
			this.schedule.add(this.speciality);
			this.schedule.add(this.date);
			this.schedule.add(this.time);
		}

		// class for choosing the Doctor
		public void setDoctor() {
			for (String n : this.schedule.get(0)) {
				System.out.println(n);
			}
			System.out.println("Please select a doctor: ");
			doc = sc.nextLine();
			boolean found = Arrays.stream(this.schedule.get(0)).anyMatch(t -> t.equals(doc));
			if (found) {
				this.patientChoice.add(0, doc);
			} else {
				System.out.println("Enter the correct name: ");
				setDoctor();
			}
		}

		// class for choosing the Doctor's Speciality
		public void setSpeciality() {
			for (String n : this.schedule.get(1)) {
				System.out.println(n);
			}
			System.out.println("Please select speciality: ");
			spec = sc.nextLine();
			boolean found = Arrays.stream(this.schedule.get(1)).anyMatch(t -> t.equals(spec));
			if (found) {
				this.patientChoice.add(1, spec);
			} else {
				System.out.println("Enter the correct speciality: ");
				setSpeciality();
			}
		}

		// class for setting the date of appointment
		public void setDate() {
			for (String n : this.schedule.get(2)) {
				System.out.println(n);
			}
			System.out.println("Please select a date: ");
			day = sc.nextLine();
			boolean found = Arrays.stream(this.schedule.get(2)).anyMatch(t -> t.equals(day));
			if (found) {
				this.patientChoice.add(2, day);
			} else {
				System.out.println("Enter the correct day: ");
				setDate();
			}
		}

		// class for setting the time (hour) of appointment
		public void setTime() {
			for (String n : this.schedule.get(3)) {
				System.out.println(n);
			}
			System.out.println("Please select a time: ");
			hr = sc.nextLine();
			boolean found = Arrays.stream(this.schedule.get(3)).anyMatch(t -> t.equals(hr));
			if (found) {
				this.patientChoice.add(3, hr);
			} else {
				System.out.println("Enter the correct time: ");
				setTime();
			}
		}

		public String getDocName() {
			return this.patientChoice.get(0);
		}

		public String getDate() {
			return this.patientChoice.get(2);
		}

		public String getTime() {
			return this.patientChoice.get(3);
		}

	}