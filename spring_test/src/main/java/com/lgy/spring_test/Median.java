package com.lgy.spring_test;

import java.util.Scanner;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Median {
	int a, b, c;
	
	public int process(int a, int b, int j) {
		if (((a<b && a>c)||(a>b && a<c))) {
			System.out.println("입력된 정수가 "+a+"와"+b+"와"+c+"의 중간값은 "+a);
		} else if ((b<a && b>c)||(b<c && b>a)){
			System.out.println("입력된 정수가 "+a+"와"+b+"와"+c+"의 중간값은 "+b);
		} else if ((c<a && c>b)||(c<b && c<a)) {
			System.out.println("입력된 정수가 "+a+"와"+b+"와"+c+"의 중간값은 "+c);
		}
		
		String configLocation = "classpath:applicationCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		MyMedian myMedian = ctx.getBean("myMedian", MyMedian.class);
		
		
		return median;
	}
}
