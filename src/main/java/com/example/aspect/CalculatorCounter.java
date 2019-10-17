package com.example.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

import com.example.service.Counter;
import com.example.service.CounterImpl;

@Aspect
@Component
public class CalculatorCounter {
	@DeclareParents(value = "com.example.service.*Calculator", defaultImpl = CounterImpl.class)
	public Counter counter;

	@After("execution(* com.example.service.*Calculator.*(..)) && this(counter)")
	public void after(Counter counter) {
		counter.increase();
	}
}
