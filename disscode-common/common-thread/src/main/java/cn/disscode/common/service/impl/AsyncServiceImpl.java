package cn.disscode.common.service.impl;

import cn.disscode.common.service.IAsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 示例
 *
 * @Author: dumplingBao
 * @Date: 2021/9/14
 */
@Slf4j
@Service
public class AsyncServiceImpl implements IAsyncService {

    @Async("executorCommon")
    @Override
    public void executeAsyncCommon() {
        log.info("start executorCommon");
        try {
            System.out.println("当前运行线的程名称：" + Thread.currentThread().getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("end executorCommon");
    }

    @Async("executorCustom")
    @Override
    public void executeAsyncCustom() {
        log.info("start executorCustom");
        try {
            System.out.println("当前运行线的程名称：" + Thread.currentThread().getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("end executorCustom");
    }
}
