package com.lgy.spring_test;

public class MyEvenNumber {
	private EvenNumber evenNumber;
	int n;
	
	public void pc() {
		evenNumber.process(n);
	}

	public EvenNumber getEvenNumber() {
		return evenNumber;
	}

	public void setEvenNumber(EvenNumber evenNumber) {
		this.evenNumber = evenNumber;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}
	
	
}
