package com.tsmc.ecp.schedulingtasks;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

	private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Scheduled(fixedRate = 5000)
	public void reportCurrentTime() {
		logger.info("The time is now {}", dateFormat.format(new Date()));
	}

	@Scheduled(fixedDelay = 60000) // fixedDelay = 60000 表示當前方法執行完畢 60000ms(1分鐘) 後，Spring scheduling會再次呼叫該方法
	public void testFixDelay() {
		logger.info("===fixedDelay: 時間:{}", dateFormat.format(new Date()));
	}

	@Scheduled(fixedRate = 60000) // fixedRate = 60000 表示當前方法開始執行 60000ms(1分鐘) 後，Spring scheduling會再次呼叫該方法
	public void testFixedRate() {
		logger.info("===fixedRate: 時間:{}", dateFormat.format(new Date()));
	}

	@Scheduled(initialDelay = 180000, fixedRate = 5000) // initialDelay = 180000 表示延遲 180000 (3秒) 執行第一次任務, 然後每 5000ms(5
														// 秒) 再次呼叫該方法
	public void testInitialDelay() {
		logger.info("===initialDelay: 時間:{}", dateFormat.format(new Date()));
	}

	@Scheduled(cron = "0 0/1 * * * ?") // cron接受cron表示式，根據cron表示式確定定時規則
	public void testCron() {
		logger.info("===cron: 時間:{}", dateFormat.format(new Date()));
	}
}