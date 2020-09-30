package com.example.intro;

/*
 * There are four scopes in java
 * 
 * 		static (class) this variable will be the same for all instances of the object
 * 		instance (object) this variable will be different for each instance of the object. 
 * 		method
 * 		block (local, loop)	
 * 
 * where does the variable/method die? this determines scope
 * 
 */

public class Scopes {
	
	static String cat = "kitty"; //static scope
	String cat1 = "cat1";		// instance scope

	public static void main(String[] args) {
		boolean test = true; // method scope
		int x =5 ;
		
		if(test) {
			//int x = 4; // block scope
		}
		
		//System.out.println(x);

	}

}
