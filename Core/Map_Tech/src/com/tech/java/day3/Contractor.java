package com.tech.java.day3;

public class Contractor extends Employee{
	public static void main(String args[]) {
		Contractor jones = new Contractor();
		jones.accept();
		jones.display();
	}
	
	double contract;
	int duration;
	
	@Override
	public void accept() {
		super.accept();
		System.out.println("Enter the Contract amount: ");
		contract = sc.nextDouble();
		
		System.out.println("Enter the contract duration: ");
		duration = sc.nextInt();
	}
	
	@Override
	public void display()
	{
		//System.out.println("Contractor id is "+empid);
		//System.out.println("Contractor name is "+empname);
		System.out.println("Contractor payrate " + contract);
		System.out.println("Contractor duration will be for " + duration + " months.");
	}
}
