package cn.disscode.app.controller;

import cn.disscode.app.service.IGroupService;
import cn.disscode.app.vo.MenuVo;
import cn.disscode.common.controller.BaseController;
import cn.disscode.common.core.Result;
import cn.disscode.common.dto.BaseDto;
import cn.disscode.common.service.IBaseService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户组信息
 *
 * @Author: dumplingBao
 * @Date: 2021/9/20
 */
@CrossOrigin
@RestController
@RequestMapping("/group")
@Slf4j
@Api(tags ="用户组")
public class GroupController extends BaseController<MenuVo> {

    @Autowired
    private IGroupService groupService;

    @Override
    public IBaseService fetchBaseService() {
        return groupService;
    }

    /**
     * 保存
     *
     * @param menuVo
     * @return
     */
    @PostMapping(value = "/save")
    @ApiOperation("保存")
    public Result<BaseDto> save(@RequestBody MenuVo menuVo) {
        return super.save(menuVo);
    }

    /**
     * 分页查询
     *
     * @param menuVo
     * @return
     */
    @PostMapping(value = "/page")
    @ApiOperation("分页查询")
    public Result<IPage<BaseDto>> page(@RequestBody MenuVo menuVo) {
        return super.page(menuVo);
    }

    /**
     * 列表查询
     *
     * @param menuVo
     * @return
     */
    @PostMapping(value = "/list")
    @ApiOperation("列表查询")
    public Result<List<BaseDto>> list(@RequestBody MenuVo menuVo) {
        log.info("menu list");
        return super.list(menuVo);
    }

    /**
     * 根据ID查询
     *
     * @param menuVo
     * @return
     */
    @PostMapping(value = "/fetchById")
    @ApiOperation("根据ID查询")
    public Result<BaseDto> fetchById(@RequestBody MenuVo menuVo) {
        return super.fetchById(menuVo.getId());
    }
}