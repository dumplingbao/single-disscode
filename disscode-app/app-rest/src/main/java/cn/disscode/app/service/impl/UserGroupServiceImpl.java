package cn.disscode.app.service.impl;

import cn.disscode.app.domain.UserGroup;
import cn.disscode.app.dto.UserGroupDto;
import cn.disscode.app.repository.UserGroupMapper;
import cn.disscode.app.service.IUserGroupService;
import cn.disscode.app.vo.UserGroupVo;
import cn.disscode.common.service.impl.IBaseServiceImpl;
import org.springframework.stereotype.Service;


/**
 * @Author: dumplingBao
 * @Date: 2021/9/20
 */
@Service

public class UserGroupServiceImpl extends IBaseServiceImpl<UserGroupMapper, UserGroup, UserGroupDto, UserGroupVo> implements IUserGroupService {


}
