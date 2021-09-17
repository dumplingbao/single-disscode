package cn.disscode.common.config;

import cn.disscode.common.utils.RedisUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: dumplingBao
 * @Date: 2021/9/9
 */
@Configuration
public class RedisConfig {

    @Bean
    public RedisUtil redisUtil() {
        return new RedisUtil();
    }
}
