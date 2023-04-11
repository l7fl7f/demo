package com.springboot.c2.dao;

import com.github.pagehelper.Page;
import com.springboot.c2.utils.ModelSetup;

import java.io.Serializable;
import java.util.List;

public interface IEntityDao<T> {
	T selectByPrimaryKey(Serializable id);

    List<T> selectAll();

    List<T> selectAll(ModelSetup setup);

    void updateByPrimaryKeySelective(Object o);

    void insert(Object o);

    void deleteByPrimaryKey(Serializable id);

    /**
     * 根据id批量删除
     * @param ids
     */
    void deleteByPrimaryKeys(Object[] ids);

    /**
     * 获取Entity对象的主键名.
     * @param clazz
     * @return
     */
    String getIdName(Class clazz);

    /**
     * 查询总记录
     * @param setup
     * @return
     */
    Integer count(ModelSetup setup);

    /**
     * 查询
     * @param setup
     * @return
     */
    Page query(ModelSetup setup);
}
