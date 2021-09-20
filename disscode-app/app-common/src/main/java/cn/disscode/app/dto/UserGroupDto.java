package cn.disscode.app.dto;

import cn.disscode.common.dto.BaseDto;
import lombok.Data;

/**
 * @Author: dumplingBao
 * @Date: 2021/9/20
 */
@Data
public class UserGroupDto extends BaseDto {
    private String userId;
    private String groupId;
}
