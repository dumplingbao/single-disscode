package cn.disscode.swagger.config;

import cn.disscode.swagger.properties.Swagger3Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


@EnableConfigurationProperties(Swagger3Properties.class)
@Configuration
@EnableOpenApi
@ConditionalOnProperty(prefix = "swagger3.config", value = "true", matchIfMissing = true)
public class Swagger3Config {

    @Autowired
    private Swagger3Properties swagger3Properties;

    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo()).enable(true)
                .select()
                //添加swagger接口提取范围,修改成指向你的controller包
                .apis(RequestHandlerSelectors.basePackage(swagger3Properties.getBasePackage()))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title(swagger3Properties.getTitle())
                .description(swagger3Properties.getDescription())
                .contact(new Contact(swagger3Properties.getContactName(), swagger3Properties.getContactUrl(), swagger3Properties.getContactEmail()))
                .version(swagger3Properties.getVersion())
                .build();
    }
}
