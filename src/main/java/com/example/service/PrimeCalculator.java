package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.aspect.LoggingRequired;

/**
 * 소수를 계산하는 클래스
 *
 * @author 국윤창
 */
@Service
public class PrimeCalculator {
	private static final int START_INDEX = 1;

	/**
	 * 소수를 순서대로 저장해 놓는 리스트
	 */
	private final List<Integer> primeStorage;

	public PrimeCalculator() {
		primeStorage = new ArrayList<>();
		primeStorage.add(-1);
		primeStorage.add(2);
		primeStorage.add(3);
	}

	/**
	 * sequence 번째 소수를 반환한다.
	 *
	 * @param sequence 몇 번째 소수를 반환할 것인지
	 * @return sequence 번째 소수
	 * @throws IllegalArgumentException sequence가 0보다 작을 때
	 */
	@LoggingRequired
	public int getPrime(int sequence) {
		if (sequence < START_INDEX) {
			throw new IllegalArgumentException("The sequence must be positive value");
		}

		// 이미 계산된 소수가 존재하지 않는다면, 계산을 먼저 한다.
		int num = primeStorage.get(primeStorage.size() - 1) + 1;
		while (primeStorage.size() <= sequence) {
			int sqrtNum = (int)Math.sqrt(num);
			boolean isPrime = true;
			// num이 소수인지 검사한다. 루트 num보다 작은 소수들로 나눴을 때 0으로 떨어지면 소수가 아니다.
			for (int i = START_INDEX; primeStorage.get(i) <= sqrtNum; i++) {
				if (num % primeStorage.get(i) == 0) {
					isPrime = false;
					break;
				}
			}

			// 소수로 검증되면 리스트에 추가한다.
			if (isPrime) {
				primeStorage.add(num);
			}

			num++;
		}

		return primeStorage.get(sequence);
	}
}
