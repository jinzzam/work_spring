package com.lgy.practice_8_1;

import org.aspectj.lang.ProceedingJoinPoint;

public class LogAop {
	public Object loggerAop(ProceedingJoinPoint joinPoint) {
//		getSignature().toShortString() : 핵심기능 클래스의 메소드 정보를 가져옴
		String signatureStr = joinPoint.getSignature().toShortString();
//		핵심기능이 start 되었다. (공통기능 실행(advice))
		System.out.println("@@@### start===>" + joinPoint.getSignature().toShortString());
		long st = System.currentTimeMillis();
		Object obj = null;
		
		try {
//			핵심기능 실행
			obj = joinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			System.out.println("@@@### end===>" + joinPoint.getSignature().toShortString());
		}
//		핵심기능 반환
		return obj;
	}
}
