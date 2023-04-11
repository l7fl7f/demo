package com.springboot.c2.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Copyright © 2018IPTV
 * 
 * @Title: Page.java 
 * @Project: iptv-core
 * @date: 2018年7月5日 下午4:50:33
 * @author: jack
 * @Description: 分页信息
 */
public class Page<T> implements Serializable{
	/**
     * 默认分页数.
     */
    public static final int DEFAULT_PAGE_SIZE = 10;

    /**
     * 每页的记录数.
     */
    private int pageSize = DEFAULT_PAGE_SIZE;

    /**
     * 当前页第一条数据在List中的位置,从0开始.
     */
    private int start;

    /**
     * 当前页中存放的记录,类型一般为List.
     */
    @SuppressWarnings("unchecked")
	private List<T> data;

    /**
     * 总记录数.
     */
    private long totalCount;

    /**
     * 构造方法，只构造空页.
     */

    public Page() {
        this(0, 0, DEFAULT_PAGE_SIZE, new ArrayList<>());
    }

    /**
     * 默认构造方法.
     *
     * @param startIn     本页数据在数据库中的起始位置
     * @param totalCountIn 数据库中总记录条数
     * @param pageSizeIn  本页容量
     * @param dataIn      本页包含的数据
     */
    @SuppressWarnings("unchecked")
	public Page(int startIn, long totalCountIn, int pageSizeIn, List<T> dataIn) {
        pageSize = pageSizeIn;
        start = startIn;
        totalCount = totalCountIn;
        data = dataIn;
    }

    /**
     * @return long 总记录数.
     */
    public long getTotalCount() {
        return totalCount;
    }
    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * @return long 总页数.
     */
    public int getPageCount() {
        long lPageSize = (long)pageSize;
        long lPageCount = 0;
        if ((totalCount % pageSize) == 0) {
            lPageCount = totalCount / lPageSize;
        } else {
            lPageCount = (totalCount / lPageSize) + 1;
        }
        return (int)lPageCount;
    }

    /**
     * @return int 每页记录数.
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * @return Object 本页包含的数据.
     */
    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    /**
     * @return long 当前页码，从1开始.
     */
    public long getPageNo() {
        return (start / pageSize) + 1;
    }

    /**
     * @return boolean 是否有下一页
     */
    public boolean hasNextPage() {
        return this.getPageNo() < this.getPageCount();
    }

    /**
     * @return boolean 是否有上一页
     */
    public boolean hasPreviousPage() {
        return this.getPageNo() > 1;
    }

    /**
     * 获取任一页第一条数据在数据集的位置，每页条数使用默认值.
     *
     * @see #getStartOfPage(int,int)
     * @param pageNo 页码
     * @return int 第一条记录的位置
     */
    protected int getStartOfPage(int pageNo) {
        return getStartOfPage(pageNo, DEFAULT_PAGE_SIZE);
    }

    /**
     * 获取任一页第一条数据在数据集的位置.
     *
     * @param pageNo   从1开始的页号
     * @param pageSize 每页记录条数
     * @return 该页第一条数据
     */
    public int getStartOfPage(int pageNo, int pageSize) {
        return (pageNo - 1) * pageSize;
    }

    public long getStart() {
        return start;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageSize=" + pageSize +
                ",pageNo=" + this.getPageNo() +
                ",totalCount=" + totalCount +
                ",pageCount=" + this.getPageCount() +
                ",start=" + start +
                ",hasNextPage=" + this.hasNextPage() +
                ",hasPreviousPage=" + this.hasPreviousPage() +
                ",dataSize =" + (data!=null ? data.size():0) +
                '}';
    }


}
