package com.springboot.c2.entity;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Copyright © 2018IPTV
 *
 * @Title: images
 * @Project:
 * @date: 2018-08-29 11:43
 * @author:
 * @Description: images
 */
public class Images extends Entity<String> {
    /**
     * 主键(C2下发)
     */
    private String id;

    /**
     * 全局Code(C2下发)
     */
    private String code;

    /**
     * 图片地址(mop://)
     */
    private String url;

    /**
     * 图片类型
     */
    private String type;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date modifyTime;

    /**
     * 描述
     */
    private String description;

    /**
     * 业务类型
     * 0：IPTV业务 （默认） 1：MOBILE业务  2：PC业务 3：IPTV和PC业务
     */
    private String bizDomain;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBizDomain() {
        return bizDomain;
    }

    public void setBizDomain(String bizDomain) {
        this.bizDomain = bizDomain;
    }

    public Map<String, Object> toMap(Map<String, String> type) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("code", code);
        map.put("url", url);
        map.put("type", type);
        map.put("bizDomain", bizDomain);
        return map;
    }
}