package cn.disscode.app.service.impl;

import cn.disscode.app.domain.Position;
import cn.disscode.app.dto.PositionDto;
import cn.disscode.app.repository.PositionMapper;
import cn.disscode.app.service.IPositionService;
import cn.disscode.app.vo.PositionVo;
import cn.disscode.common.service.impl.IBaseServiceImpl;
import org.springframework.stereotype.Service;


/**
 * @Author: dumplingBao
 * @Date: 2021/9/20
 */
@Service
public class PositionServiceImpl extends IBaseServiceImpl<PositionMapper, Position, PositionDto, PositionVo> implements IPositionService {


}
