package cn.disscode.common.annotation;

import cn.disscode.common.condition.OssCondition;
import cn.disscode.common.config.OssConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 通过注解的方式注入配置（代替spring.factories方式）
 *
 * @Author: dumplingBao
 * @Date: 2021/9/10
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({OssCondition.class, OssConfig.class})
public @interface EnableAliyunOss {
}
