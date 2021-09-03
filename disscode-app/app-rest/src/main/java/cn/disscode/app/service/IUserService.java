package cn.disscode.app.service;

import cn.disscode.app.domain.User;
import cn.disscode.app.dto.UserDto;
import cn.disscode.app.vo.UserVo;
import cn.disscode.common.service.IBaseService;

/**
 * @Author: dumplingBao
 * @Date: 2021/8/11
 */
public interface IUserService extends IBaseService<User, UserDto, UserVo> {
}
