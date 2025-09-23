package com.lgy.spring_test;

public class EvenNumber {
	public void process(int n) {
		int sum=0;
		for(int i=1; i<=n; i++) {
			if(i%2==0) {
				sum+=i;
			}
		}
		System.out.println(n + "까지 짝수 합은 : " + sum);
	}
}
