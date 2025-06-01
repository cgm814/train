package com.jiawa.train.batch.job;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Author: 陈桂明
 * Date: 2025/6/1 23:46
 * Description: SpringBootTestJob
 */

/**
 * spring自带的定时任务：适合单体应用，不适合集群
 * 没法实时更改定时任务和策略
 */
@Component
@EnableScheduling
public class SpringBootTestJob {

    @Scheduled(cron = "0/5 * * * * ?")
    private void test() {
        // 增加分布式锁，解决集群问题
        System.out.println("SpringBootTestJob Test");
    }
}
