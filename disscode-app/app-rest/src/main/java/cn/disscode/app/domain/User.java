package cn.disscode.app.domain;

import cn.disscode.common.domain.BaseDomain;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @Author: dumplingBao
 * @Date: 2021/8/11
 */
@Data
@TableName(value = "users")
public class User extends BaseDomain {
    private String name;
    private String email;
    private String mobile;
    private String username;
    private String password;
    private String description;
    private Boolean enabled;
    private Boolean accountNonExpired;
    private Boolean credentialsNonExpired;
    private Boolean accountNonLocked;
    @TableLogic(value = "N", delval ="Y")
    private String deleted;
    private Date loginTime;
}
