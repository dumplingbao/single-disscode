package cn.disscode.app.service.impl;

import cn.disscode.app.domain.UserPosition;
import cn.disscode.app.dto.UserPositionDto;
import cn.disscode.app.repository.UserPositionMapper;
import cn.disscode.app.service.IUserPositionService;
import cn.disscode.app.vo.UserPositionVo;
import cn.disscode.common.service.impl.IBaseServiceImpl;
import org.springframework.stereotype.Service;


/**
 * @Author: dumplingBao
 * @Date: 2021/9/20
 */
@Service
public class UserPositionServiceImpl extends IBaseServiceImpl<UserPositionMapper, UserPosition, UserPositionDto, UserPositionVo> implements IUserPositionService {


}
