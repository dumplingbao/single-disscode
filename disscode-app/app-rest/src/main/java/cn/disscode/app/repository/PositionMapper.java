package cn.disscode.app.repository;

import cn.disscode.app.domain.Position;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Author: dumplingBao
 * @Date: 2021/9/20
 */
@Repository
@Mapper
public interface PositionMapper extends BaseMapper<Position> {
}