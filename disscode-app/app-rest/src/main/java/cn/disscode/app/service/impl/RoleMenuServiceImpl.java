package cn.disscode.app.service.impl;

import cn.disscode.app.domain.RoleMenu;
import cn.disscode.app.dto.MenuDto;
import cn.disscode.app.dto.RoleMenuDto;
import cn.disscode.app.repository.RoleMenuMapper;
import cn.disscode.app.service.IMenuService;
import cn.disscode.app.service.IRoleMenuService;
import cn.disscode.app.vo.RoleMenuVo;
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
 * @Date: 2021/9/13
 */
@Service
public class RoleMenuServiceImpl extends IBaseServiceImpl<RoleMenuMapper, RoleMenu, RoleMenuDto, RoleMenuVo> implements IRoleMenuService {

    @Autowired
    private IMenuService menuService;

    @Override
    public Wrapper<RoleMenu> beforeList(RoleMenuVo roleMenuVo) {
        if (roleMenuVo != null) {
            QueryWrapper<RoleMenu> queryWrapper = new QueryWrapper<>();
            if (StringUtils.isNotEmpty(roleMenuVo.getRoleId())) {
                queryWrapper.eq("role_id", roleMenuVo.getRoleId());
            }
            return queryWrapper;
        }
        return Wrappers.emptyWrapper();
    }

    @Override
    public void afterList(List<RoleMenuDto> roleMenuDtoList){
        if (CollectionUtils.isNotEmpty(roleMenuDtoList)) {
            roleMenuDtoList.forEach(res ->{
                MenuDto menuDto = menuService.fetchById(res.getMenuId());
                res.setMenuDto(menuDto);
            });
        }
    }
}
