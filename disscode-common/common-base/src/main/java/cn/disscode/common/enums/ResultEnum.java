package cn.disscode.common.enums;

import lombok.Getter;

/**
 * ResultEnum
 *
 * @Author: dumplingBao
 * @Date: 2021/3/11
 */
@Getter
public enum ResultEnum {

    /**
     * 成功
     */
    LOGIN_FAIL(100, "登录失败"),
    /**
     * 成功
     */
    SUCCESS(200, "成功"),
    /**
     * 失败
     */
    FAIL(-1, "失败"),
    /**
     * 参数缺失（入参校验）
     */
    PARAM_MISSING(900, "参数缺失");

    /**
     * 返回码
     */
    private final int code;

    /**
     * 返回消息
     */
    private final String msg;

    ResultEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
