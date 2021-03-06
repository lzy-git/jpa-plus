package top.openyuan.jpa.common.util;

import java.sql.Timestamp;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 利用ScheduledExecutorService实现高并发场景下System.currentTimeMillis()的性能问题的优化.
 * 用 https://github.com/yu120/neural 的实现
 *
 * @author lzy on 2020-12-04.
 * @since v1.0.0
 */
public class SystemClockUtils {

    private static AtomicLong nowTime;
    private static volatile boolean started = false;

    /**
     * The get string current time
     *
     * @return string time
     */
    public static String currentTimeMillisStr() {
        return new Timestamp(currentTimeMillis()).toString();
    }

    /**
     * The get current time milliseconds
     *
     * @return long time
     */
    public static long currentTimeMillis() {
        if (!started) {
            synchronized (SystemClockUtils.class) {
                if (!started) {
                    nowTime = new AtomicLong(System.currentTimeMillis());
                    ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(
                            1, r -> {
                        Thread thread = new Thread(r, "system-clock");
                        thread.setDaemon(true);
                        return thread;
                    });
                    executorService.scheduleAtFixedRate(() ->
                            nowTime.set(System.currentTimeMillis()), 1, 1, TimeUnit.MILLISECONDS);
                    Runtime.getRuntime().addShutdownHook(new Thread(executorService::shutdown));
                    started = true;
                }
            }
        }

        return nowTime.get();
    }
}
