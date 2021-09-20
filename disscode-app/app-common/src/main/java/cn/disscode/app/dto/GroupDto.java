package cn.disscode.app.dto;

import cn.disscode.common.dto.BaseDto;
import lombok.Data;

/**
 * @Author: dumplingBao
 * @Date: 2021/9/20
 */
@Data
public class GroupDto extends BaseDto {
    private String name;
    private String description;
    private String deleted;
    private String parentId;
}
