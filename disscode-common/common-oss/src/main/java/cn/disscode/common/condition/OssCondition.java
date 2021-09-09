package cn.disscode.common.condition;


import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class OssCondition implements Condition {

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        String endpoint = conditionContext.getEnvironment().getProperty("aliyun.oss.endpoint");
        String appKey = conditionContext.getEnvironment().getProperty("aliyun.oss.appKey");
        String appSecret = conditionContext.getEnvironment().getProperty("aliyun.oss.appSecret");
        String bucket = conditionContext.getEnvironment().getProperty("aliyun.oss.bucket");
        if (StringUtils.isEmpty(endpoint)) {
            throw new RuntimeException("Lack of endpoint");
        }
        if (StringUtils.isEmpty(appKey)) {
            throw new RuntimeException("Lack of accessKeyId");
        }
        if (StringUtils.isEmpty(appSecret)) {
            throw new RuntimeException("Lack of accessKeySecret");
        }
        if (StringUtils.isEmpty(bucket)) {
            throw new RuntimeException("Lack of bucketName");
        }
        return true;
    }
}
