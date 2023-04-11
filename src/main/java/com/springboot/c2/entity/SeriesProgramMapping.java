package com.springboot.c2.entity;

import java.util.Date;

/**
 * @date: 2021-08-05 00:00
 * @author: lqf
 */
public class SeriesProgramMapping {
    private String id;
    private String domainType;
    private String elementType;
    private String episodeCode;
    private String episodeId;
    private String provider;
    private String sequence;
    private String seriesCode;
    private String seriesId;
    private String status;
    private Date createTime;
    private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDomainType() {
        return domainType;
    }

    public void setDomainType(String domainType) {
        this.domainType = domainType;
    }

    public String getElementType() {
        return elementType;
    }

    public void setElementType(String elementType) {
        this.elementType = elementType;
    }

    public String getEpisodeCode() {
        return episodeCode;
    }

    public void setEpisodeCode(String episodeCode) {
        this.episodeCode = episodeCode;
    }

    public String getEpisodeId() {
        return episodeId;
    }

    public void setEpisodeId(String episodeId) {
        this.episodeId = episodeId;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public String getSeriesCode() {
        return seriesCode;
    }

    public void setSeriesCode(String seriesCode) {
        this.seriesCode = seriesCode;
    }

    public String getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(String seriesId) {
        this.seriesId = seriesId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "SeriesProgramMapping{" +
                "id='" + id + '\'' +
                ", domainType='" + domainType + '\'' +
                ", elementType='" + elementType + '\'' +
                ", episodeCode='" + episodeCode + '\'' +
                ", episodeId='" + episodeId + '\'' +
                ", provider='" + provider + '\'' +
                ", sequence='" + sequence + '\'' +
                ", seriesCode='" + seriesCode + '\'' +
                ", seriesId='" + seriesId + '\'' +
                ", status='" + status + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
