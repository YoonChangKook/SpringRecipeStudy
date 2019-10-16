package com.example.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.config.AppConfig;

/**
 * 계산기 테스트
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class CalculatorTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(CalculatorTest.class);
	private static final double NUM1 = 10;
	private static final double NUM2 = 20;
	private static final double DELTA = 0.01;

	@Autowired
	private Calculator calculator;

	@Test
	public void addTest() {
		assertEquals(calculator.add(NUM1, NUM2), NUM1 + NUM2, DELTA);
	}

	@Test
	public void subTest() {
		assertEquals(calculator.sub(NUM1, NUM2), NUM1 - NUM2, DELTA);
	}

	@Test
	public void mulTest() {
		assertEquals(calculator.mul(NUM1, NUM2), NUM1 * NUM2, DELTA);
	}

	@Test
	public void divTest() {
		assertEquals(calculator.div(NUM1, NUM2), NUM1 / NUM2, DELTA);
	}

	@Test(expected = IllegalArgumentException.class)
	public void divByZeroTest() {
		calculator.div(NUM1, 0.0);
	}
}
