package cn.disscode.swagger.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "swagger3.config")
public class Swagger3Properties {
    /*
        扫描的包
     */
    private String basePackage;

    private String title;

    private String description;

    private String contactName;

    private String contactUrl;

    private String contactEmail;

    private String version;

}
