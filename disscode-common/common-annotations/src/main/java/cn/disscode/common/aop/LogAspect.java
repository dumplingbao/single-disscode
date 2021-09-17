package cn.disscode.common.aop;

import cn.disscode.common.annotations.ParamLog;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Author: dumplingBao
 * @Date: 2021/9/9
 */
@Aspect
@Component
@Slf4j
public class LogAspect {

    // 配置切入点(通过注解拦截)
    @Pointcut("@annotation(cn.disscode.common.annotations.ParamLog)")
    public void logPointCut(){

    }

    @Before("logPointCut()")
    public void beforeDoing(JoinPoint joinPoint){
        Object[] args= joinPoint.getArgs();
        // 类名
        String className = joinPoint.getTarget().getClass().getName();
        // 方法名
        String methodName = joinPoint.getSignature().getName();

        ParamLog paramLog = paramLog(joinPoint);
        log.info(paramLog.startMark());
        log.info("入参日志》》》：类名：{}，方法名：{}，入参：{}", className, methodName, JSONObject.toJSONString(args));
    }

    @AfterReturning("logPointCut()")
    public void afterReturnDoing(JoinPoint joinPoint) {
        Object[] args= joinPoint.getArgs();
        // 类名
        String className = joinPoint.getTarget().getClass().getName();
        // 方法名
        String methodName = joinPoint.getSignature().getName();

        ParamLog paramLog = paramLog(joinPoint);
        log.info("返回值》》》：类名：{}，方法名：{}，返回值：{}", className, methodName, JSONObject.toJSONString(args));
        log.info(paramLog.endMark());
    }

    // 获取注解
    private static ParamLog paramLog(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature)signature;
        Method method = methodSignature.getMethod();
        if (method != null) {
            return method.getAnnotation(ParamLog.class);
        }
        return null;
    }
}
