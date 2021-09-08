package cn.disscode.app.domain;

import cn.disscode.common.domain.BaseDomain;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author: dumplingBao
 * @Date: 2021/9/8
 */
@Data
@TableName(value = "user_role")
public class UserRole extends BaseDomain {
    private String userId;
    private String roleId;
}
