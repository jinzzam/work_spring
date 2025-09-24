package com.lgy.spring_7_1;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
//		스프링 설정(xml 스프링 설정 파일 로딩)
		ctx.load("classpath:applicationCTX.xml");
//		새로고침(설정 반영) : 생략해도 객체 정보 출력에는 문제 없음
//		ctx.refresh();
		Student student = ctx.getBean("student", Student.class);
		
		System.out.println("이름 : "+student.getName());
		System.out.println("나이 : "+student.getAge());
		
		ctx.close();
	}
}
