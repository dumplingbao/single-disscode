package cn.disscode.app.annotations;

import java.lang.annotation.*;

/**
 * 自定义注解（当前用户）
 *
 * @Author: dumplingBao
 * @Date: 2021/9/9
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CurrentUser {
}
