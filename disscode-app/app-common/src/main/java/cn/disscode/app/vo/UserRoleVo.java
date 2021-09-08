package cn.disscode.app.vo;

import cn.disscode.common.vo.BaseVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @Author: dumplingBao
 * @Date: 2021/9/8
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleVo extends BaseVo{
    private String userId;
    private String roleId;
}
