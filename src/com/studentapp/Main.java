package com.studentapp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class StudentNotFoundException extends Exception
{
	private static final long serialVersionUID = 1L;
	
	public StudentNotFoundException(String message)
	{
		super(message);
	}
}


public class Main {

	private static List<Student> studentList; // List<Student>
	
	private static Scanner scanner;
	
	public static void main(String[] args) {
		
		studentList =	new ArrayList<>();
		
		while(true)
		{
		System.out.println("-------Welcome-------");
		System.out.println("=====Select an option=====");
		System.out.println("1 : Register a student");
		System.out.println("2 : Find Student with StudentID");
		System.out.println("3 : List all the Student information");
		System.out.println("4 : List all the Student information in sorted order");
		System.out.println("5 : Exit");
		
		scanner =	new Scanner(System.in);
		
		int option =	scanner.nextInt();
		
		//Switch case is used when we have to make a choice between alternate options
		
		switch(option)
		{
		case 1: enrollStudent(scanner);
			break;
			
		case 2: findStudentByID(scanner);
			break;
			
		case 3: printStudentInfo();
			break;
			
		case 4: sortByName();
			break;
			
		case 5: exit();
			break;
			
		default :
		
			System.out.println("Invalid case !!! please select between 1 - 5");
		}
		
		
		}
	}
	
	private static void exit() {
		
		System.out.println("********GoodBye********");
		
		System.exit(0);
		
	}

	private static void printStudentInfo() {
		
		if(studentList.size() > 0)
		{
			System.out.println(".....Printing Student Data.....");
			for(Student student : studentList)
			{
				student.printStudentInfo();
			}
		
		}
		else
		{
			System.out.println("*******StudentList is empty !!!! No record found*******");
		}
	}

	private static void findStudentByID(Scanner scanner2) {
		
		System.out.println("Enter Student ID : ");
		
		String studentID =	scanner2.next();
		
		Student studentFound = null;
		
		try
		{
			studentFound =	studentList.stream().filter(student -> student.getStudentID().equalsIgnoreCase(studentID)).findFirst().
			orElseThrow(() -> new StudentNotFoundException("Student with ID " + studentID + " not found"));
		}
		catch(StudentNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
		
		studentFound.printStudentInfo();
		
	}

	private static void enrollStudent(Scanner scanner2) {
		
		
			System.out.println("========Welcome========");
			System.out.println("------Printing Student Information------");
			System.out.println("Enter student name : ");
			String studentName =	scanner2.next();
			System.out.println("Enter student Age : ");
			int studentAge =	scanner2.nextInt();
			System.out.println("Enter student ID");
			String studentID =	scanner2.next();
			
			//Create a Student object
			
			Student newStudent =	new Student(studentName , studentAge , studentID);
			
			//Add new Student to studentList
			
			studentList.add(newStudent);
			
			while(true)
			{
				
			
			System.out.println("Enter the course to be enrolled Type done to exit");
			
			String courseName =	scanner2.next();
			
			if(courseName.equalsIgnoreCase("done"))
			{
				break;
			}
			
			newStudent.enrollCourse(courseName);
			
			}
			newStudent.printStudentInfo();	
		
	}
	
	
	private static void sortByName()
	{
		studentList.sort(Comparator.comparing(Student::getName));
		
		printStudentInfo();
	}

	

}
 