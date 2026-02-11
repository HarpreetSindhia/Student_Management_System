package com.studentapp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class StudentNotFoundException extends Exception
{
	private static final long serialVersionUID = 1L;
	public StudentNotFoundException(String message)
	{
		super(message);
	}
}


public class Main2 {

	private static List<Student> studentList; // List<Student>
	
	public static void main(String[] args) {
		
		studentList =	new ArrayList<>();
		
		Student s1 =	new Student("Harpreet" , 31, "S-112"); //Student Object
		Student s2 =	new Student("Amandeep" , 33 , "S-114");
		Student s3 =	new Student("Navdeep" , 27 , "S-117");
		
		s1.enrollCourse("Java");//Student enrolled to courses
		s1.enrollCourse("DSA");
		s1.enrollCourse("DevOps");
		
		s2.enrollCourse("DSA");
		s2.enrollCourse("Java");
		
		s3.enrollCourse("Java");
		
		s1.printStudentInfo();
		
		
		
		studentList.add(s1);//Add student objects to studentList
		studentList.add(s2);
		studentList.add(s3);
		
		
		Student result =	findStudentByID("S-117");
		
		result.printStudentInfo();
		
		sortByName();
		

	}
	
	private static Student findStudentByID(String studentID)
	{
		Student	studentFound = null;
		
		try
		{
			studentFound =	studentList.stream().filter(student -> student.getStudentID().equalsIgnoreCase(studentID)).findFirst()
			.orElseThrow(() -> new StudentNotFoundException("Student with ID " + studentID + " not found"));
			
			System.out.println("------------Student record found for ID :------------ " + studentID);
		}
		catch(StudentNotFoundException e)
		{
			System.err.println(e.getMessage());
		}
		
		return studentFound;
	}
	
	
	private static void sortByName()
	{
		studentList.sort(Comparator.comparing(Student::getName));
		
		System.out.println(studentList);
	}

	

}
 