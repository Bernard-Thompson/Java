package com.tech.java.day2;

import java.util.Scanner;

public class Loops {

	public static void main(String args[]) {
		Loops loop = new Loops();
		
		loop.multi();
		
	}
	
	int b;
	int a;
	int e;
	int o;
	
	Scanner ans;
	
	public void multi() {
		ans = new Scanner(System.in);
		System.out.println("Number to be used ?");
		b = ans.nextInt();
		
		for (int i = 0; i <= 4; i++) {
			b = b + i;
			System.out.println(b );
		}
	}
	
	/*
	 * 2) Create a program to find out the list of even and odd numbers from 10 numbers entered by user
	 */
	
	public void eveodd() {
		ans = new Scanner(System.in);
		
		
		
		for(int i = 0; i <=9 ; i++) {
			
			System.out.println("Please enter a number to compare: ");
			e = ans.nextInt();
			
		}
	}
	
	
}
