package sis;

import java.util.*;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Runner {
	static Scanner userIntInput = new Scanner(System.in);
	static Scanner userStringInput = new Scanner(System.in);
	
	public static void main(String[] args) throws FileNotFoundException
	{
		ArrayList<Student> sClass = fetchStudents.parseResult(); //INSTANTED!
		//USE SCLASS WHEN MANIPULATING OR DISPLAYING DATA
//		calculateGPA();
			menuOptions(sClass);
		}
	
	private static void menuOptions(ArrayList<Student> sClass)
	{
		System.out.println("Select an option \n 1: Sort Students \n 2: Add or Delete a Student \n 3: Change a Student's Grades or Schedule");
		int option = userIntInput.nextInt();
		
		if(option > 3)
		{
			System.out.println("That's not an option!");	
			menuOptions(sClass);
		}
		
		if(option == 1) {
			sort(sClass);
		}
		if(option == 2) {
			addDelete(sClass);
		}
		if(option == 3) {
			changeDetails(sClass);
		}
	}

	private static String calculateGPA(Student student)
	{
	    DecimalFormat df = new DecimalFormat("0.##");

	    double totalGPA = 0;
	    String[] grades = {student.getGrade1(), student.getGrade2(), student.getGrade3()};

	    for (String grade : grades) {
	        switch (grade) {
	            case "A+":
	            case "A":
	                totalGPA += 4.0;
	                break;
	            case "A-":
	                totalGPA += 3.7;
	                break;
	            case "B+":
	                totalGPA += 3.3;
	                break;
	            case "B":
	                totalGPA += 3.0;
	                break;
	            case "B-":
	                totalGPA += 2.7;
	                break;
	            case "C+":
	                totalGPA += 2.3;
	                break;
	            case "C":
	                totalGPA += 2.0;
	                break;
	            case "C-":
	                totalGPA += 1.7;
	                break;
	            case "D+":
	                totalGPA += 1.3;
	                break;
	            case "D":
	                totalGPA += 1.0;
	                break;
	            default:
	                totalGPA += 0;
	                break;
	        }
	    }

	    double GPA = totalGPA / grades.length;

	    return df.format(GPA);
	}

	private static void changeDetails(ArrayList<Student> sClass)
		{
			System.out.println("Select an Option \n 1: Change a student's schedule \n 2: Change a student's grades \n 3: Switch two classes");
			int option = userIntInput.nextInt();
			if(option == 1) {
				System.out.println("Enter the last name of the student, whos schedule you want to change.");
				String lastName = userStringInput.nextLine();
				for(int i = 0; i < sClass.size(); i++)
				{
					if(sClass.get(i).getLastName().equals(lastName))
					{
						System.out.println("New period 1:");
						String per1 = userStringInput.nextLine();
						System.out.println("New period 2:");
						String per2 = userStringInput.nextLine();
						System.out.println("New period 3:");
						String per3 = userStringInput.nextLine();
						
						sClass.get(i).setPeriod1(per1);
						sClass.get(i).setPeriod2(per2);
						sClass.get(i).setPeriod3(per3);
						sClass.get(i).setGrade1("A+");
						sClass.get(i).setGrade2("A+");
						sClass.get(i).setGrade3("A+");
						
						System.out.println("Done!, " + sClass.get(i).getFirstName() + "'s schedule has been set!");

					}
				}
			}
			if(option == 2) {
				System.out.println("Enter the last name of the student, whos schedule you want to change.");
				String lastName = userStringInput.nextLine();
				for(int i = 0; i < sClass.size(); i++)
				{
					if(sClass.get(i).getLastName().equals(lastName))
					{
						System.out.println("Which period's grade do you want to change?");
						int period = userIntInput.nextInt();
						userIntInput.nextLine();
						if(period > 3)
						{
							System.out.println("Oops, that period doesn't exist.");
							menuOptions(sClass);
						}
						
						if(period == 1)
						{
							System.out.println("What do you want the new grade to be?");
							String newGrade = userStringInput.nextLine();
							sClass.get(i).setGrade1(newGrade);

						}
						if(period == 2)
						{
							System.out.println("What do you want the new grade to be?");
							String newGrade = userStringInput.nextLine();
							sClass.get(i).setGrade2(newGrade);

						}
						if(period == 3)
						{
							System.out.println("What do you want the new grade to be?");
							String newGrade = userStringInput.nextLine();
							sClass.get(i).setGrade3(newGrade);

						}
							
						System.out.println("Done!, " + sClass.get(i).getFirstName() + "'s new grade has been set!");

					}
				}
			}
			
			if(option == 3)
			{
				System.out.println("Enter the last name of the student, whos schedule you want to change.");
				String lastName = userStringInput.nextLine();

				for(int i = 0; i < sClass.size(); i++)
				{
					if(sClass.get(i).getLastName().equals(lastName))
					{
					System.out.println("What's the NAME OF the first period you want to switch with");
					System.out.println("Period 1: " + sClass.get(i).getPeriod1()  + ", Period 2: " + sClass.get(i).getPeriod2() + ", Period 3: " + sClass.get(i).getPeriod3());
					String period1 = userStringInput.nextLine();
					System.out.println("What's the NAME OF the second period you want to switch with");
					System.out.println("Period 1: " + sClass.get(i).getPeriod1()  + ", Period 2: " + sClass.get(i).getPeriod2() + ", Period 3: " + sClass.get(i).getPeriod3());
					String period2 = userStringInput.nextLine();
					sClass.get(i).swapPeriods(period1, period2);
					
					System.out.println("Done!, " + sClass.get(i).getFirstName() + "'s periods has been swapped!");
					System.out.println("Period 1: " + sClass.get(i).getPeriod1()  + ", Period 2: " + sClass.get(i).getPeriod2() + ", Period 3: " + sClass.get(i).getPeriod3());
					}
				}
			}
			
			menuOptions(sClass);
			
		}

	private static void addDelete(ArrayList<Student> sClass)
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
				sClass.add(new Student(firstName, lastName, period1, period2, period3, grade1, grade2, grade3));
				
				System.out.println("Added " + firstName + " " + lastName);
				
				menuOptions(sClass);

			}
			if(option == 2) {
				System.out.println("Enter the last name of the student you would like to remove");
				for(Student s : sClass)
				{
					System.out.println(s.getFirstName() + " " + s.getLastName());
				}
				String lastName = userStringInput.nextLine();
				for(Student s : sClass)
				{
					if(s.getLastName().equals(lastName))
					{
						sClass.remove(s);
						System.out.println("Removed " + s.getFirstName() + " " + s.getLastName());
						break;
					}
				}
				menuOptions(sClass);
			}
		}

	private static void sort(ArrayList<Student> sClass)
		{
			System.out.println("Select an Option \n 1: Sort by last name \n 2: Sort by GPA \n 3: Sort by period");
			int option = userIntInput.nextInt();
			if(option > 3)
			{
				System.out.println("That's not an option!");	
				menuOptions(sClass);
			}
			if(option == 1) {
				ArrayList<Student> sClassDupe = sClass;
				//sort by name
		        Collections.sort(sClassDupe, new Comparator<Student>() {
		            @Override
		            public int compare(Student p1, Student p2) {
		                return p1.getLastName().compareTo(p2.getLastName());
		            }
		        });
		        System.out.println("Here's the class, sorted by last name!");
		        for(Student s : sClassDupe)
		        {
		        	System.out.println(s.getFirstName() + " " + s.getLastName());
		        }
			}
			if(option == 2) {
				ArrayList<Student> sClassDupe = sClass;
				//sort by name
		        Collections.sort(sClassDupe, new Comparator<Student>() {
		            @Override
		            public int compare(Student p1, Student p2) {
		            	int ageComparison = Double.compare(Double.parseDouble(calculateGPA(p2)), Double.parseDouble(calculateGPA(p1)));		                if (ageComparison != 0) {
		                    return ageComparison;
		                } else {
		                    return p1.getLastName().compareTo(p2.getLastName());
		                }
		            }
		        });
		        System.out.println("Here's the class, sorted by GPA!");
		        for(Student s : sClassDupe)
		        {
		        	System.out.println(calculateGPA(s) + " - " + s.getFirstName() + " " + s.getLastName());
		        }
			}
			if(option == 3) {
				//sort by period
				System.out.println("Which period would you like to sort by?");
				int period = userStringInput.nextInt();
				ArrayList<Student> sClassDupe = sClass;
				
				if(option > 3)
				{
					System.out.println("That's not an option!");	
					menuOptions(sClass);
				}
				
				if(period == 1)
				{
			        Collections.sort(sClassDupe, new Comparator<Student>() {
			            @Override
			            public int compare(Student p1, Student p2) {
			            	return p1.getPeriod1().compareTo(p2.getPeriod1());
			            }
			        });
					
			        for(Student s : sClassDupe)
			        {
			        	System.out.println(s.getPeriod1() + " - " + s.getFirstName() + " " + s.getLastName());
			        }	
				}
				if(period == 2)
				{
			        Collections.sort(sClassDupe, new Comparator<Student>() {
			            @Override
			            public int compare(Student p1, Student p2) {
			            	return p1.getPeriod2().compareTo(p2.getPeriod2());
			            }
			        });
					
			        for(Student s : sClassDupe)
			        {
			        	System.out.println(s.getPeriod2() + " - " + s.getFirstName() + " " + s.getLastName());
			        }	
				}
				if(period == 3)
				{
			        Collections.sort(sClassDupe, new Comparator<Student>() {
			            @Override
			            public int compare(Student p1, Student p2) {
			            	return p1.getPeriod3().compareTo(p2.getPeriod3());
			            }
			        });
					
			        for(Student s : sClassDupe)
			        {
			        	System.out.println(s.getPeriod3() + " - " + s.getFirstName() + " " + s.getLastName());
			        }	
				}

			}
			
			menuOptions(sClass);
			
		}

}
