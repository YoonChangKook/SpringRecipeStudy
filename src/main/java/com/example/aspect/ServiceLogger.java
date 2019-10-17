package com.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * LoggingRequired 애노테이션이 붙은 메서드에 로깅해주는 클래스
 *
 * @see LoggingRequired
 * @author 국윤창
 */
@Aspect
@Component
public class ServiceLogger {
	private static final Logger LOGGER = LoggerFactory.getLogger(ServiceLogger.class);

	@Before("@annotation(com.example.aspect.LoggingRequired)")
	public void before(JoinPoint joinPoint) {
		LOGGER.info("The {} function {} begins with {}.", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), joinPoint.getArgs());
	}
}
