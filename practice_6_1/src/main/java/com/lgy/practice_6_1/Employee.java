package com.lgy.practice_6_1;

import java.util.ArrayList;

public class Employee {
	private String name;
	private int salary;
	private ArrayList<String> identify;
	public String getName() {
		return name;
	}
	
	public Employee(String name) {
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public ArrayList<String> getIdentify() {
		return identify;
	}
	public void setIdentify(ArrayList<String> identify) {
		this.identify = identify;
	}
	public Employee(String name, int salary, ArrayList<String> identify) {
		this.name = name;
		this.salary = salary;
		this.identify = identify;
	}
	
	
}
