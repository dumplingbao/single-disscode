package cn.disscode.app.controller;

import cn.disscode.app.securrity.model.JwtUser;
import cn.disscode.app.securrity.utils.JwtTokenUtil;
import cn.disscode.common.core.Result;
import cn.disscode.common.utils.RedisUtil;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * TEST
 *
 * @Author: dumplingBao
 * @Date: 2021/9/7
 */
@CrossOrigin
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    public HttpServletRequest request;

    /**
     * test
     *
     * @return
     */
    @PostMapping(value = "/test")
    public Result test() {
        redisUtil.set("test", "123456");
        return Result.success(null);
    }

    /**
     * test 用户信息
     *
     * @return
     */
    @PostMapping(value = "/user")
    public Result user() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof JwtUser) {
            JwtUser user = (JwtUser) authentication.getPrincipal();
            log.info("上下文: {}", JSONObject.toJSONString(user));
        }
        String token = request.getHeader(jwtTokenUtil.getHeader());
        JwtUser jwtUser = (JwtUser)jwtTokenUtil.getUserDetail(token);
        log.info("redis: {}", JSONObject.toJSONString(jwtUser));
        return Result.success(null);
    }


}