package cn.disscode.common.utils;


import cn.disscode.common.core.Result;
import cn.disscode.common.enums.ResultEnum;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.messageinterpolation.ResourceBundleMessageInterpolator;
import org.hibernate.validator.resourceloading.PlatformResourceBundleLocator;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * @Author: dumplingbao
 * @Date: 2021/8/11
 *
 * @Null   被注释的元素必须为 null
 * @NotNull    被注释的元素必须不为 null
 * @AssertTrue     被注释的元素必须为 true
 * @AssertFalse    被注释的元素必须为 false
 * @Min(value)     被注释的元素必须是一个数字，其值必须大于等于指定的最小值
 * @Max(value)     被注释的元素必须是一个数字，其值必须小于等于指定的最大值
 * @DecimalMin(value)  被注释的元素必须是一个数字，其值必须大于等于指定的最小值
 * @DecimalMax(value)  被注释的元素必须是一个数字，其值必须小于等于指定的最大值
 * @Size(max=, min=)   被注释的元素的大小必须在指定的范围内
 * @Digits (integer, fraction)     被注释的元素必须是一个数字，其值必须在可接受的范围内
 * @Past   被注释的元素必须是一个过去的日期
 * @Future     被注释的元素必须是一个将来的日期
 * @Pattern(regex=,flag=)  被注释的元素必须符合指定的正则表达式
 *
 * Hibernate Validator 附加的 constraint
 * @NotBlank(message =)   验证字符串非null，且长度必须大于0
 * @Email  被注释的元素必须是电子邮箱地址
 * @Length(min=,max=)  被注释的字符串的大小必须在指定的范围内
 * @NotEmpty   被注释的字符串的必须非空
 * @Range(min=,max=,message=)  被注释的元素必须在合适的范围内
 *
 */
@Slf4j
public class ValidationUtils {

    public interface Insert {

    }

    public interface Update {

    }

    public interface Query {

    }

    public interface CreateProcess {

    }

    /**
     * 验证器
     */
    private static Validator validator;

    static {
//        validator = Validation.buildDefaultValidatorFactory().getValidator();
        validator = Validation.byDefaultProvider().configure()
                .messageInterpolator(
                        new ResourceBundleMessageInterpolator(new PlatformResourceBundleLocator("ValidationMessages_zh_CN")))
                .buildValidatorFactory().getValidator();
    }

    /**
     *  验证方法
     *  <p>
     *      同一个pojo类，可能会被多个controller使用验证，而每个controller的验证规则有不同，
     *      这是就需要分组验证，其实就是几个要分组的空接口，指定属性A属于哪个组，属性B又属于
     *      哪个组，这样在controller验证时就指定我要验证哪个组
     *  </p>
     * @param object 被校验的对象
     * @param groups 被校验的组
     */
    public static Result validate(Object object, Class<?>... groups) {
        // 用验证器执行验证，返回一个违反约束的set集合
        Set<ConstraintViolation<Object>> violationSet = validator.validate(object, groups);
        // 判断是否为空，空：说明验证通过，否则就验证失败
        if(!violationSet.isEmpty()) {
            // 获取第一个验证失败的属性
            ConstraintViolation<Object> violation = violationSet.iterator().next();
            // 字段名称
            String fieldName = violation.getPropertyPath().toString();
            // 校验消息
            String message = violation.getMessage();
            log.info("字段{}校验未能通过: {}", fieldName, message);
            return Result.fail(ResultEnum.PARAM_MISSING, fieldName + message);
        }
        return Result.success(null);
    }
}
