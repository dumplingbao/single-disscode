package cn.disscode.common.config;

import cn.disscode.common.aop.LogAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogConfig {

    @Bean
    public LogAspect logAspect() {
        return new LogAspect();
    }
}
