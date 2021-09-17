package cn.disscode.common.config;

import cn.disscode.common.aop.DynamicDataSourceAspect;
import cn.disscode.common.datasource.DynamicRoutingDataSource;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @Author: dumplingBao
 * @Date: 2021/9/16
 */
@Configuration
public class DatasourceConfig {


    @Primary
    @Bean(name = "writeDataSource")
    @ConfigurationProperties("spring.datasource.write")
    public HikariDataSource writeDataSource() {
        return new HikariDataSource();
    }

    @Bean(name = "readDataSource")
    @ConfigurationProperties("spring.datasource.read")
    public HikariDataSource readDataSource() {
        return new HikariDataSource();
    }

    @Bean(name = "dynamicDataSource")
    public DataSource dynamicRoutingDataSource() {
        DynamicRoutingDataSource dynamicRoutingDataSource = new DynamicRoutingDataSource();
        dynamicRoutingDataSource.setReadDataSource(readDataSource());
        dynamicRoutingDataSource.setWriteDataSource(writeDataSource());
        return dynamicRoutingDataSource;
    }

    @Bean
    public DynamicDataSourceAspect dynamicDataSourceAspect() {
        return new DynamicDataSourceAspect();
    }

}
