package com.lgy.practice_9_1;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogAop {
	@Pointcut("within(com.lgy.practice_9_1.*)")
	public void pointcutMethod() {
		
	}
	
	@Around("pointcutMethod()")
	public Object loggerAop(ProceedingJoinPoint joinPoint) {
		String signatureStr = joinPoint.getSignature().toShortString();
		System.out.println("@@@### start===>" + signatureStr);
		Object obj = null;
		
		try {
			obj = joinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			System.out.println("@@@### end===>" + signatureStr);
		}
		return obj;
	}
}
