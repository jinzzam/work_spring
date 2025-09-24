package com.lgy.spring_7_2;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:applicationCTX.xml");
		//@#%$ afterPropertiesSet()
		//@#%$ initMethod()
		ctx.refresh();
		
		//@#%$ destroyMethod()
		//@#%$ destroy()
		ctx.close();
	}
}
//최종순서
//@#%$ afterPropertiesSet()
//@#%$ initMethod()
//@#%$ destroyMethod()
//@#%$ destroy()