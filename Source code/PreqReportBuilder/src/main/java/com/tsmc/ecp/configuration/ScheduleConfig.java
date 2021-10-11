package com.tsmc.ecp.configuration;

import java.util.concurrent.Executors;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

/**
 * Description: 多執行緒執行定時任務
 */
@Configuration
//所有的定時任務都放在一個執行緒池中，定時任務啟動時使用不同都執行緒。
public class ScheduleConfig implements SchedulingConfigurer {
 @Override
 public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
  // 設定一個長度10的定時任務執行緒池
  taskRegistrar.setScheduler(Executors.newScheduledThreadPool(10));
 }
}


/// https://polinwei.com/spring-boot-scheduling-tasks/