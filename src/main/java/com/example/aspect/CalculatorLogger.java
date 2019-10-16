package com.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 계산기 앞뒤로 로깅하도록 도와주는 클래스
 *
 * @author 국윤창
 */
@Aspect
@Component
public class CalculatorLogger {
	private static final Logger LOGGER = LoggerFactory.getLogger(CalculatorLogger.class);

	@Before("execution(* com.example.service.Calculator.*(..))")
	public void before(JoinPoint joinPoint) {
		LOGGER.info("The calculator function {} begins with {}", joinPoint.getSignature().getName(), joinPoint.getArgs());
	}
}
