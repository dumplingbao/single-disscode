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
@ApiModel("岗位VO")
public class PositionVo extends BaseVo {
    private String name;
    private String description;
    private String deleted;
}
