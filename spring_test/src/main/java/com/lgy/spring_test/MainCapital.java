package com.lgy.spring_test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainCapital {
	public static void main(String[] args) {
		String configLoc = "classpath:capitalCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLoc);
		MyCapital myCapital = ctx.getBean("myCapotal", MyCapital.class);
		myCapital.alpha();
	}
}
