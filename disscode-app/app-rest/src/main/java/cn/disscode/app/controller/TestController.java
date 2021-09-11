package cn.disscode.app.controller;

import cn.disscode.app.monitor.event.LoginTimeEvent;
import cn.disscode.app.monitor.pubLisher.LoginTimePublisher;
import cn.disscode.app.vo.UserVo;
import cn.disscode.common.annotations.CurrentUser;
import cn.disscode.app.securrity.model.JwtUser;
import cn.disscode.app.securrity.utils.JwtTokenUtil;
import cn.disscode.common.annotations.ParamLog;
import cn.disscode.common.core.Result;
import cn.disscode.common.utils.OssUtil;
import cn.disscode.common.utils.RedisUtil;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;

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

    @Autowired
    public OssUtil ossUtil;

    @Autowired
    public ApplicationContext applicationContext;

    @Autowired
    private LoginTimePublisher loginTimePublisher;


    /**
     * test redis缓存
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
        // 方式一
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof JwtUser) {
            JwtUser user = (JwtUser) authentication.getPrincipal();
            log.info("上下文: {}", JSONObject.toJSONString(user));
        }

        // 方式二
        String token = request.getHeader(jwtTokenUtil.getHeader());
        JwtUser jwtUser = (JwtUser)jwtTokenUtil.getUserDetail(token);
        log.info("redis: {}", JSONObject.toJSONString(jwtUser));
        return Result.success(null);
    }

    /**
     * test 自定义注解获取用户信息
     *
     * @return
     */
    @PostMapping(value = "/currentUser")
    @ParamLog
    public Result currentUser(@CurrentUser JwtUser user) {

        log.info("currentUser: {}", JSONObject.toJSONString(user));
        return Result.success(null);
    }

    /**
     * test 文件上传
     *
     * @return
     */
    @PostMapping(value = "/upload")
    public Result upload(@RequestParam("file") MultipartFile file) {

        try {
            String rep = ossUtil.upload(file);
            log.info("文件上传返回值：{}", rep);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Result.success(null);
    }

    /**
     * test 监听事件（登录时间）
     *
     * @return
     */
    @PostMapping(value = "/loginTime")
    public Result loginTime() {
        UserVo userVo = new UserVo();
        userVo.setId("102");
        userVo.setLoginTime(new Date());

        // 方式一
        applicationContext.publishEvent(new LoginTimeEvent(this, userVo));

        // 方式二
        loginTimePublisher.pushListener(userVo);
        return Result.success(null);
    }

}