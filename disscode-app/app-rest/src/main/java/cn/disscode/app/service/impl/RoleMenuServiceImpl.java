package cn.disscode.app.service.impl;

import cn.disscode.app.domain.RoleMenu;
import cn.disscode.app.dto.RoleMenuDto;
import cn.disscode.app.repository.RoleMenuMapper;
import cn.disscode.app.service.IRoleMenuService;
import cn.disscode.app.vo.RoleMenuVo;
import cn.disscode.common.service.impl.IBaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @Author: dumplingBao
 * @Date: 2021/9/13
 */
@Service
public class RoleMenuServiceImpl extends IBaseServiceImpl<RoleMenuMapper, RoleMenu, RoleMenuDto, RoleMenuVo> implements IRoleMenuService {


}
