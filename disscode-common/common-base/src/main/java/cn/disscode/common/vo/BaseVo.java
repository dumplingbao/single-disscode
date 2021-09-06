package cn.disscode.common.vo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * BaseVo
 *
 * @Author: dumplingBao
 * @Date: 2021/8/11
 */
@Data
public class BaseVo extends Page implements Serializable {

    private String id;

    private Integer index;

    private String createdBy;

    private Date createdTime;

    private String updatedBy;

    private Date updatedTime;
}
