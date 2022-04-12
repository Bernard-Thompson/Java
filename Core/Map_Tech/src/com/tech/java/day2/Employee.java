package com.tech.java.day2;

import java.util.Scanner;

public class Employee {
	
	public static void main(String args[]) {
		Employee David = new Employee();
		David.accept();
		David.display();
	}
	
	int emplId;
	String emplName;
	Scanner sc;
	double salary;
	
	public void accept() {
		sc = new Scanner(System.in); //Taking keyboard input 
		
		System.out.println("Enter employee id ");
		emplId =sc.nextInt();
		
		System.out.println("Enter employye Name ");
		emplName = sc.next();
		
		System.out.println("Enter salary");
		salary = sc.nextDouble();
		
	}
	
	public void display() {
		System.out.println("Employee ID is " + emplId);
		System.out.println("Employee Name is " + emplName);
		System.out.println("Employee Salary is" + salary );
	}
}
