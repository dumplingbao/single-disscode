package cn.disscode.common.annotations;

import java.lang.annotation.*;

/**
 * 自定义注解（多数据源）
 *
 * @Author: dumplingBao
 * @Date: 2021/9/16
 */
@Target({ElementType.METHOD, ElementType.TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
    String value() default "write"; //该值即key值
}
