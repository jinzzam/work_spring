package com.lgy.practice5;

public class CircleInfo {
	private Circle circle;

	public CircleInfo(Circle circle) {
		this.circle = circle;
	}

	public void getCircleInfo() {
		if(circle != null) {
			System.out.println(circle.getRadius());
			circle.process();
		}
	}

	public void setCircle(Circle circle) {
		this.circle = circle;
	}
	
}
