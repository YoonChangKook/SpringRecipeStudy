package com.example.aspect;

import java.util.stream.Stream;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 계산기 파라미터가 유효한지 검증하는 클래스
 *
 * @author 국윤창
 */
@Aspect
@Component
@Order(0)
public class CalculatorValidator {
	/**
	 * 계산기에 음수를 허용하지 않도록 검증하는 메서드
	 *
	 * @param joinPoint 호출된 메서드 정보
	 * @throws IllegalArgumentException 메서드 인자로 음수가 들어왔을 때
	 */
	@Before("execution(* com.example.service.Calculator.*(..))")
	public void validate(JoinPoint joinPoint) {
		if (Stream.of(joinPoint.getArgs()).anyMatch(arg -> (double)arg < 0)) {
			throw new IllegalArgumentException("Positive numbers only");
		}
	}
}
