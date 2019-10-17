package com.example.task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ExecutorService를 테스트하기 위한 클래스
 *
 * @author 국윤창
 */
public class ExecutorServiceTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(ExecutorServiceTest.class);

	interface FunctionWithException {
		void run() throws Exception;
	}

	/**
	 * Runnable 인터페이스에서 Checked Exception 대신 Runtime Exception 내보내도록 하는 메서드
	 *
	 * @param function Runnable 객체
	 * @return 예외 처리가 된 Runnable 객체
	 */
	private Runnable runnableWrapper(FunctionWithException function) {
		return () -> {
			try {
				function.run();
			} catch (Exception ex) {
				throw new RuntimeException(ex);
			}
		};
	}

	@Test
	public void executorServiceTest() throws Exception {
		Runnable task = runnableWrapper(() -> Thread.sleep(1000));

		ExecutorService executorService = Executors.newCachedThreadPool();

		// get 함수는 block 이다
		if (executorService.submit(task, Boolean.TRUE).get().equals(true)) {
			LOGGER.info("Job has finished");
		}
	}
}
