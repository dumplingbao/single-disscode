package cn.disscode.app.service.impl;

import cn.disscode.app.dto.UserRoleDto;
import cn.disscode.app.repository.UserMapper;
import cn.disscode.app.domain.User;
import cn.disscode.app.dto.UserDto;
import cn.disscode.app.service.IUserRoleService;
import cn.disscode.app.service.IUserService;
import cn.disscode.app.vo.UserRoleVo;
import cn.disscode.app.vo.UserVo;
import cn.disscode.common.annotations.DataSource;
import cn.disscode.common.service.impl.IBaseServiceImpl;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @Author: dumplingBao
 * @Date: 2021/8/11
 */
@Service
@EqualsAndHashCode(callSuper=false)
public class UserServiceImpl extends IBaseServiceImpl<UserMapper, User, UserDto, UserVo> implements IUserService {

    @Autowired
    private IUserRoleService userRoleService;

    @Override
    @DataSource("READ")
    public List<UserDto> list(UserVo userVo) {
        return super.list(userVo);
    }

    @Override
    public Wrapper<User> beforePage(UserVo userVo) {
        if (userVo != null) {
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            if (StringUtils.isNotEmpty(userVo.getUsername())) {
                queryWrapper.lambda().eq(User::getUsername, userVo.getUsername());
            }
            /*
             * 用户名或邮箱的登录
            queryWrapper.lambda().and(i -> i.eq(User::getUsername, userVo.getUsername()).or().eq(User::getEmail, userVo.getEmail()));
             */
            return queryWrapper;
        }
        return Wrappers.emptyWrapper();
    }

    @Override
    public void afterPage(List<UserDto> userDtoList) {
        if (CollectionUtils.isNotEmpty(userDtoList)) {
            userDtoList.forEach(res -> {
                UserRoleVo userRoleVo = new UserRoleVo();
                userRoleVo.setUserId(res.getId());
                List<UserRoleDto> userRoleDtoList = userRoleService.list(userRoleVo);
                res.setUserRoleDtoList(userRoleDtoList);
            });
        }
    }

}
