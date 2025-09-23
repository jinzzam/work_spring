package com.lgy.spring_test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainRectangle {
	public static void main(String[] args) {
		String configLoc = "classpath:rectangleCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLoc);
		MyRe
	}
}
