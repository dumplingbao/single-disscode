package cn.disscode.app.dto;

import cn.disscode.common.dto.BaseDto;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @Author: dumplingBao
 * @Date: 2021/8/11
 */
@Data
public class UserDto extends BaseDto {
    private String name;
    private String email;
    private String mobile;
    private String username;
    private String password;
    private String description;
    private Boolean enabled;
    private Boolean accountNonExpired;
    private Boolean credentialsNonExpired;
    private Boolean accountNonLocked;
    private String deleted;
    private Date loginTime;
    private List<UserRoleDto> userRoleDtoList;
}
