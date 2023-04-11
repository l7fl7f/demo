package com.springboot.c2.entity;

import java.util.Date;

/**
 * @date: 2021-08-05 00:00
 * @author: lqf
 */
public class ProgramMovieMapping {
    private String id;
    private String elementType;
    private String movieCode;
    private String movieId;
    private String parentType;
    private String programCode;
    private String programId;
    private String provider;
    private String messageId;
    private String status;
    private Date createTime;
    private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getElementType() {
        return elementType;
    }

    public void setElementType(String elementType) {
        this.elementType = elementType;
    }

    public String getMovieCode() {
        return movieCode;
    }

    public void setMovieCode(String movieCode) {
        this.movieCode = movieCode;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getParentType() {
        return parentType;
    }

    public void setParentType(String parentType) {
        this.parentType = parentType;
    }

    public String getProgramCode() {
        return programCode;
    }

    public void setProgramCode(String programCode) {
        this.programCode = programCode;
    }

    public String getProgramId() {
        return programId;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
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
        return "ProgramMovieMapping{" +
                "id='" + id + '\'' +
                ", elementType='" + elementType + '\'' +
                ", movieCode='" + movieCode + '\'' +
                ", movieId='" + movieId + '\'' +
                ", parentType='" + parentType + '\'' +
                ", programCode='" + programCode + '\'' +
                ", programId='" + programId + '\'' +
                ", provider='" + provider + '\'' +
                ", messageId='" + messageId + '\'' +
                ", status='" + status + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
