package cn.disscode.app.service.impl;

import cn.disscode.app.domain.Group;
import cn.disscode.app.dto.GroupDto;
import cn.disscode.app.repository.GroupMapper;
import cn.disscode.app.service.IGroupService;
import cn.disscode.app.vo.GroupVo;
import cn.disscode.common.service.impl.IBaseServiceImpl;
import org.springframework.stereotype.Service;


/**
 * @Author: dumplingBao
 * @Date: 2021/9/20
 */
@Service
public class GroupServiceImpl extends IBaseServiceImpl<GroupMapper, Group, GroupDto, GroupVo> implements IGroupService {


}
