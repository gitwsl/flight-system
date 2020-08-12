package com.wsl.flight.provider.score.provider.schedule;

import com.oracle.tools.packager.Log;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author lin.wang
 * @date 2020/08/12
 */
@Component
public class ScheduledTask {

    /***
     * 模拟计算出成绩，扔到kafka
     */
    @Scheduled(fixedRate = 30000)
    public void scheduledTask() {
        Log.info("定时任务（模拟计算出成绩，扔到kafka）：" + LocalDateTime.now());

    }
}
