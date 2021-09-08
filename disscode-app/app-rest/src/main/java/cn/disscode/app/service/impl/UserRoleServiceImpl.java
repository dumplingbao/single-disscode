package cn.disscode.app.service.impl;

import cn.disscode.app.dao.UserRoleMapper;
import cn.disscode.app.domain.UserRole;
import cn.disscode.app.dto.RoleDto;
import cn.disscode.app.dto.UserRoleDto;
import cn.disscode.app.service.IRoleService;
import cn.disscode.app.service.IUserRoleService;
import cn.disscode.app.vo.RoleVo;
import cn.disscode.app.vo.UserRoleVo;
import cn.disscode.common.service.impl.IBaseServiceImpl;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * @Author: dumplingBao
 * @Date: 2021/9/8
 */
@Service
public class UserRoleServiceImpl extends IBaseServiceImpl<UserRoleMapper, UserRole, UserRoleDto, UserRoleVo> implements IUserRoleService {

    @Autowired
    private IRoleService roleService;

    @Override
    public Wrapper<UserRole> beforeList(UserRoleVo userRoleVo) {
        if (userRoleVo != null) {
            QueryWrapper<UserRole> queryWrapper = new QueryWrapper<>();
            if (StringUtils.isNotEmpty(userRoleVo.getUserId())) {
                queryWrapper.eq("user_id", userRoleVo.getUserId());
            }
            return queryWrapper;
        }
        return Wrappers.emptyWrapper();
    }

    @Override
    public void afterList(List<UserRoleDto> userRoleDtoList){
        if (CollectionUtils.isNotEmpty(userRoleDtoList)) {
            userRoleDtoList.forEach(res ->{
                RoleDto roleDto = roleService.fetchById(res.getRoleId());
                res.setRoleDto(roleDto);
            });
        }
    }
}
