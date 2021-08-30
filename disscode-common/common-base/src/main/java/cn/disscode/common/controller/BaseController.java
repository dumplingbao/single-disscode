package cn.disscode.common.controller;

import cn.disscode.common.core.Result;
import cn.disscode.common.dto.BaseDto;
import cn.disscode.common.service.IBaseService;
import cn.disscode.common.vo.BaseVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * BaseController
 *
 * @Author: dumplingbao
 * @Date: 2021/8/11
 */
public abstract class BaseController<V extends BaseVo> {

    @Autowired
    public ApplicationContext applicationContext;

    protected abstract IBaseService fetchBaseService();

    public Result<BaseDto> save(@RequestBody V v) {
        BaseDto baseDto = this.fetchBaseService().save(v);
        return Result.success(baseDto);
    }

    /**
     * 分页查询
     * @param v
     * @return
     */
    public Result<IPage<BaseDto>> page(@RequestBody V v) {
        IPage<BaseDto> pageQueryResult = this.fetchBaseService().page(v);
        return Result.success(pageQueryResult);
    }

    /**
     * list查询
     * @param v
     * @return
     */
    public Result<List<BaseDto>> list(@RequestBody V v) {
        List<BaseDto> listQueryResult = this.fetchBaseService().list(v);
        return Result.success(listQueryResult);
    }

    /**
     * 条件查询一条数据
     * @param v
     * @return
     */
    public Result<BaseDto> fetchOne(@RequestBody V v) {
        BaseDto baseDto = this.fetchBaseService().fetchOne(v);
        return Result.success(baseDto);
    }

    /**
     * 根据ID获取数据
     * @param id
     * @return
     */
    public Result<BaseDto> fetchById(String id) {
        BaseDto baseDto = this.fetchBaseService().fetchById(id);
        return Result.success(baseDto);
    }

    /**
     * 根据ID删除数据
     * @param id
     * @return
     */
    public Result<Boolean> deleteById(String id) {
        Boolean result = this.fetchBaseService().deleteById(id);
        return Result.success(result);
    }
}
