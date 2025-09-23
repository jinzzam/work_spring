package com.lgy.spring_test;

public class MyMedian {
	private Median median;
	int a, b, c;

	public void pc() {
		median.process(a, b, a);
	}
	
	public Median getMedian() {
		return median;
	}

	public void setMedian(Median median) {
		this.median = median;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}
}
