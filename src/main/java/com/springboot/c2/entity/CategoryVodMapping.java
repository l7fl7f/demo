package com.springboot.c2.entity;

import java.util.Date;

/**
 * Copyright © 2018IPTV
 * 
 * @Title: category_vod_mapping
 * @Project: 
 * @date: 2018-08-28 10:41
 * @author: 
 * @Description: category_vod_mapping
 */
public class CategoryVodMapping extends Entity<Integer> {
    /**
     * 自增主键
     */
    private Integer id;

    /**
     * 栏目id
     */
    private String categoryId;

    /**
     * 栏目code
     */
    private String categoryCode;

    /**
     * 媒资id
     */
    private String mediaId;

    /**
     * 媒资code
     */
    private String mediaCode;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date modifyTime;

    /**
     * 序列号
     */
    private String sequence;

    private String title;

    private String metaId;

    private String type;

    private String definitionFlag;

    private Integer vodId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getMediaCode() {
        return mediaCode;
    }

    public void setMediaCode(String mediaCode) {
        this.mediaCode = mediaCode;
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

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMetaId() {
        return metaId;
    }

    public void setMetaId(String metaId) {
        this.metaId = metaId;
    }

    public String getDefinitionFlag() {
        return definitionFlag;
    }

    public void setDefinitionFlag(String definitionFlag) {
        this.definitionFlag = definitionFlag;
    }

    public Integer getVodId() {
        return vodId;
    }

    public void setVodId(Integer vodId) {
        this.vodId = vodId;
    }
}