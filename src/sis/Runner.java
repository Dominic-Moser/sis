package sis;

import java.util.*;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors

public class Runner {
	static Scanner userIntInput = new Scanner(System.in);
	static Scanner userStringInput = new Scanner(System.in);
	
	public static void main(String[] args) throws FileNotFoundException
	{
		ArrayList<Student> sClass = fetchStudents.parseResult(); //INSTANTED!
		//USE SCLASS WHEN MANIPULATING OR DISPLAYING DATA
		calculateGPA();
		System.out.println("Select an option \n 1: Sort Students \n 2: Add or Delete a Student \n 3: Change a Student's Grades or Schedule");
		int option = userIntInput.nextInt();
		
		if(option == 1) {
			sort();
		}
		if(option == 2) {
			addDelete();
		}
		if(option == 3) {
			changeSched();
		}
		}

	private static void calculateGPA()
		{
			double GPA = 0;
			for(int i = 0; i < student.length(); i++) {
				if(student.get(i).getGrade1().equals("A+")) {
					GPA += 4.0;
				}
				if(student.get(i).getGrade1().equals("A")) {
					GPA += 4.0;
				}
				if(student.get(i).getGrade1().equals("A-")) {
					GPA += 3.7;
				}
				if(student.get(i).getGrade1().equals("B+")) {
					GPA += 3.3;
				}
				if(student.get(i).getGrade1().equals("B")) {
					GPA += 3.0;
				}
				if(student.get(i).getGrade1().equals("B-")) {
					GPA += 2.7;
				}
				if(student.get(i).getGrade1().equals("C+")) {
					GPA += 2.3;
				}
				if(student.get(i).getGrade1().equals("C")) {
					GPA += 2.0;
				}
				if(student.get(i).getGrade1().equals("C-")) {
					GPA += 1.7;
				}
				if(student.get(i).getGrade1().equals("D+")) {
					GPA += 1.3;
				}
				if(student.get(i).getGrade1().equals("D")) {
					GPA += 1.0;
				}
				else {
					GPA += 0;
				}
				GPA = GPA/3;
			}
			
		}

	private static void changeSched()
		{
			System.out.println("Select an Option \n 1: Change a student's schedule \n 2: Change a student's grades");
			int option = userIntInput.nextInt();
			if(option == 1) {
				
			}
			if(option == 2) {
				
			}
			
		}

	private static void addDelete()
		{
			System.out.println("Select an Option \n 1: Add a student \n 2: Delete a student");
			int option = userIntInput.nextInt();
			if(option == 1) {
				System.out.println("Enter New Student's first name");
				String firstName = userStringInput.nextLine();
				
				System.out.println("Enter New Student's last name");
				String lastName = userStringInput.nextLine();
				
				System.out.println("Enter New Student's first period");
				String period1 = userStringInput.nextLine();
				System.out.println("Enter New Student's first period grade");
				String grade1 = userStringInput.nextLine();
				System.out.println("Enter New Student's second period");
				String period2 = userStringInput.nextLine();
				System.out.println("Enter New Student's second period grade");
				String grade2 = userStringInput.nextLine();
				
				System.out.println("Enter New Student's third period");
				String period3 = userStringInput.nextLine();
				System.out.println("Enter New Student's third period grade");
				String grade3 = userStringInput.nextLine();
				
				//will not work until pojo and arraylist are in working order
				Student.add(new Student(firstName, lastName, period1, period2, period3, grade1, grade2, grade3));
			}
			if(option == 2) {
				System.out.println("Enter the last name of the student you would like to remove");
				String lastName = userStringInput.nextLine();
//				for(int i = 0; i < student.length(); i++) {
//					//once again wont work until yall pick up the slack smh my head
//				}
			}
		}

	private static void sort()
		{
			System.out.println("Select an Option \n 1: Sort by last name \n 2: Sort by GPA \n 3: Sort by period");
			int option = userIntInput.nextInt();
			if(option == 1) {
				//sort by name
			}
			if(option == 2) {
				//sort by GPA
			}
			if(option == 3) {
				//sort by period
				System.out.println("Which period would you like to sort by?");
			}
			
		}

}
