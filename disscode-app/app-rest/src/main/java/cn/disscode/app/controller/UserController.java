package cn.disscode.app.controller;

import cn.disscode.app.service.IUserService;
import cn.disscode.app.vo.UserVo;
import cn.disscode.common.annotations.ParamLog;
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
 * 用户信息
 *
 * @Author: dumplingBao
 * @Date: 2021/8/11
 */
@CrossOrigin
@RestController
@RequestMapping("/user")
@Slf4j
@Api(tags ="用户")
public class UserController extends BaseController<UserVo> {

    @Autowired
    private IUserService userService;

    @Override
    public IBaseService fetchBaseService() {
        return userService;
    }

    /**
     * 保存
     *
     * @param userVo
     * @return
     */
    @PostMapping(value = "/save")
    @ApiOperation("保存")
    public Result<BaseDto> save(@RequestBody UserVo userVo) {
        return super.save(userVo);
    }

    /**
     * 分页查询
     *
     * @param userVo
     * @return
     */
    @PostMapping(value = "/page")
    @ParamLog
//    @DataSource("READ")
    @ApiOperation("分页查询")
    public Result<IPage<BaseDto>> page(@RequestBody UserVo userVo) {
        return super.page(userVo);
    }

    /**
     * 列表查询
     *
     * @param userVo
     * @return
     */
    @PostMapping(value = "/list")
//    @DataSource("WRITE")
    @ApiOperation("列表查询")
    public Result<List<BaseDto>> list(@RequestBody UserVo userVo) {
        log.info("user list");
        return super.list(userVo);
    }

    /**
     * 根据ID查询
     *
     * @param userVo
     * @return
     */
    @PostMapping(value = "/fetchById")
    @ApiOperation("根据ID查询")
    public Result<BaseDto> fetchById(@RequestBody UserVo userVo) {
        return super.fetchById(userVo.getId());
    }
}