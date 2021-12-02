package cn.disscode.app.vo;

import cn.disscode.common.vo.BaseVo;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: dumplingBao
 * @Date: 2021/9/20
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("用户组VO")
public class UserGroupVo extends BaseVo {
    private String userId;
    private String groupId;
}
