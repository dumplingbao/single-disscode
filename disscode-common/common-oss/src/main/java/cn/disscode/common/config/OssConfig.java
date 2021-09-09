package cn.disscode.common.config;

import cn.disscode.common.condition.OssCondition;
import cn.disscode.common.properties.OssProperties;
import com.aliyun.oss.ClientConfiguration;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.common.auth.DefaultCredentialProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties(OssProperties.class)
@Configuration
@Conditional(OssCondition.class)
@ConditionalOnProperty(prefix = "aliyun.oss", value = "true", matchIfMissing = true)
public class OssConfig {

    @Autowired
    private OssProperties ossProperties;

    @Bean
    public OSSClient ossClient() {
        String endpoint = ossProperties.getEndpoint();
        String accessKeyId = ossProperties.getAppKey();
        String accessKeySecret = ossProperties.getAppSecret();
        DefaultCredentialProvider defaultCredentialProvider = new DefaultCredentialProvider(accessKeyId, accessKeySecret);
        ClientConfiguration config = new ClientConfiguration();
        // 关闭CNAME选项。
        //config.setSupportCname(false);
        // 开启二级域名访问OSS，默认不开启。
        //config.setSLDEnabled(true);
        return new OSSClient(endpoint, defaultCredentialProvider, config);
    }
}
