package de.buw.se4de;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;



public class CSVScanner {
	
	private Scanner sc;
	

	public List<ArrayList<String>> readCSV(String path){		
		/**
		 * The readVocCSV read the vocabularies from the inputed CSV file path and return the vocabularies in
		 * a list.
		 */
		try {
			sc = new Scanner (new File(path));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		sc.useDelimiter(",");
		
		List<ArrayList<String>> patient_list = new ArrayList<ArrayList<String>>();
		
		String x;
		
		while (sc.hasNextLine()) {
				
				// The red lines are converted to the needed format (ArrayList)
				x = sc.nextLine();	
				String [] cache = x.split(",");
				List<String> convert = Arrays.asList(cache);
				ArrayList<String> patient = new ArrayList<String>(convert);				
				patient_list.add(patient);
				
				}

		sc.close();
		
		return patient_list;
	}

	
	public void writeFile(List<ArrayList<String>> copy_file) {
		/**
		 * This method generated a new CSV file
		 */
		 try {
		    CSVPrinter printer = new CSVPrinter(new FileWriter("src/main/resources/patients.csv"),CSVFormat.DEFAULT);
		    
			for (ArrayList<String> patient : copy_file) {
				printer.printRecord(patient);
			}
			
			printer.flush();
			printer.close();
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
	}

	public void addToFile(Patient a, ArrayList<String> p) {
		/**
		 * This method adds values from the inputed list to the state CSV file.
		 */
		boolean patientRegistered = false;
		List<ArrayList<String>> copy_file = new ArrayList<ArrayList<String>>();	
		copy_file = readCSV("src/main/resources/patients.csv");
		
		// Check if Patient is already registered
		for(ArrayList<String> list : copy_file) {			
			if(list.contains(a.getInsureNo())) {
				a.name = list.get(0);
				a.bd = list.get(1);
				a.in = list.get(2);
				patientRegistered = true;		
				}	
		}
		if (patientRegistered = true) {
			System.out.println("This Insurance No. is already registered!");
			a.printRecord();
		}
		else {
			copy_file.add(p);
			writeFile(copy_file);
		}
	}
		    
	public void deleteFile(String fileToDelete) {
		/**
		 * This method deletes a CSV file with the name of the inputed name.
		 */
		try {
			Files.deleteIfExists(Paths.get("src/main/resources/"+fileToDelete+".csv"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Cant delete");
		} 
		
	}

	
	public void freshStart() {
		/**
		 * This method deletes all files CSV files which where generated during the vocabulary training.
		 */
		deleteFile("remaining_voc");
		deleteFile("unknown_voc");
		deleteFile("known_voc");

	}
						
}



