package com.springboot.c2.entity;

/**
 * Copyright © 2018IPTV
 * 
 * @Title: image_media_mapping
 * @Project: 
 * @date: 2018-08-29 11:44
 * @author: 
 * @Description: image_media_mapping
 */
public class ImageMediaMapping extends Entity<Integer> {
    /**
     * 自增主键
     */
    private Integer id;

    /**
     * 图片ID(images表id)
     */
    private String imgId;

    /**
     * 图片Code(images表code)
     */
    private String imgCode;

    /**
     * 媒资ID(media_vod表id)
     */
    private String mediaId;

    /**
     * 媒资Code(media_vod表code)
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

    public ImageMediaMapping() {
    }

    public ImageMediaMapping(String imgId, String imgCode, String mediaId, String mediaCode, String imgType, String sequence) {
        this.imgId = imgId;
        this.imgCode = imgCode;
        this.mediaId = mediaId;
        this.mediaCode = mediaCode;
        this.imgType = imgType;
        this.sequence = sequence;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImgId() {
        return imgId;
    }

    public void setImgId(String imgId) {
        this.imgId = imgId;
    }

    public String getImgCode() {
        return imgCode;
    }

    public void setImgCode(String imgCode) {
        this.imgCode = imgCode;
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
}