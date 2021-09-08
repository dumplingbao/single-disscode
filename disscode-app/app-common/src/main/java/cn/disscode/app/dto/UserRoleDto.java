package cn.disscode.app.dto;

import cn.disscode.common.dto.BaseDto;
import lombok.Data;

/**
 * @Author: dumplingBao
 * @Date: 2021/9/8
 */
@Data
public class UserRoleDto extends BaseDto {
    private String userId;
    private String roleId;
    private RoleDto roleDto;
}
