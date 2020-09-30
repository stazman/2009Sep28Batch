package com.example.oop.inheritance;

public class Parent {
	
	//static block
	static {
		System.out.println("in the parent static block");
	}
	
	
	
	//instance block
		{
			System.out.println("in the parent instance block");
		}
		
	
	public int age = 30;
	private String firstName;
	private String lastName;
	private double height;
	
	public Parent(int age, String firstName, String lastName, double height) {
		super();
		this.age = age;
		this.firstName = firstName;
		this.lastName = lastName;
		this.height = height;
	}
	
	
	public Parent() {
		System.out.println("Parent Constructor");
	
	}
	
	
	public int getAge() {
		return age;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public double getHeight() {
		return height;
	}
	private void setAge(int age) {
		this.age = age;
	}
	private void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	private void setLastName(String lastName) {
		this.lastName = lastName;
	}
	private void setHeight(double height) {
		this.height = height;
	}
	
	
	

}
