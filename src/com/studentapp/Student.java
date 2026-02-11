package com.studentapp;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {
	
	//Instance Variables are always marked as private to avoid the illegal value assignment
	
	private String name;
	
	private int age;
	
	private String studentID;
	
	private List<String> courses;
	
	//Constructor
	
			public Student(String name , int age , String studentID)
			{
				//Value of local variable(name , age , studentID) will be assigned to the instance variables
				
				//this keyword refers to the instance variable
				
				if(validateName(name) && validateAge(age) && validateStudentId(studentID) )
				this.name = name;//Intialization of instance variables
				this.age = age;
				this.studentID = studentID;
				courses =	new ArrayList<String>();//Initilization of courses
			}
			
			//Getters
			
			public String getName()
			{
				return name;
			}
			
			public int getAge()
			{
				return age;
			}
			
			public String getStudentID()
			{
				return studentID;
			}
			
			public List<String> getCourses()
			{
				return courses;
			}
			
			public void enrollCourse(String course)
			{
				//Validation checks -> Valid course and No duplicate course
				
				if(validateCourseName(course))
				{
					if(!courses.contains(course))//If list does not contain that course then add that course to the courses list
					{
						courses.add(course);
						
						System.out.println("Sudent enrolled to the " +course+ " successfully");
					}
				
					else
					{
					System.err.println("Student already enrolled to this course");
					}
				}
				
			}
			
			public void printStudentInfo()
			{
				System.out.println("======Student Information======");
				System.out.println("Student Name : " + name);  
				System.out.println("Student age : " + age);
				System.out.println("Student ID : " + studentID);
				System.out.println("Student Enrolled courses : " + courses);
				System.out.println();
			}
			
			public String toString()
			{
				return String.format("name : %s , age : %d , studentID : %s , courses : %s", name , age , studentID , courses);
			}
			
			
			//Validation checks for the instance variables and they need to be called inside constructor
			
			public Boolean validateName(String name)
			{
				
				//String needs to be a certain format
				String nameRegex =	"^[a-zA-Z\\s]+$";//Regular Expression
				
				Pattern namePattern =	Pattern.compile(nameRegex);//Pattern class
				
				Matcher nameMatcher =	namePattern.matcher(name);
				
				if(nameMatcher.matches())
				{
					return true;
				}
				else
				{
					System.err.println("Invalid Name , please enter alphabets only");
					
					return false;
				}
					
			}
			
			public Boolean validateAge(int age)
			{
				if(age >= 19 && age <= 35)
					
				{
					return true;
				}
				
				else
				{
					System.err.println("Invalid age , age must be between 19 and 35");
					
					return false;
				}
			}
			
			public Boolean validateStudentId(String studentID)
			{
				//String needs to be of a certain format
				
				String studentIDRegex =	"S-\\d+$";//Regular Expression
				
				Pattern studentIDPattern =	Pattern.compile(studentIDRegex); //Pattern Class
				
				Matcher studentIDMatcher =	studentIDPattern.matcher(studentID);
				
				if(studentIDMatcher.matches())
				{
					return true;
				}
				else
				{
					System.err.println("Invalid ID, please enter digits only ");
					
					return false;
				}
				
				
				
			}
			
			
			
			//Validate courseName
			
			public Boolean validateCourseName(String course)
			{
				if(course.equalsIgnoreCase("Java") || course.equalsIgnoreCase("DSA") || course.equalsIgnoreCase("DevOps"))
				{
					return true;
				}
				else
				{
					System.err.println("Invalid course!!!! please select from the valid course Java , DSA , DevOps");
					
					return false;
				}
			}
			
			

	public static void main(String[] args) {
		

		
	}

}
