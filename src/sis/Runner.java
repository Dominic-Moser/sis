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
//		calculateGPA();
		System.out.println("Select an option \n 1: Sort Students \n 2: Add or Delete a Student \n 3: Change a Student's Grades or Schedule");
		int option = userIntInput.nextInt();
		
		if(option == 1) {
			sort();
		}
		if(option == 2) {
//			addDelete();
		}
		if(option == 3) {
			editStudent(sClass);
		}
		}

//	private static void calculateGPA()
//		{
//			double GPA = 0;
//			for(int i = 0; i < student.length(); i++) {
//				if(student.get(i).getGrade1().equals("A+")) {
//					GPA += 4.0;
//				}
//				if(student.get(i).getGrade1().equals("A")) {
//					GPA += 4.0;
//				}
//				if(student.get(i).getGrade1().equals("A-")) {
//					GPA += 3.7;
//				}
//				if(student.get(i).getGrade1().equals("B+")) {
//					GPA += 3.3;
//				}
//				if(student.get(i).getGrade1().equals("B")) {
//					GPA += 3.0;
//				}
//				if(student.get(i).getGrade1().equals("B-")) {
//					GPA += 2.7;
//				}
//				if(student.get(i).getGrade1().equals("C+")) {
//					GPA += 2.3;
//				}
//				if(student.get(i).getGrade1().equals("C")) {
//					GPA += 2.0;
//				}
//				if(student.get(i).getGrade1().equals("C-")) {
//					GPA += 1.7;
//				}
//				if(student.get(i).getGrade1().equals("D+")) {
//					GPA += 1.3;
//				}
//				if(student.get(i).getGrade1().equals("D")) {
//					GPA += 1.0;
//				}
//				else {
//					GPA += 0;
//				}
//				GPA = GPA/3;
//			}
//			
//		}

	private static void editStudent(ArrayList<Student> sClass)
		{
			ArrayList<String> courses = new ArrayList<String>();
			courses.add(new String("Algebra"));
			courses.add(new String("Biology"));
			courses.add(new String("English"));
			System.out.println("Select number next to the student that you would like to edit.");
			int counter = 1;			
			for(Student s : sClass)
				{
					System.out.println(counter + ". " + s.getFirstName() + " " + s.getLastName());
					counter++;
				}
			int studentChoice = userIntInput.nextInt();
			studentChoice--;
			System.out.println("Select an Option \n 1: Change the student's schedule \n 2: Change the student's grades");
			int option = userIntInput.nextInt();
			if(option == 1) {//changes student's classes and schedule
				System.out.println("Select which class you would like to put the student into.");
				System.out.println("\n 1. Algebra \n 2. Biology \n 3. English");			
				int newClass = userIntInput.nextInt();
				newClass--;
				System.out.println("Select which current class you would like to edit.");
				System.out.println("\n 1. " + sClass.get(studentChoice).getPeriod1() + "\n 2. " + sClass.get(studentChoice).getPeriod2() + "\n 3. " + sClass.get(studentChoice).getPeriod3());
				int periodChoice = userIntInput.nextInt();
				if(periodChoice == 1)
				{
					sClass.get(studentChoice).setPeriod1(courses.get(newClass));
				}
				else if(periodChoice == 2)
				{
					sClass.get(studentChoice).setPeriod2(courses.get(newClass));
				}
				else if(periodChoice == 3)
				{
					sClass.get(studentChoice).setPeriod3(courses.get(newClass));
				}
			}
			if(option == 2) {//changes student's grades
				System.out.println("Select which of the student's grades you would like to change.");
				System.out.println("\n 1. " + sClass.get(studentChoice).getPeriod1() + " " + sClass.get(studentChoice).getGrade1() +
						"\n 2. " + sClass.get(studentChoice).getPeriod2() + " " + sClass.get(studentChoice).getGrade2() + 
						"\n 3. " + sClass.get(studentChoice).getPeriod3() + " " + sClass.get(studentChoice).getGrade3());
				int periodChoice = userIntInput.nextInt();
				System.out.println("What would you like the student's new grade to be? A+, A, B+, B, B-, and so on");
				String newGrade = userStringInput.nextLine();
				newGrade.toUpperCase();
				switch(periodChoice)
				{
					case 1:
					{
						sClass.get(studentChoice).setGrade1(newGrade);
					}
					case 2:
					{
						sClass.get(studentChoice).setGrade2(newGrade);
					}
					case 3:
					{
						sClass.get(studentChoice).setGrade3(newGrade);
					}
				}
			}
			System.out.println("The Student's new schedule and grades are :" + 				
					("\n 1. " + sClass.get(studentChoice).getPeriod1() + " " + sClass.get(studentChoice).getGrade1() +
					"\n 2. " + sClass.get(studentChoice).getPeriod2() + " " + sClass.get(studentChoice).getGrade2() + 
					"\n 3. " + sClass.get(studentChoice).getPeriod3() + " " + sClass.get(studentChoice).getGrade3()));
			
		}

//	private static void addDelete()
//		{
//			System.out.println("Select an Option \n 1: Add a student \n 2: Delete a student");
//			int option = userIntInput.nextInt();
//			if(option == 1) {
//				System.out.println("Enter New Student's first name");
//				String firstName = userStringInput.nextLine();
//				
//				System.out.println("Enter New Student's last name");
//				String lastName = userStringInput.nextLine();
//				
//				System.out.println("Enter New Student's first period");
//				String period1 = userStringInput.nextLine();
//				System.out.println("Enter New Student's first period grade");
//				String grade1 = userStringInput.nextLine();
//				System.out.println("Enter New Student's second period");
//				String period2 = userStringInput.nextLine();
//				System.out.println("Enter New Student's second period grade");
//				String grade2 = userStringInput.nextLine();
//				
//				System.out.println("Enter New Student's third period");
//				String period3 = userStringInput.nextLine();
//				System.out.println("Enter New Student's third period grade");
//				String grade3 = userStringInput.nextLine();
//				
//				//will not work until pojo and arraylist are in working order
//				Student.add(new Student(firstName, lastName, period1, period2, period3, grade1, grade2, grade3));
//			}
//			if(option == 2) {
//				System.out.println("Enter the last name of the student you would like to remove");
//				String lastName = userStringInput.nextLine();
////				for(int i = 0; i < student.length(); i++) {
////					//once again wont work until yall pick up the slack smh my head
////				}
//			}
//		}

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