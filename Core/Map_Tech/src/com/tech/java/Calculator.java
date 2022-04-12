package com.tech.java;

import java.util.Scanner;

public class Calculator {


	
	
	
	public static void main (String args[]) {
	
		Calculator calc = new Calculator();
		calc.confirm();
		calc.add();
		calc.sub();
		calc.mult();
		
	
	}
	
	int x;
	int y;
	Scanner ans;
	
	public void confirm() {
		
		ans = new Scanner(System.in);
		System.out.println("Enter the fitrst number ");
		x = ans.nextInt();
		
		System.out.println("Enter the Second number ");
		y = ans.nextInt();
	}
	
	public void add() {
		int adds = x + y;
		System.out.println("When added together the total is " + adds + " !");
	}
	

	
	public void sub() {
		int subs = x - y;
		System.out.println("subtracting the numbers gives us " + subs + " !");
	}
	
	public void mult() {
		int mults = x * y;
		System.out.println("Multiplying the numbers together gives us " + mults+ " !");
	}
	
}
