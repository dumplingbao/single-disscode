package cn.disscode.app.service.impl;

import cn.disscode.app.dto.RoleMenuDto;
import cn.disscode.app.repository.RoleMapper;
import cn.disscode.app.domain.Role;
import cn.disscode.app.dto.RoleDto;
import cn.disscode.app.service.IRoleMenuService;
import cn.disscode.app.service.IRoleService;
import cn.disscode.app.vo.RoleMenuVo;
import cn.disscode.app.vo.RoleVo;
import cn.disscode.common.service.impl.IBaseServiceImpl;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @Author: dumplingBao
 * @Date: 2021/9/3
 */
@Service
public class RoleServiceImpl extends IBaseServiceImpl<RoleMapper, Role, RoleDto, RoleVo> implements IRoleService {

    @Autowired
    private IRoleMenuService roleMenuService;

    @Override
    public Wrapper<Role> beforePage(RoleVo roleVo) {
        if (roleVo != null) {
            QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
            if (StringUtils.isNotEmpty(roleVo.getId())) {
                queryWrapper.eq("id", roleVo.getId());
            }
            return queryWrapper;
        }
        return Wrappers.emptyWrapper();
    }

    @Override
    public void afterPage(List<RoleDto> roleDtoList) {
        if (CollectionUtils.isNotEmpty(roleDtoList)) {
            roleDtoList.forEach(res -> {
                RoleMenuVo roleMenuVo = new RoleMenuVo();
                roleMenuVo.setRoleId(res.getId());
                List<RoleMenuDto> roleMenuDtoList = roleMenuService.list(roleMenuVo);
                res.setRoleMenuDtoList(roleMenuDtoList);
            });
        }
    }
}
