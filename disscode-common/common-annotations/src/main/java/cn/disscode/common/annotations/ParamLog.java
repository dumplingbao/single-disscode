package cn.disscode.common.annotations;

import java.lang.annotation.*;

/**
 * 自定义注解（日志拦截）
 *
 * @Author: dumplingBao
 * @Date: 2021/9/9
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ParamLog {

    String startMark() default "轻轻的我来了>>>>>>";

    String endMark() default "匆匆的我走了<<<<<<";
}
