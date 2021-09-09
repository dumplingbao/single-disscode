package cn.disscode.app.service.impl;

import cn.disscode.app.repository.RoleMapper;
import cn.disscode.app.domain.Role;
import cn.disscode.app.dto.RoleDto;
import cn.disscode.app.service.IRoleService;
import cn.disscode.app.vo.RoleVo;
import cn.disscode.common.service.impl.IBaseServiceImpl;
import org.springframework.stereotype.Service;


/**
 * @Author: dumplingBao
 * @Date: 2021/9/3
 */
@Service
public class RoleServiceImpl extends IBaseServiceImpl<RoleMapper, Role, RoleDto, RoleVo> implements IRoleService {


}
