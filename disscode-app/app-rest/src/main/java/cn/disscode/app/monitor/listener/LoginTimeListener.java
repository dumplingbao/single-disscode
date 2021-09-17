package cn.disscode.app.monitor.listener;

import cn.disscode.app.monitor.event.LoginTimeEvent;
import cn.disscode.app.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @Author: dumplingBao
 * @Date: 2021/9/9
 */
@Component
@Slf4j
public class LoginTimeListener {

    @Autowired
    private IUserService userService;

    @EventListener
    @Async
    public void listener(LoginTimeEvent loginTimeEvent) {
        userService.save(loginTimeEvent.getUserVo());
    }
}
