package cn.disscode.app.dto;

import cn.disscode.common.dto.BaseDto;
import lombok.Data;

/**
 * @Author: dumplingbao
 * @Date: 2021/8/11
 */
@Data
public class UserDto extends BaseDto {
    private String name;
    private String password;
    private String email;
    private String mobile;
    private String username;
    private String description;
    private String deleted;
}
