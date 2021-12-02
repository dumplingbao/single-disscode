package cn.disscode.app.vo;

import cn.disscode.common.vo.BaseVo;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: dumplingBao
 * @Date: 2021/9/13
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("角色菜单VO")
public class RoleMenuVo extends BaseVo{
    private String roleId;
    private String menuId;
}
