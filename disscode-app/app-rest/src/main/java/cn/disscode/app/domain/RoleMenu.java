package cn.disscode.app.domain;

import cn.disscode.common.domain.BaseDomain;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author: dumplingBao
 * @Date: 2021/9/13
 */
@Data
@TableName(value = "role_menu")
public class RoleMenu extends BaseDomain {
    private String roleId;
    private String menuId;
}
