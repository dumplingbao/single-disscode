package cn.disscode.app.dto;

import cn.disscode.common.dto.BaseDto;
import lombok.Data;

import java.util.List;

/**
 * @Author: dumplingBao
 * @Date: 2021/8/11
 */
@Data
public class RoleDto extends BaseDto {
    private String name;
    private String code;
    private String description;
    private List<RoleMenuDto> roleMenuDtoList;
}
