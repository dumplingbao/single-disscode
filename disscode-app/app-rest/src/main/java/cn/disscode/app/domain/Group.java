package cn.disscode.app.domain;

import cn.disscode.common.domain.BaseDomain;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author: dumplingBao
 * @Date: 2021/9/20
 */
@Data
@TableName(value = "groups")
public class Group extends BaseDomain {
    private String name;
    private String description;
    private String deleted;
    private String parentId;
}
