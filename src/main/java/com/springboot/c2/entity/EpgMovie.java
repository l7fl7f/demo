package com.springboot.c2.entity;

public class EpgMovie {
    private String id;
    private String code;
    private String audioFormat;
    private String audioType;
    private String bitrateType;
    private String closedCaptioning;
    private String destDrmType;
    private String domainType;
    private String duration;
    private String elementType;
    private String errorMsg;
    private String fileSize;
    private String fileUrl;
    private String name;
    private String nextTime;
    private String ocsUrl;
    private String provider;
    private String resolution;
    private String screenFormat;
    private String serviceType;
    private String sourceDrmType;
    private String state;
    private String systemLayer;
    private String type;
    private String videoProfile;
    private String videoType;
    private String bizDomain;
    private String messageId;
    private String storePath;
    private String createTime;
    private String updateTime;

    private String movieId;
    private String movieCode;
    private String videoFormat;

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

    public String getAudioFormat() {
        return audioFormat;
    }

    public void setAudioFormat(String audioFormat) {
        this.audioFormat = audioFormat;
    }

    public String getAudioType() {
        return audioType;
    }

    public void setAudioType(String audioType) {
        this.audioType = audioType;
    }

    public String getBitrateType() {
        return bitrateType;
    }

    public void setBitrateType(String bitrateType) {
        this.bitrateType = bitrateType;
    }

    public String getClosedCaptioning() {
        return closedCaptioning;
    }

    public void setClosedCaptioning(String closedCaptioning) {
        this.closedCaptioning = closedCaptioning;
    }

    public String getDestDrmType() {
        return destDrmType;
    }

    public void setDestDrmType(String destDrmType) {
        this.destDrmType = destDrmType;
    }

    public String getDomainType() {
        return domainType;
    }

    public void setDomainType(String domainType) {
        this.domainType = domainType;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getElementType() {
        return elementType;
    }

    public void setElementType(String elementType) {
        this.elementType = elementType;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNextTime() {
        return nextTime;
    }

    public void setNextTime(String nextTime) {
        this.nextTime = nextTime;
    }

    public String getOcsUrl() {
        return ocsUrl;
    }

    public void setOcsUrl(String ocsUrl) {
        this.ocsUrl = ocsUrl;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getScreenFormat() {
        return screenFormat;
    }

    public void setScreenFormat(String screenFormat) {
        this.screenFormat = screenFormat;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getSourceDrmType() {
        return sourceDrmType;
    }

    public void setSourceDrmType(String sourceDrmType) {
        this.sourceDrmType = sourceDrmType;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getSystemLayer() {
        return systemLayer;
    }

    public void setSystemLayer(String systemLayer) {
        this.systemLayer = systemLayer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVideoProfile() {
        return videoProfile;
    }

    public void setVideoProfile(String videoProfile) {
        this.videoProfile = videoProfile;
    }

    public String getVideoType() {
        return videoType;
    }

    public void setVideoType(String videoType) {
        this.videoType = videoType;
    }

    public String getBizDomain() {
        return bizDomain;
    }

    public void setBizDomain(String bizDomain) {
        this.bizDomain = bizDomain;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getStorePath() {
        return storePath;
    }

    public void setStorePath(String storePath) {
        this.storePath = storePath;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getMovieCode() {
        return movieCode;
    }

    public void setMovieCode(String movieCode) {
        this.movieCode = movieCode;
    }

    public String getVideoFormat() {
        return videoFormat;
    }

    public void setVideoFormat(String videoFormat) {
        this.videoFormat = videoFormat;
    }

    @Override
    public String toString() {
        return "EpgMovie{" +
                "id='" + id + '\'' +
                ", code='" + code + '\'' +
                ", audioFormat='" + audioFormat + '\'' +
                ", audioType='" + audioType + '\'' +
                ", bitrateType='" + bitrateType + '\'' +
                ", closedCaptioning='" + closedCaptioning + '\'' +
                ", destDrmType='" + destDrmType + '\'' +
                ", domainType='" + domainType + '\'' +
                ", duration='" + duration + '\'' +
                ", elementType='" + elementType + '\'' +
                ", errorMsg='" + errorMsg + '\'' +
                ", fileSize='" + fileSize + '\'' +
                ", fileUrl='" + fileUrl + '\'' +
                ", name='" + name + '\'' +
                ", nextTime='" + nextTime + '\'' +
                ", ocsUrl='" + ocsUrl + '\'' +
                ", provider='" + provider + '\'' +
                ", resolution='" + resolution + '\'' +
                ", screenFormat='" + screenFormat + '\'' +
                ", serviceType='" + serviceType + '\'' +
                ", sourceDrmType='" + sourceDrmType + '\'' +
                ", state='" + state + '\'' +
                ", systemLayer='" + systemLayer + '\'' +
                ", type='" + type + '\'' +
                ", videoProfile='" + videoProfile + '\'' +
                ", videoType='" + videoType + '\'' +
                ", bizDomain='" + bizDomain + '\'' +
                ", messageId='" + messageId + '\'' +
                ", storePath='" + storePath + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", movieId='" + movieId + '\'' +
                ", movieCode='" + movieCode + '\'' +
                ", videoFormat='" + videoFormat + '\'' +
                '}';
    }
}
