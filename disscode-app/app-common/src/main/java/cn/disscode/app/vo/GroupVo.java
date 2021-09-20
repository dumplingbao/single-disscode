package cn.disscode.app.vo;

import cn.disscode.common.vo.BaseVo;
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
public class GroupVo extends BaseVo {
    private String name;
    private String description;
    private String deleted;
    private String parentId;
}
