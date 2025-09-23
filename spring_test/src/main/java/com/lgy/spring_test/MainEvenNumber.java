package com.lgy.spring_test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainEvenNumber {
	String configLoc = "classpath:evenNumberCTX.xml";
	AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLoc);
	MyEvenNumber myEvenNumber = ctx.getBean("myEvenNumber", MyEvenNumber.class);
	myEvenNumber.pc();
}
