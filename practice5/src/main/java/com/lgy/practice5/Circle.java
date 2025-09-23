package com.lgy.practice5;

public class Circle {
	private double radius;
	
	public void process () {
		System.out.println(radius*radius*3.14);
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public Circle(double radius) {
		super();
		this.radius = radius;
	}
	
	
}
