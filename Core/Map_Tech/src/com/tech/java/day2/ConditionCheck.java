package com.tech.java.day2;

import java.util.Scanner;

public class ConditionCheck {

	
	public static void main (String args[]) {
		ConditionCheck numb = new ConditionCheck();
		//numb.maxNum();
		numb.checkSalary();
	}
	
	int b;
	int a;
	int m;
	
	Scanner ans;
	
	public void maxNum () {
		ans = new Scanner(System.in);
		
		System.out.println("What is the first number to be checked?");
		b = ans.nextInt();
		
		System.out.println("What is the Second number to be checked?");
		a = ans.nextInt();
		
		System.out.println("What is the third number to be checked?");
		m = ans.nextInt();
		
		if (b > a && b > m) {
			System.out.println("The greater number is " + b);
		} else if (a > b && a >  m) {
			System.out.println("The greater number is " + a);
			}else if (m > a && m > b) {
				System.out.println("The greater number is " + m);
			}else {
				System.out.println("Max number can't be found");
			}
		
	}
	
	int yos;
	
	String empl;
	double payRate;
	
	
	
	
	public void checkSalary() {
		ans = new Scanner(System.in);
		System.out.println("Enter your name");
		empl = ans.next();
		
		System.out.println("Enter the number of year of service");
		yos = ans.nextInt();
		
		System.out.println("Enter your current salary");
		payRate = ans.nextDouble();
		
		double bonus = payRate *.05;
		
		if (yos >= 5 ) { 
			System.out.println(empl + " will recive a bonus of " + bonus);
			System.out.println(empl + " your new salary will be " + bonus + payRate);
		} else {
			System.out.println("I'm sorry " + empl + " you do not yet qualify for a bonus.");
		}
	}
}
