package com.lgy.spring_9_1;

import org.aspectj.lang.ProceedingJoinPoint;

//공통 기능 클래스(Aspect)
public class LogAop {
//	loggerAop : advice (공통기능 자체-메소드)
//	joinPoint : 핵심기능(공통기능이 적용되는 대상 - 메소드)
	public Object loggerAop(ProceedingJoinPoint joinPoint) {
//		getSignature().toShortString() : 핵심기능 클래스의 메소드 정보를 가져옴
		String signatureStr = joinPoint.getSignature().toShortString();
//		핵심기능이 start 되었다. (공통기능 실행(advice))
		System.out.println(signatureStr + "is start.");
		long st = System.currentTimeMillis();
		Object obj = null;
		
		try {
//			핵심기능 실행
			obj = joinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			long et = System.currentTimeMillis();
			System.out.println(signatureStr + "is finished.");
			System.out.println(signatureStr + "의 경과시간 : " + (et-st));
		}
//		핵심기능 반환
		return obj;
	}
}
