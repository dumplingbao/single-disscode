package cn.disscode.common.config;

import cn.disscode.common.properties.PoolProperties;
import cn.disscode.common.service.IAsyncService;
import cn.disscode.common.service.impl.AsyncServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;


/**
 * @Author: dumplingBao
 * @Date: 2021/9/14
 */
@Configuration
@EnableAsync
@EnableConfigurationProperties(PoolProperties.class)
public class PoolConfig {

    @Autowired
    PoolProperties poolProperties;

    @Bean
    public Executor executorCustom(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //设置核心线程数
        executor.setCorePoolSize(poolProperties.getCorePoolSize());
        // 设置最大线程数
        executor.setMaxPoolSize(poolProperties.getMaxPoolSize());
        // 设置队列容量
        executor.setQueueCapacity(poolProperties.getQueueCapacity());
        // 设置允许的空闲时间（秒）
        executor.setKeepAliveSeconds(poolProperties.getKeepAlive());
        // 设置默认线程名称
        executor.setThreadNamePrefix(poolProperties.getThreadName());
        // 设置拒绝策略rejection-policy：当pool已经达到max size的时候，如何处理新任务
        // CALL_RUNS:不在新线程中执行任务，二十由调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 等待所有任务结束后在关闭线程池
        executor.setWaitForTasksToCompleteOnShutdown(true);
        return executor;
    }

    @Bean
    public Executor executorCommon(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //设置核心线程数
        executor.setCorePoolSize(poolProperties.getCorePoolSize());
        // 设置最大线程数
        executor.setMaxPoolSize(poolProperties.getMaxPoolSize());
        // 设置队列容量
        executor.setQueueCapacity(poolProperties.getQueueCapacity());
        // 设置允许的空闲时间（秒）
        executor.setKeepAliveSeconds(poolProperties.getKeepAlive());
        // 设置默认线程名称
        executor.setThreadNamePrefix("thread-common-");
        // 设置拒绝策略rejection-policy：当pool已经达到max size的时候，如何处理新任务
        // CALL_RUNS:不在新线程中执行任务，二十由调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 等待所有任务结束后在关闭线程池
        executor.setWaitForTasksToCompleteOnShutdown(true);
        return executor;
    }

    @Bean
    public IAsyncService asyncService() {
        return new AsyncServiceImpl();
    }
}
