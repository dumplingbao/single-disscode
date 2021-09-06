package cn.disscode.common.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

/**
 * 参数异常
 *
 * @Author: dumplingBao
 * @Date: 2021/8/11
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class InvalidArgumentException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 9173499895755921528L;

    public InvalidArgumentException() {
        super();
    }

    public InvalidArgumentException(String message) {
        super(message);
    }
}
