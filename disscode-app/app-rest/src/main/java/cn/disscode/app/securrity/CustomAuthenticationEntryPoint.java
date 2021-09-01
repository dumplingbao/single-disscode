package cn.disscode.app.securrity;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 认证失败处理
 *
 * @Author: dumplingbao
 * @Date: 2021/9/1
 */
@Component
@Slf4j
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        log.info("认证失败！！！");
        response.setContentType("application/json;charset=utf-8");
        String requestType = request.getHeader("X-Requested-With");
        JSONObject json = new JSONObject();
        if(authException instanceof InsufficientAuthenticationException) {
            try(PrintWriter out = response.getWriter()){
                json.put("status", "warning");
                json.put("message", "您尚未登录，请登录后再操作");
                out.write(json.toString());
                out.flush();
                out.close();
            }catch(Exception e) {}
        }
    }
}
