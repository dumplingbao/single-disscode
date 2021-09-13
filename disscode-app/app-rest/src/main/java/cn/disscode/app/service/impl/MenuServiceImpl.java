package cn.disscode.app.service.impl;

import cn.disscode.app.domain.Menu;
import cn.disscode.app.dto.MenuDto;
import cn.disscode.app.repository.MenuMapper;
import cn.disscode.app.service.IMenuService;
import cn.disscode.app.vo.MenuVo;
import cn.disscode.common.service.impl.IBaseServiceImpl;
import org.springframework.stereotype.Service;


/**
 * @Author: dumplingBao
 * @Date: 2021/9/13
 */
@Service
public class MenuServiceImpl extends IBaseServiceImpl<MenuMapper, Menu, MenuDto, MenuVo> implements IMenuService {


}
