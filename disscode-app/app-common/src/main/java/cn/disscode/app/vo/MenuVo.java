package cn.disscode.app.vo;

import cn.disscode.common.vo.BaseVo;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.Set;

/**
 * @Author: dumplingBao
 * @Date: 2021/9/13
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("菜单VO")
public class MenuVo extends BaseVo{

    private String parentId;
    private String type;
    private String href;
    @NotBlank(message = "菜单图标不能为空")
    private String icon;
    @NotBlank(message = "菜单名称不能为空")
    private String name;
    private String description;
    private String sort;
}
