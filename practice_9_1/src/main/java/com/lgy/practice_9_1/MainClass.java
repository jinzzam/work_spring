package com.lgy.practice_9_1;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class MainClass {
	public static void main(String[] args) {
		String configLoc = "classpath:applicationCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLoc);
		
		Car car = ctx.getBean("car", Car.class);
		car.getCarInfo();
//		System.out.println(car.getStock());
//		System.out.println(car.getCapRank());
//		System.out.println(car.getProduct());
		
		Graphic graphic = ctx.getBean("graphic", Graphic.class);
		graphic.getGraphicInfo();
//		System.out.println(graphic.getStock());
//		System.out.println(graphic.getCapRank());
		
	}
}
