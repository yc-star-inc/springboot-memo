package com.tsmc.ecp.schedulingtasks;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PreqReportBuilderApplicationTests {

	@Autowired
	private ScheduledTasks tasks;
	
	//@Test
	void contextLoads() {
		// Basic integration test that shows the context starts up properly
		assertThat(tasks).isNotNull();
	}

}
