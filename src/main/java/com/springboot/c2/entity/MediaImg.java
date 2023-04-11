package com.springboot.c2.entity;

/**
 * Copyright © 2018IPTV
 *
 * @Title: MediaImg
 * @Project: smp-core
 * @Date: 2018-08-29 11:52
 * @Author: yangbo
 * @Description:
 */
public class MediaImg extends Images{
    /**
     * image_media_mapping id
     */
    private int imageMediaMappingId;

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

    public int getImageMediaMappingId() {
        return imageMediaMappingId;
    }

    public void setImageMediaMappingId(int imageMediaMappingId) {
        this.imageMediaMappingId = imageMediaMappingId;
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
