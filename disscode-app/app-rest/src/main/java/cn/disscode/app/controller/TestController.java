package cn.disscode.app.controller;

import cn.disscode.common.core.Result;
import cn.disscode.common.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


}