package cn.disscode.common.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * BaseDto
 *
 * @Author: dumplingbao
 * @Date: 2021/8/11
 */
@Data
public class BaseDto implements Serializable {

    private String id;

    private Integer index;

    private String createdBy;

    private Date createdTime;

    private String updatedBy;

    private Date updatedTime;

}
