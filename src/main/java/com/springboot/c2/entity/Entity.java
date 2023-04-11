package com.springboot.c2.entity;

import java.io.Serializable;

/**
 * 
 * Copyright © 2018IPTV
 * 
 * @Title: Entity.java 
 * @Project: iptv-core
 * @date: 2018年7月5日 下午9:05:59
 * @author: jack
 * @Description: TODO
 */
@SuppressWarnings("serial")
public abstract class Entity<T> implements Serializable{
	/**
	 * 统一的ID声明
	 * 
	 */
    private T id;

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }
}
