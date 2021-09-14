package cn.disscode.common.properties;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


/**
 * @Author: dumplingBao
 * @Date: 2021/9/14
 */
@Data
@Component
@ConfigurationProperties(prefix = "poolthread")
public class PoolProperties {

    /**
     * 线程池维护线程的最少数量，即使没有任务需要执行，也会一直存活
     * 默认1
     */
    private int corePoolSize;

    /**
     * 线程池维护线程的最大数量
     * 默认2147483647
     */
    private int maxPoolSize;

    /**
     * 缓存队列（阻塞队列）当核心线程数达到最大时，新任务会放在队列中排队等待执行
     * 默认2147483647
     *
     */
    private int queueCapacity;

    /**
     * 允许的空闲时间，当线程空闲时间达到keepAliveTime时，线程会退出，直到线程数量=corePoolSize
     * 默认60
     */
    private int keepAlive;

    /**
     * 公用配置线程名称
     */
    private String threadName;
}
