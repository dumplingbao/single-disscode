package cn.disscode.app.config;

import cn.disscode.app.annotations.CurrentUserMethodArgumentResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * 自定义spring统一配置管理
 *
 * @Author: dumplingBao
 * @Date: 2021/9/9
 */
@Configuration
public class CustomWebMvcConfigurer implements WebMvcConfigurer {

    private final CurrentUserMethodArgumentResolver resolver;

    public CustomWebMvcConfigurer(CurrentUserMethodArgumentResolver resolver) {
        this.resolver = resolver;
    }

    /**
     * 自定义参数处理器
     * @param resolvers
     */
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(resolver);
    }
}
