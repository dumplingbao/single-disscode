package cn.disscode.app.domain;

import cn.disscode.common.domain.BaseDomain;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author: dumplingBao
 * @Date: 2021/9/3
 */
@Data
@TableName(value = "roles")
public class Role extends BaseDomain {
    private String code;
    private String name;
    private String description;
}
