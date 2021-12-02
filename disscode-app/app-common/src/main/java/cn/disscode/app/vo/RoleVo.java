package cn.disscode.app.vo;

import cn.disscode.common.vo.BaseVo;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @Author: dumplingBao
 * @Date: 2021/8/11
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("角色VO")
public class RoleVo extends BaseVo{
    @NotBlank(message = "名称不能为空")
    private String name;
    @NotBlank(message = "code不能为空")
    private String code;
    private String description;
}
