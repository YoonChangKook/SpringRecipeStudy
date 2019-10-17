package com.example.service;

/**
 * 횟수를 기록하는 클래스
 *
 * @author 국윤창
 */
public class CounterImpl implements Counter {
	private int count;

	@Override
	public void increase() {
		count++;
	}

	@Override
	public int getCount() {
		return count;
	}
}
