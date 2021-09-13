package cn.disscode.app.domain;

import cn.disscode.common.domain.BaseDomain;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author: dumplingBao
 * @Date: 2021/9/13
 */
@Data
@TableName(value = "menus")
public class Menu extends BaseDomain {
    private String parentId;
    private String type;
    private String href;
    private String icon;
    private String name;
    private String description;
    private String order;
}
