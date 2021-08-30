package cn.disscode.common.exception;

import lombok.Getter;

import java.io.Serializable;

/**
 * 业务异常
 *
 * @Author: dumplingbao
 * @Date: 2021/8/11
 **/
@Getter
public class BusinessException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 9173499895755921528L;

    public BusinessException() {}

    public BusinessException(String message) {
        super(message);
    }
}
