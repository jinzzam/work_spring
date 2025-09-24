package com.lgy.spring_6_1;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		String configLoc1 = "classpath:applicationCTX1.xml";
		String configLoc2 = "classpath:applicationCTX2.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLoc1, configLoc2);
//		홍길동 객체 정보 가져옴
		Student student1 = ctx.getBean("student1", Student.class);
		System.out.println(student1.getName());
		System.out.println(student1.getHobbys());
		
		StudentInfo studentInfo = ctx.getBean("studentInfo1", StudentInfo.class);
		Student student2 = studentInfo.getStudent();
		
		System.out.println(student2.getName());
		System.out.println(student2.getHobbys());
		
		if(student1.equals(student2)) {
			System.out.println("같다");
		}else {
			System.out.println("다르다");
		}
		
		Student student3 = ctx.getBean("student3", Student.class);
		System.out.println(student3.getName());
		System.out.println(student3.getHobbys());
		if(student1.equals(student3)) {
			System.out.println("같다");
		}else {
			System.out.println("다르다");
		}

		Family family= ctx.getBean("family", Family.class);
		System.out.println(family.getPapaName());
		System.out.println(family.getMamiName());
		System.out.println(family.getSisterName());
		System.out.println(family.getBrotherName());
		if(student1.equals(student3)) {
			System.out.println("같다");
		}else {
			System.out.println("다르다");
		}

		
		//		자원반납
		ctx.close();
	}
}
