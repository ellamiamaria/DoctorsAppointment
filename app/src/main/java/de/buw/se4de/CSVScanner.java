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
		
		List<ArrayList<String>> input_list = new ArrayList<ArrayList<String>>();
		
		String x;
		
		while (sc.hasNextLine()) {
				
				// The red lines are converted to the needed format (ArrayList)
				x = sc.nextLine();	
				String [] cache = x.split(",");
				List<String> convert = Arrays.asList(cache);
				ArrayList<String> input = new ArrayList<String>(convert);				
				input_list.add(input);
				
				}

		sc.close();
		
		return input_list;
	}

	
	public void writeFile(List<ArrayList<String>> output_file) {
		/**
		 * This method generated a new CSV file
		 */
		 try {
		    CSVPrinter printer = new CSVPrinter(new FileWriter("src/main/resources/patients.csv"),CSVFormat.DEFAULT);
		    
			for (ArrayList<String> output : output_file) {
				printer.printRecord(output);
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
		
		List<ArrayList<String>> copy_file = new ArrayList<ArrayList<String>>();	
		copy_file = readCSV("src/main/resources/patients.csv");
		copy_file.add(p);
		writeFile(copy_file);
		}
}				



