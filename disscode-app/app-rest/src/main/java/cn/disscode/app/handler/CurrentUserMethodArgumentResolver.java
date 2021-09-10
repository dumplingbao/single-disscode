package cn.disscode.app.handler;

import cn.disscode.common.annotations.CurrentUser;
import cn.disscode.app.securrity.model.JwtUser;
import cn.disscode.app.securrity.utils.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;


/**
 * 自定义注解（当前用户）
 *
 * @Author: dumplingBao
 * @Date: 2021/9/9
 */
@Component
@Slf4j
public class CurrentUserMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    /**
     * 验证注解
     */
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.hasParameterAnnotation(CurrentUser.class);
    }

    /**
     * 返回Object
     */
    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        String token = nativeWebRequest.getHeader(jwtTokenUtil.getHeader());
        return (JwtUser)jwtTokenUtil.getUserDetail(token);
    }
}
