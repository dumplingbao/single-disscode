package cn.disscode.common.core;

import cn.disscode.common.enums.ResultEnum;
import lombok.Data;
import org.springframework.util.StringUtils;

import java.io.Serializable;

/**
 * 通用返回
 *
 * @Author: dumplingbao
 * @Date: 2021/8/11
 */
@Data
public class Result<T> implements Serializable {

    /**
     * 数据内容
     */
    private T data;

    /**
     * 返回code
     */
    private int code;

    /**
     * 返回消息
     */
    private String msg;

    public Result() {
    }

    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(T data, int code, String msg) {
        this.data = data;
        this.code = code;
        this.msg = msg;
    }

    public Result(ResultEnum resultEnum) {
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMsg();
    }

    public Result(ResultEnum resultEnum, T data) {
        this(resultEnum);
        this.data = data;
    }

    public boolean isSuccess() {
        return code == 200;
    }

    public static <T> Result<T> success(T t) {
        return new Result<T>(ResultEnum.SUCCESS, t);
    }

    public static <T> Result<T> success(T t, String msg) {
        return new Result<T>(t, ResultEnum.SUCCESS.getCode(), msg);
    }

    public static <T> Result<T> fail(ResultEnum resultEnum) {
        return new Result<T>(resultEnum);
    }

    public static <T> Result<T> fail(T t) {
        return new Result<T>(ResultEnum.FAIL, t);
    }

    public static <T> Result<T> fail(ResultEnum resultEnum, String msg) {
        if (StringUtils.isEmpty(msg)) {
            return new Result<T>(resultEnum);
        } else {
            return new Result<T>(resultEnum.getCode(), msg);
        }
    }
}
