package cn.disscode.common.service.impl;

import cn.disscode.common.constant.ExceptionConstant;
import cn.disscode.common.core.Result;
import cn.disscode.common.domain.BaseDomain;
import cn.disscode.common.dto.BaseDto;
import cn.disscode.common.exception.BusinessException;
import cn.disscode.common.exception.InvalidArgumentException;
import cn.disscode.common.service.IBaseService;
import cn.disscode.common.utils.ValidationUtils;
import cn.disscode.common.vo.BaseVo;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;


/**
 * IBaseServiceImpl
 *
 * @Author: dumplingbao
 * @Date: 2021/8/11
 */
@Slf4j
public class IBaseServiceImpl<M extends BaseMapper<T>, T extends BaseDomain, D extends BaseDto, V extends BaseVo> extends ServiceImpl<M, T> implements IBaseService<T, D, V> {

    /**
     * Entity泛型对应的实际class
     */
    private Class<T> entityClass;

    /**
     * DTO泛型对应的实际class
     */
    private Class<D> dtoClass;


    @SuppressWarnings("unchecked")
    public IBaseServiceImpl() {
        super();
        this.entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        this.dtoClass = (Class<D>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[2];
    }

    /**
     * 对Dto泛型对应class实例化
     * @param clazz
     * @return
     */
    private D createDto(Class<D> clazz){
        try {
            D d = clazz.newInstance();
            return d;
        } catch (Exception e) {
            log.error("Dto实例化出错", e);
        }
        return null;
    }

    /**
     * 对Entity泛型对应class实例化
     * @param clazz
     * @return
     */
    private T createEntity(Class<T> clazz){
        try {
            T t = clazz.newInstance();
            return t;
        } catch (Exception e) {
            log.error("Entity实例化出错", e);
        }
        return null;
    }

    /**
     * Entity转DTO
     */
    private D convertEntityToDTO(T t) {
        D d = createDto(dtoClass);
        BeanUtils.copyProperties(t, d);
        return d;
    }

    /**
     * 分页查询
     * @param v
     * @return
     */
    @Override
    public IPage<D> page(V v) {
        Wrapper<T> queryWrapper = this.beforePage(v);
        if (queryWrapper == null) {
            queryWrapper = Wrappers.emptyWrapper();
        }
        IPage<T> entityPage = super.page(v, queryWrapper);
        List<T> entityList = entityPage.getRecords();
        List<D> dtoList = this.entityListToDtoList(entityList);

        Page<D> dtoPage = new Page(entityPage.getCurrent(), entityPage.getSize(), entityPage.getTotal(), entityPage.isSearchCount());
        dtoPage.setRecords(dtoList);
        this.afterPage(dtoPage.getRecords());
        return dtoPage;
    }

    /**
     * 分页查询前逻辑处理
     * @param v
     * @return
     */
    protected Wrapper<T> beforePage(V v){
        return Wrappers.emptyWrapper();
    }

    /**
     * 分页查询结果逻辑处理
     * @param dtoList
     */
    protected void afterPage(List<D> dtoList) {}

    /**
     * list查询
     * @param v
     * @return
     */
    @Override
    public List<D> list(V v) {
        Wrapper<T> queryWrapper = this.beforeList(v);
        if (queryWrapper == null) {
            queryWrapper = Wrappers.emptyWrapper();
        }
        List<T> entityList = super.list(queryWrapper);
        List<D> dtoList = this.entityListToDtoList(entityList);
        this.afterList(dtoList);
        return dtoList;
    }

    /**
     * list查询前逻辑处理
     * @param v
     * @return
     */
    protected Wrapper<T> beforeList(V v) {
        v.setCurrent(1);
        // 限制最大查询行数
        v.setSize(100);
        // 复用分页查询的条件组装逻辑
        return this.beforePage(v);
    }

    /**
     * list查询结果逻辑处理
     * @param dtoList
     */
    protected void afterList(List<D> dtoList) {
        this.afterPage(dtoList);
    }

    /**
     * 保存
     * @param v
     * @return
     */
    @Override
    public D save(V v) {
        this.beforeSave(v);
        T t = this.voToEntity(v);
        Result validateResult = null;
        if (StringUtils.isBlank(t.getId())) {
            validateResult = ValidationUtils.validate(t, ValidationUtils.Insert.class);
        } else {
            validateResult = ValidationUtils.validate(t, ValidationUtils.Update.class);
        }
        if (!validateResult.isSuccess()) {
            throw new InvalidArgumentException(validateResult.getMsg());
        }
        boolean result = super.saveOrUpdate(t);
        if (result) {
            v.setId(t.getId());
            this.afterSave(v);
            return convertEntityToDTO(t);
        } else {
            log.info("保存或更新失败", JSON.toJSONString(v));
            return null;
        }
    }

    /**
     * 保存前逻辑处理里
     * @param v
     */
    protected void beforeSave(V v) {}

    /**
     * 保存后逻辑处理
     * @param v
     */
    protected void afterSave(V v) {}

    @Override
    public D fetchOne(V v) {
        List<D> listQueryResult = this.list(v);
        if (!CollectionUtils.isEmpty(listQueryResult)) {
            return listQueryResult.get(0);
        }
        return null;
    }

    @Override
    public D fetchById(String id) {
        if (StringUtils.isBlank(id)) {
            throw new InvalidArgumentException(ExceptionConstant.ID_IS_NOT_NULL);
        }
        T t = this.getById(id);
        if (t != null) {
            D d = this.convertEntityToDTO(t);
            this.afterFetchById(d);
            return d;
        }
        return null;
    }
    protected void afterFetchById(D d) {
        return;
    }

    @Override
    public Boolean deleteById(String id) {
        if (StringUtils.isBlank(id)) {
            throw new InvalidArgumentException(ExceptionConstant.ID_IS_NOT_NULL);
        }
        Result result = beforeDeleteById(id);
        if (!result.isSuccess()) {
            throw new InvalidArgumentException(result.getMsg());
        }
        return this.removeById(id);
    }
    protected Result beforeDeleteById(String id) {
        return Result.success(id);
    }

    /**
     * Vo转Entity
     * @param v
     * @return
     */
    T voToEntity(V v) {
        String id = v.getId();
        T t = null;
        if (StringUtils.isBlank(id)) {
            t = this.createEntity(entityClass);
            BeanUtil.copyProperties(v, t);
        } else {
            t = getById(id);
            if (t == null) {
                throw new InvalidArgumentException(ExceptionConstant.ID_IS_NOT_EXIT);
            }
            try {
                BeanUtil.copyProperties(v, t, CopyOptions.create().setIgnoreProperties("id", "create_time").setIgnoreNullValue(true));
            } catch (BeansException e) {
                log.error("BeanCopy出错", e);
                throw new BusinessException();
            }
        }
        return t;
    }

    /**
     * EntityList转DTOList
     */
    private List<D> entityListToDtoList(List<T> entityResultList) {
        List<D> dtoResultList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(entityResultList)) {
            Integer index = 1;
            for (T t : entityResultList) {
                D d = convertEntityToDTO(t);
                d.setIndex(index);
                index = index + 1;
                dtoResultList.add(d);
            }
        }
        return dtoResultList;
    }

}
