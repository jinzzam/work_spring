package com.lgy.practice_8_1;

import org.springframework.context.support.GenericXmlApplicationContext;


public class MainClass {
	public static void main(String[] args) {
GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		
		Professor professor = ctx.getBean("professor", Professor.class);

		professor.getProfessorInfo();

		Singer singer = ctx.getBean("singer", Singer.class);

		singer.getSingerInfo();
		
		ctx.close();
	
	}
}
