package cn.disscode.app.dao;

import cn.disscode.app.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Author: dumplingbao
 * @Date: 2021/8/11
 */
@Repository
@Mapper
public interface UserMapper extends BaseMapper<User> {
}