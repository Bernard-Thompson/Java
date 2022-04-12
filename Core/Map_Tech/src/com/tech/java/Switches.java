package com.tech.java;

public class Switches {

	
	public static void main(String args[]) {
		Switches triangle = new Switches();
		triangle.calculateShapeArea();
		
	}
	
	int numberOfSides;
	int sideLength;
	
	
	public void calculateShapeArea() {
		int numberOfSides  = 3 ;
		int sideLength = 12;
		
		int area = (int) (0.5 * numberOfSides * sideLength);
		
		System.out.println("The total area is " + area + " !");
		
	}
}
   