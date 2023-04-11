package com.springboot.c2.utils;

import java.io.Serializable;
import java.util.List;


/**
 * 
 * Copyright © 2018IPTV
 * 
 * @Title: IBaseEntityService.java 
 * @Project: iptv-core
 * @date: 2018年7月5日 下午9:09:14
 * @author: jack
 * @Description: TODO
 */
public interface IBaseEntityService {
    /**
     * 创建
     * @param entity
     * @param <T>
     */
    public <T> void create(T entity);

    /**
     * 更新
     * @param entity
     * @param <T>
     */
    public <T> void update(T entity);

    /**
     * 根据ID删除
     * @param id
     */
    public void removeById(Serializable id) ;


    /**
     * 根据ID批量删除
     * @param ids
     */
    public void removeByIds(Object[] ids);


    /**
     * 根据ID查询
     * @param id
     * @param <T>
     * @return
     */
    public <T> T get(Serializable id);

    /**
     * 查询所有
     * @return
     */
    public List getAll();

    /**
     * 根据条件查询所有
     * @return
     */
    public List getAll(ModelSetup setup);

    /**
     * 根据条件分页查询
     * @param modelSetup
     * @param pageNo
     * @param pageSize
     * @return
     */
    public Page pagedQuery(ModelSetup modelSetup, int pageNo, int pageSize);

    /**
     * 根据条件分页查询
     * @param modelSetup
     * @return
     */
    public Page pagedQuery(ModelSetup modelSetup);

    /**
     * 根据条件查询总记录
     * @param modelSetup
     * @return
     */
    public Integer getCount(ModelSetup modelSetup);

    /**
     * 查询所有总记录
     * @return
     */
    public Integer getCount();

    public String getIdName(Class clazz) ;

}
