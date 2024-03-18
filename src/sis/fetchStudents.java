package sis;

import java.util.*;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors

public class fetchStudents {

	public static ArrayList<Student> parseResult() throws FileNotFoundException {
		 System.out.println(System.getProperty("user.dir"));
		
	      File myObj = new File(System.getProperty("user.dir") + "/src/sis" + "/StudentList.txt");
	      Scanner myReader = new Scanner(myObj);
        int numOfLines = 24;
        
		ArrayList<Student> result = new ArrayList<>();
		
	      while (myReader.hasNextLine()) {
	    	  
			String nextLine = myReader.nextLine();
			
			String[] split = nextLine.split(" ");
			
			result.add(new Student(split[0], split[1], split[2], split[4], split[6], split[3], split[5], split[7]));
		}
		
		myReader.close();
		
		return result;
	}
	
	
}
