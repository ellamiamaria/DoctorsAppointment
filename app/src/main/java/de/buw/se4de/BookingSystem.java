
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
