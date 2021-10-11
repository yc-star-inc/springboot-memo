package com.tsmc.ecp.schedulingtasks;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.SpyBean;

import org.awaitility.Durations;

import static org.awaitility.Awaitility.await;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;

class ScheduledTasksTest {

	@SpyBean
	ScheduledTasks tasks;

	//@Test
	public void reportCurrentTime() {
		await().atMost(Durations.TEN_SECONDS).untilAsserted(() -> {
			verify(tasks, atLeast(2)).reportCurrentTime();
		});
	}

}
