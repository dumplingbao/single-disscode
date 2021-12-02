package cn.disscode.app.vo;

import cn.disscode.common.vo.BaseVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.Set;

/**
 * @Author: dumplingBao
 * @Date: 2021/8/11
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("用户VO")
public class UserVo extends BaseVo{
    @NotBlank(message = "姓名不能为空")
    @ApiModelProperty(value="名称")
    private String name;
    @NotBlank(message = "邮箱不能为空")
    @ApiModelProperty(value="邮箱")
    private String email;
    @NotBlank(message = "用户手机号不能为空")
    @ApiModelProperty(value="手机")
    private String mobile;
    @NotBlank(message = "用户名不能为空")
    @ApiModelProperty(value="用户名")
    private String username;
    @ApiModelProperty(value="密码")
    private String password;
    @ApiModelProperty(value="描述")
    private String description;
    @ApiModelProperty(value="是否有效")
    private String deleted;
    @ApiModelProperty(value="最后登录时间")
    private Date loginTime;
    @ApiModelProperty(value="角色IDS")
    private Set<String> roleIds;
}
