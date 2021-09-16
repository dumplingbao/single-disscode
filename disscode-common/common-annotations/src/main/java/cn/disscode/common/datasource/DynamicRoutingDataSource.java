package cn.disscode.common.datasource;

import cn.disscode.common.constant.DataSourceEnum;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Data
public class DynamicRoutingDataSource extends AbstractRoutingDataSource {

    /**
     * 写数据源
     */
    private Object writeDataSource;
    /**
     * 读数据源
     */
    private Object readDataSource;

    @Override
    public void afterPropertiesSet() {
        if (this.writeDataSource == null) {
            throw new IllegalArgumentException("缺少数据库配置");
        }
        setDefaultTargetDataSource(writeDataSource);
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DataSourceEnum.WRITE.name(), writeDataSource);
        if (readDataSource != null) {
            targetDataSources.put(DataSourceEnum.READ.name(), readDataSource);
        }
        setTargetDataSources(targetDataSources);
        super.afterPropertiesSet();
    }

    @Override
    protected Object determineCurrentLookupKey() {

        String dataSourceRouterKey = DynamicDataSourceContextHolder.getDataSourceRouterKey();

        if (dataSourceRouterKey == null
                || dataSourceRouterKey == DataSourceEnum.WRITE.name()) {
            return DataSourceEnum.WRITE.name();
        }
        return DataSourceEnum.READ.name();
    }
}
