package cn.disscode.common.constant;

/**
 * @Author: dumplingBao
 * @Date: 2021/9/16
 */
public enum DataSourceEnum {
    /**
     * 读数据源
     */
    READ,
    /**
     * 写数据源
     */
    WRITE;

    public static boolean isInclude(String name) {
        boolean include = false;
        for(DataSourceEnum e: DataSourceEnum.values()) {
            if(e.name().equals(name)) {
                include = true;
            }
        }
        return include;
    }
}
