import java.util.ArrayList;
import java.util.Scanner;


// class Patient for storing Patient's information
	public class Patient {

		private ArrayList<String> p = new ArrayList<String>();
		private Scanner sc = new Scanner(System.in);
		private String name;
		private String bd;
		private String in;

		// method Patient for getting the Users information from consul
		public Patient() {
			System.out.println("Enter your Full name: ");
			this.name = sc.nextLine();
			p.add(0, this.name);
			System.out.println("Enter your date of birth(DD/MM/YYYY): ");
			this.bd = sc.nextLine();
			p.add(1, this.bd);
			System.out.println("Enter your insurance No.: ");
			this.in = sc.nextLine();
			p.add(2, this.in);
		}
		
		public void generatePatient() {
			
		}
		
		
		
		
		public void print(Patient p) {
			System.out.println(p.toString());
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
