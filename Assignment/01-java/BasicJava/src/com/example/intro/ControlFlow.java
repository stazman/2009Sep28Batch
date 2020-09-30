package com.example.intro;

/*
 * 
 * we can control our application's decision making during runtime by using
 * 		control flow statements
 */

public class ControlFlow {
	
	public static void main(String[] args) {
		boolean test = true;
		boolean another = true;
		String something = "something";
		
		//if statement
		if(test) {
			System.out.println("true");
		}
		
		//if else statement
		if(test) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
		
		//if else if statement
		if(test) {
			System.out.println("true");
		} else if(another) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
		
		//switch statement
		switch(something) {
		case "something":
			System.out.println("it was something after all");
			break; //prevents fall through
		case "else":
			System.out.println("it was actually else");
		default: // runs if it doesn't' match the cases
			System.out.println("wasn't something else");
		}
		
		//loops
		
		//for loop
		//for(initialization;condition;incrementation){body} these parameters are optional, you can just have for(;;)
		for(int i= 0;i<10;i++) {
			if(i==4) {
				//break; breaks out of the loop completely
				//continue; skips to the next iteration of the loop
			}
			System.out.println(i);
		}
		
		//while
		int x = 7;
		while(x<=10) {
			System.out.println("here we go again");
			x+=1;
		}
		
		
		//do while
		do {
			System.out.println("doing the thing");
			x+=1;
		} while(test);
		
		
	}

}
