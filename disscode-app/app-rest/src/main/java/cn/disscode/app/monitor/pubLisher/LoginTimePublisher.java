package cn.disscode.app.monitor.pubLisher;

import cn.disscode.app.monitor.event.LoginTimeEvent;
import cn.disscode.app.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * @Author: dumplingBao
 * @Date: 2021/9/9
 */
@Component
public class LoginTimePublisher {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    /**
     * 事件发布方法
     * @param userVo
     */
    public void pushListener(UserVo userVo) {
        applicationEventPublisher.publishEvent(new LoginTimeEvent(this, userVo));
    }
}
