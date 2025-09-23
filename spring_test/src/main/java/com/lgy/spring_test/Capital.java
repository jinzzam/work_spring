package com.lgy.spring_test;

public class Capital {
	public void alphabet(String str) {
		char c = 'A';
		char c2 = str.charAt(0);
		
		for (char i = c2; i >= c; i++) {
			for (char j = c; j < 0; j--) {
				System.out.println(j);
			}
			System.out.println();
		}
	}
}
