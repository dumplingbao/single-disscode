package cn.disscode.app.domain;

import cn.disscode.common.domain.BaseDomain;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author: dumplingBao
 * @Date: 2021/9/20
 */
@Data
@TableName(value = "user_group")
public class UserGroup extends BaseDomain {
    private String userId;
    private String groupId;
}
