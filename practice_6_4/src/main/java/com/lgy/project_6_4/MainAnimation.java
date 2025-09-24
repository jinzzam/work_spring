package com.lgy.project_6_4;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class MainAnimation {
	public static void main(String[] args) {
		String configLoc1 = "classpath:animationCTX.xml";
		String configLoc2 = "classpath:animationCTX2.xml";
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLoc1, configLoc2);
		Animation animation1 = ctx.getBean("animation1", Animation.class);
		System.out.println(animation1.getTitle());
		System.out.println(animation1.getMadeIn());
		System.out.println(animation1.getMember());
		System.out.println("=======================");
		AnimationInfo animationInfo= ctx.getBean("animationInfo1", AnimationInfo.class);
		Animation animation2 = animationInfo.getAnimation();
		System.out.println(animation2.getTitle());
		System.out.println(animation2.getMadeIn());
		System.out.println(animation2.getMember());
		System.out.println("=======================");
		Animation animation3 = ctx.getBean("animation3", Animation.class);
		System.out.println(animation3.getTitle());
		System.out.println(animation3.getMadeIn());
		System.out.println(animation3.getMember());
		System.out.println("=======================");
	
	}
}
