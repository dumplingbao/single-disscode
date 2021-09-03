package cn.disscode.app.service.impl;

import cn.disscode.app.dao.UserMapper;
import cn.disscode.app.domain.User;
import cn.disscode.app.dto.UserDto;
import cn.disscode.app.service.IUserService;
import cn.disscode.app.vo.UserVo;
import cn.disscode.common.service.impl.IBaseServiceImpl;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;


/**
 * @Author: dumplingBao
 * @Date: 2021/8/11
 */
@Service
public class UserServiceImpl extends IBaseServiceImpl<UserMapper, User, UserDto, UserVo> implements IUserService {

    @Override
    public Wrapper<User> beforePage(UserVo userVo) {
        if (userVo != null) {
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            if (StringUtils.isNotEmpty(userVo.getUsername())) {
                queryWrapper.eq("username", userVo.getUsername());
            }
            return queryWrapper;
        }
        return Wrappers.emptyWrapper();
    }

}
