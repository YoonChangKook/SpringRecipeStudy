package com.example.service;

import static org.junit.Assert.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.config.AppConfig;

/**
 * 소수 계산기 테스트
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class PrimeCalculatorTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(PrimeCalculatorTest.class);
	private static final Map<Integer, Integer> TEST_PRIME_SET = Collections.unmodifiableMap(
		new HashMap<Integer, Integer>(){{
			put(1, 2);
			put(2, 3);
			put(30, 113);
			put(68, 337);
			put(999, 7907);
			put(1228, 9967);
			put(100008, 1299827);
		}}
	);

	@Autowired
	private PrimeCalculator primeCalculator;

	@Test
	public void getPrimeTest() {
		TEST_PRIME_SET.forEach((key, value) -> {
			int prime = primeCalculator.getPrime(key);
			LOGGER.debug("sequence {} prime is {}", key, prime);
			assertEquals((int)value, prime);
		});
	}

	@Test(expected = IllegalArgumentException.class)
	public void getPrimeNegativeValueTest() {
		primeCalculator.getPrime(-1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void getPrimeZeroValueTest() {
		primeCalculator.getPrime(0);
	}
}
