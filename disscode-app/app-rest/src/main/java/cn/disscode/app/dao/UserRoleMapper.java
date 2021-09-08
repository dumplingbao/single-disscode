package cn.disscode.app.dao;

import cn.disscode.app.domain.UserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Author: dumplingBao
 * @Date: 2021/9/8
 */
@Repository
@Mapper
public interface UserRoleMapper extends BaseMapper<UserRole> {
}