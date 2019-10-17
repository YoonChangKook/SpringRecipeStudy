package com.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 계산기 앞뒤로 로깅하도록 도와주는 클래스
 *
 * @author 국윤창
 */
@Aspect
@Component
@Order(1)
public class CalculatorLogger {
	private static final Logger LOGGER = LoggerFactory.getLogger(CalculatorLogger.class);

	/**
	 * 계산기 메서드가 실행되기 전 호출된다.
	 *
	 * @param joinPoint 호출된 메서드 정보
	 */
	@Before("execution(* com.example.service.Calculator.*(..))")
	public void before(JoinPoint joinPoint) {
		LOGGER.info("The calculator function {} begins with {}.", joinPoint.getSignature().getName(), joinPoint.getArgs());
	}

	/**
	 * 계산기 메서드가 반환된 후 호출된다.
	 *
	 * @param joinPoint 호출된 메서드 정보
	 * @param result 메서드가 반한환 값
	 */
	@AfterReturning(pointcut = "execution(* com.example.service.Calculator.*(..))", returning = "result")
	public void afterReturn(JoinPoint joinPoint, double result) {
		LOGGER.info("The calculator function {} ends with {}.", joinPoint.getSignature().getName(), result);
	}

	/**
	 * 계산기 메서드 실행 중 에러가 발생하면 호출된다.
	 *
	 * 특정 에러만 감지하고 싶다면 ex의 타입을 Throwable 대신 구체적인 클래스로 두면 된다.
	 *
	 * @param joinPoint 호출된 메서드 정보
	 * @param ex 발생한 예외
	 */
	@AfterThrowing(pointcut = "execution(* com.example.service.Calculator.*(..))", throwing = "ex")
	public void afterThrowing(JoinPoint joinPoint, IllegalArgumentException ex) {
		LOGGER.error("The exception {} has been thrown in {}.", ex, joinPoint.getSignature().getName());
	}
}
