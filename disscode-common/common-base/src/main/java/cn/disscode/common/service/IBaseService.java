package cn.disscode.common.service;

import cn.disscode.common.dto.BaseDto;
import cn.disscode.common.vo.BaseVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * IBaseService
 *
 * @Author: dumplingBao
 * @Date: 2021/8/11
 */
public interface IBaseService<T, D extends BaseDto, V extends BaseVo> extends IService<T> {

    /**
     * 分页查询
     * @param v
     * @return
     */
    IPage<D> page(V v);

    /**
     * list查询
     * @param v
     * @return
     */
    List<D> list(V v);

    /**
     * 保存
     * @param v
     * @return
     */
    D save(V v);

    /**
     * 条件查询一条数据
     * @param v
     * @return
     */
    D fetchOne(V v);

    /**
     * 主键查询数据
     * @param id
     * @return
     */
    D fetchById(String id);

    /**
     * 主键删除数据
     * @param id
     */
    Boolean deleteById(String id);

}
