package com.tsmc.ecp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PreqReportBuilderApplication {

	public static void main(String[] args) {
		SpringApplication.run(PreqReportBuilderApplication.class, args);
	}

}
