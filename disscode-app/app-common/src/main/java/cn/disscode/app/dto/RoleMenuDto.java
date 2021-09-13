package cn.disscode.app.dto;

import cn.disscode.common.dto.BaseDto;
import lombok.Data;

/**
 * @Author: dumplingBao
 * @Date: 2021/9/13
 */
@Data
public class RoleMenuDto extends BaseDto {
    private String roleId;
    private String menuId;
}
