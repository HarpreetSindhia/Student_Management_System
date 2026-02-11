package com.studentapp;

public class Main {

	public static void main(String[] args) {
		
		Student s1 =	new Student("Harpreet" , 31, "S-112");
		Student s2 =	new Student("Amandeep" , 33 , "S-114");
		Student s3 =	new Student("Navdeep" , 27 , "S-117");
		
		s1.enrollCourse("Java");
		s1.enrollCourse("DSA");
		s1.enrollCourse("DevOps");
		
		s2.enrollCourse("DSA");
		s2.enrollCourse("Java");
		
		s3.enrollCourse("Java");
		
		s1.printStudentInfo();
		
		s2.printStudentInfo();

		s3.printStudentInfo();
		

	}

}
 