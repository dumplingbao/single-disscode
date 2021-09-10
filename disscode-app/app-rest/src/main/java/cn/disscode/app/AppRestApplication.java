package cn.disscode.app;

import cn.disscode.common.annotation.EnableAliyunOss;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: dumplingBao
 * @Date: 2021/8/11
 */
@SpringBootApplication
@EnableAliyunOss
public class AppRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppRestApplication.class, args);
    }

}
