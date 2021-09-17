package cn.disscode.app.monitor.event;

import cn.disscode.app.vo.UserVo;
import lombok.Data;
import org.springframework.context.ApplicationEvent;

/**
 * @Author: dumplingBao
 * @Date: 2021/9/9
 */
@Data
public class LoginTimeEvent extends ApplicationEvent {

    public LoginTimeEvent(Object source) {
        super(source);
    }

    private UserVo userVo;

    public LoginTimeEvent(Object source, UserVo userVo) {
        super(source);
        this.userVo = userVo;
    }
}
