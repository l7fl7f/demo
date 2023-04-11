package com.springboot.c2.entity;

/**
 * Copyright © 2018IPTV
 * 
 * @Title: media_cast_mapping
 * @Project: 
 * @date: 2018-08-30 17:36
 * @author: 
 * @Description: media_cast_mapping
 */
public class MediaCastMapping extends Entity<Integer> {
    /**
     * 自增主键
     */
    private Integer id;

    /**
     * 角色ID(C2下发)
     */
    private String roleId;

    /**
     * 角色Code(C2下发)
     */
    private String roleCode;

    /**
     * 媒资ID(C2下发)
     */
    private String mediaId;

    /**
     * 媒资Code(C2下发)
     */
    private String mediaCode;

    /**
     * 图片类型(C2接口mapping对应)
     */
    private String imgType;

    /**
     * 序列号(C2接口mapping对应)
     */
    private String sequence;

    /**
     * 演员角色
     */
    private String castRole;

    /**
     * 人物名称
     */
    private String name;

    /**
     * 显示名称
     */
    private String personDisplayName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
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

    public String getImgType() {
        return imgType;
    }

    public void setImgType(String imgType) {
        this.imgType = imgType;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public String getCastRole() {
        return castRole;
    }

    public void setCastRole(String castRole) {
        this.castRole = castRole;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPersonDisplayName() {
        return personDisplayName;
    }

    public void setPersonDisplayName(String personDisplayName) {
        this.personDisplayName = personDisplayName;
    }
}