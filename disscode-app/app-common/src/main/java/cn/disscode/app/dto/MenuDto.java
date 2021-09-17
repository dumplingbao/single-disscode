package cn.disscode.app.dto;

import cn.disscode.common.dto.BaseDto;
import lombok.Data;

/**
 * @Author: dumplingBao
 * @Date: 2021/9/13
 */
@Data
public class MenuDto extends BaseDto {
    private String parentId;
    private String type;
    private String href;
    private String icon;
    private String name;
    private String description;
    private String sort;
}
