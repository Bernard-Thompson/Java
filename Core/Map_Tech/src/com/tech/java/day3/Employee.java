package com.tech.java.day3;

import java.util.Scanner;

public class Employee {

	private int empid;
	private String empname;
	protected Scanner sc;//I dont want to declare scanner again and again.
	public Employee()
	{
		sc=new Scanner(System.in);
	}
	public void accept()
	{
		System.out.println("Enter Employee id ");
		empid=sc.nextInt();
		System.out.println("Enter Employee name ");
		empname=sc.next();
	}
	public void display()
	{
		System.out.println("Employee id is "+empid);
		System.out.println("Employee name is "+empname);
	}
	
}
