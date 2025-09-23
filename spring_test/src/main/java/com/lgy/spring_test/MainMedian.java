package com.lgy.spring_test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class MainMedian {
	public static void main(String[] args) {
		String configLoc = "classpath:medianCTX.xml";
		AbstractApplicationContext ctx = new GenericApplicationContext(configLoc);
		MyMedian myMedian = ctx.getBean("myMedian", MyMedian,class);
		myMedian.pc();
	}
}
