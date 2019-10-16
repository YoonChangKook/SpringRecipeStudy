package com.example.service;

import org.springframework.stereotype.Service;

/**
 * 테스트 용 계산기 클래스
 *
 * @author 국윤창
 */
@Service
public class Calculator {
	public double add(double a, double b) {
		return a + b;
	}

	public double sub(double a, double b) {
		return a - b;
	}

	public double mul(double a, double b) {
		return a * b;
	}

	/**
	 * 두 수를 받아 나눈 결과를 반환한다.
	 *
	 * @param a 나눠질 수
	 * @param b 나눌 수
	 * @return a를 b로 나눈 결과
	 * @throws IllegalArgumentException b가 0일 때
	 */
	public double div(double a, double b) {
		if (b == 0) {
			throw new IllegalArgumentException("Division by zero");
		}
		return a / b;
	}
}
