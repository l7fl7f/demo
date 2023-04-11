package com.springboot.c2.utils;

import com.github.pagehelper.PageHelper;
import com.springboot.c2.dao.IEntityDao;
import com.springboot.c2.entity.Entity;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("unchecked")
public abstract class BaseEntityService<T extends Entity> implements IBaseEntityService{
    public Class<T> getEntityClass() {
        if (entityClass == null)
            entityClass = (Class<T>) GenericsUtil.getSuperClassGenricType(getClass());
        return entityClass;
    }

    protected Class<T> entityClass;

    protected String getEntityName() {
        return getEntityClass().getSimpleName();
    }

    abstract protected IEntityDao<T> getDao();
    
    public  void create(Object entity) {
        getDao().insert(entity);
    }

    @Override
    public void update(Object entity) {
        getDao().updateByPrimaryKeySelective(entity);
    }

    @Override
    public void removeById(Serializable id) {
        getDao().deleteByPrimaryKey(id);
    }

    @Override
    public void removeByIds(Object[] ids) {
        getDao().deleteByPrimaryKeys(ids);
    }

    @Override
    public T get(Serializable id) {
        return  getDao().selectByPrimaryKey(id);
    }

    @Override
    public List getAll() {
        return getDao().selectAll(new DefaultModelSetup());
    }

    @Override
    public List getAll(ModelSetup setup) {
        return getDao().selectAll(setup);
    }

    @Override
    public Page pagedQuery(ModelSetup setup, int pageNo, int pageSize) {
        Page page = new Page();
        if(setup instanceof MyBatisModelSetup) { //mybatis分页
            //不需要指定countSql，PageHelper会自动根据selectSql生成countSql
            PageHelper.startPage(pageNo, pageSize); //保证此方法后面要跟getDao()消费掉，否则这个参数会一直保留在这个线程上
            com.github.pagehelper.Page pageList = getDao().query(setup);
            page = new Page(pageList.getStartRow(), pageList.getTotal(), pageList.getPageSize(), pageList);
        }
        return page;
    }

    @Override
    public Page pagedQuery(ModelSetup setup) {
        int pageNo = setup.getPageNo();
        int pageSize = setup.getPageSize();
        return pagedQuery(setup,pageNo,pageSize);
    }

    @Override
    public Integer getCount(ModelSetup setup) {
        return  getDao().count(setup);
    }

    @Override
    public Integer getCount() {
        return  getDao().count(new DefaultModelSetup());
    }

    public String getIdName(Class clazz) {
        return getDao().getIdName(clazz);
    }

}
