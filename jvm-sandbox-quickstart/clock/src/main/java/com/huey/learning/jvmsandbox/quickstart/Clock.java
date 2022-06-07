package com.huey.learning.jvmsandbox.quickstart;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

/**
 * @author huey
 */
public class Clock {

    /**
     * 日期格式化
     */
    private final DateTimeFormatter clockDateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * 状态检查
     */
    final void checkState() {
        throw new IllegalStateException("STATE ERROR!");
    }

    /**
     * 获取当前时间
     *
     * @return 当前时间
     */
    final LocalDateTime now() {
        return LocalDateTime.now();
    }

    /**
     * 报告时间
     *
     * @return 报告时间
     */
    final String report() {
        checkState();
        return now().format(clockDateFormat);
    }

    /**
     * 循环播报时间
     */
    final void loopReport() throws InterruptedException {
        while (true) {
            try {
                System.out.println(report());
            }
            catch (Throwable cause) {
                cause.printStackTrace();
            }
            TimeUnit.SECONDS.sleep(1);
        }
    }

    public static void main(String... args) throws InterruptedException {
        new Clock().loopReport();
    }

}
