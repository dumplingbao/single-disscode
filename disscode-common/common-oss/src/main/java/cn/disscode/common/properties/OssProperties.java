package cn.disscode.common.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "aliyun.oss")
public class OssProperties {

    private String appKey;

    private String appSecret;

    private String url;

    private String endpoint;

    private String bucket;

    private String callback;

    private String dir;

}
