package com.tsmc.ecp.schedulingtasks;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
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

	@Scheduled(cron = "0 0/1 * * * ?") // cron接受cron表示式，根據cron表示式確定定時規則
	public void doConfigQualityCheck() {
		logger.info("===cron: 時間:{}", dateFormat.format(new Date()));

		/// fabPlantCd
		/// matNo
		/// monCriteria1
		/// monCriteria2
		/// subCriteria1
		/// subCriteria2
		/// result
		/// message
		Timestamp startTs = Timestamp.from(Instant.now());
		logger.info("===cron: 時間(Instant.now()):{}", dateFormat.format(startTs));

		Timestamp usedT = Timestamp.from(Instant.now());
		Integer caseCloseDelay = 30; // mins
		Timestamp closeTime = new Timestamp(DateUtils.addMinutes(new Date(usedT.getTime()), caseCloseDelay).getTime());

		//if(nowTs.isBefore())
		logger.info("===cron: 時間(closeTime.now()):{}", dateFormat.format(closeTime));
	}

	private String getMapValue(Map<String, String> source, String key) {
		if(source.containsKey(key)) return source.get(key);
		else return StringUtils.EMPTY;
	}

	private Timestamp dateToTimestamp(Date dt) {
		// getting the object of the Timestamp class
		Timestamp ts = new Timestamp(dt.getTime());
		return ts;
	}
	private Timestamp now() {
		Date date = new Date();
		return dateToTimestamp(date);
	}
}
