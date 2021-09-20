package cn.disscode.app.controller;

import cn.disscode.app.service.IPositionService;
import cn.disscode.app.vo.MenuVo;
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
 * 岗位信息
 *
 * @Author: dumplingBao
 * @Date: 2021/9/20
 */
@CrossOrigin
@RestController
@RequestMapping("/position")
@Slf4j
public class PositionController extends BaseController<MenuVo> {

    @Autowired
    private IPositionService positionService;

    @Override
    public IBaseService fetchBaseService() {
        return positionService;
    }

    /**
     * 保存
     *
     * @param menuVo
     * @return
     */
    @PostMapping(value = "/save")
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
    public Result<BaseDto> fetchById(@RequestBody MenuVo menuVo) {
        return super.fetchById(menuVo.getId());
    }
}