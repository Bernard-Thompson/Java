package com.tech.java.day3;

public class Childobj extends Inheritance {
	
	public static void main (String args[]) {
		Inheritance p = new Inheritance();
		p.base();
		Childobj c = new Childobj();
		c.base();
		c.cue();
	}
	
	public void cue() {
		System.out.println("Hello this is the child object");
	}
	
}
