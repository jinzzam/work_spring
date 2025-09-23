package com.lgy.spring_5_1;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		String configLoc = "classpath:application.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLoc);
		StudentInfo studentInfo = ctx.getBean("studentInfo", StudentInfo.class);
		studentInfo.getStudentInfo();
	
		Student student2 = ctx.getBean("student2", Student.class);
		studentInfo.setStudent(student2);
		studentInfo.getStudentInfo();
		
//		자원반납
		ctx.close();
	}
}
