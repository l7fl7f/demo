package com.springboot.c2.entity;


/**
 * Copyright © 2018IPTV
 * 
 * @Title: media_service_mapping
 * @Project: 
 * @date: 2018-10-16 09:57
 * @author: 
 * @Description: media_service_mapping
 */
public class MediaServiceMapping extends Entity<Integer> {
    /**
     * 自增主键
     */
    private Integer id;

    /**
     * 媒资id
     */
    private String mediaId;

    /**
     * 媒资code
     */
    private String mediaCode;

    /**
     * 服务id
     */
    private String serviceId;

    /**
     * 服务code
     */
    private String serviceCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        MediaServiceMapping other = (MediaServiceMapping) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMediaId() == null ? other.getMediaId() == null : this.getMediaId().equals(other.getMediaId()))
            && (this.getMediaCode() == null ? other.getMediaCode() == null : this.getMediaCode().equals(other.getMediaCode()))
            && (this.getServiceId() == null ? other.getServiceId() == null : this.getServiceId().equals(other.getServiceId()))
            && (this.getServiceCode() == null ? other.getServiceCode() == null : this.getServiceCode().equals(other.getServiceCode()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMediaId() == null) ? 0 : getMediaId().hashCode());
        result = prime * result + ((getMediaCode() == null) ? 0 : getMediaCode().hashCode());
        result = prime * result + ((getServiceId() == null) ? 0 : getServiceId().hashCode());
        result = prime * result + ((getServiceCode() == null) ? 0 : getServiceCode().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", mediaId=").append(mediaId);
        sb.append(", mediaCode=").append(mediaCode);
        sb.append(", serviceId=").append(serviceId);
        sb.append(", serviceCode=").append(serviceCode);
        sb.append("]");
        return sb.toString();
    }
}