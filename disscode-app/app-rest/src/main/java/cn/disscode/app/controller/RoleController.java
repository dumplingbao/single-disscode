package cn.disscode.app.controller;

import cn.disscode.app.service.IRoleService;
import cn.disscode.app.vo.RoleVo;
import cn.disscode.common.controller.BaseController;
import cn.disscode.common.core.Result;
import cn.disscode.common.dto.BaseDto;
import cn.disscode.common.service.IBaseService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 角色信息
 *
 * @Author: dumplingBao
 * @Date: 2021/9/3
 */
@CrossOrigin
@RestController
@RequestMapping("/role")
@Slf4j
public class RoleController extends BaseController<RoleVo> {

    @Autowired
    private IRoleService roleService;

    @Override
    public IBaseService fetchBaseService() {
        return roleService;
    }

    /**
     * 保存
     *
     * @param roleVo
     * @return
     */
    @PostMapping(value = "/save")
    public Result<BaseDto> save(@RequestBody RoleVo roleVo) {
        return super.save(roleVo);
    }

    /**
     * 分页查询
     *
     * @param roleVo
     * @return
     */
    @PostMapping(value = "/page")
    public Result<IPage<BaseDto>> page(@RequestBody RoleVo roleVo) {
        return super.page(roleVo);
    }

    /**
     * 列表查询
     *
     * @param roleVo
     * @return
     */
    @PostMapping(value = "/list")
    public Result<List<BaseDto>> list(@RequestBody RoleVo roleVo) {
        log.info("role list");
        return super.list(roleVo);
    }

    /**
     * 根据ID查询
     *
     * @param roleVo
     * @return
     */
    @PostMapping(value = "/fetchById")
    public Result<BaseDto> fetchById(@RequestBody RoleVo roleVo) {
        return super.fetchById(roleVo.getId());
    }
}