package cn.disscode.app.vo;

import cn.disscode.common.vo.BaseVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.Set;

/**
 * @Author: dumplingbao
 * @Date: 2021/8/11
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserVo extends BaseVo{
    @NotBlank(message = "姓名不能为空")
    private String name;
    @NotBlank(message = "邮箱不能为空")
    private String email;
    @NotBlank(message = "用户手机号不能为空")
    private String mobile;
    @NotBlank(message = "用户名不能为空")
    private String username;
    private String description;
    private String deleted;
    private Set<String> roleIds;
}
