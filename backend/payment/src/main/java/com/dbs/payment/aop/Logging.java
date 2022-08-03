package com.dbs.payment.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logging {
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(Logging.class);	
	@Around("execution(* com.dbs.payment.service.*.*(..))")
	public Object getInformation(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		String method = theProceedingJoinPoint.getSignature().toShortString();
		log.info("\n=====>>> Executing @Around on method: " + method);
		long begin = System.currentTimeMillis();
		Object result = null;
		try {
			result = theProceedingJoinPoint.proceed();
		} catch (Exception exception) {
			// log the exception
			log.warn(exception.getMessage());
			return exception;
		}
		long end = System.currentTimeMillis();
		long duration = end - begin;
		log.info("\n=====> Duration: " + duration / 1000.0 + " seconds");
		return result;

	}
}
