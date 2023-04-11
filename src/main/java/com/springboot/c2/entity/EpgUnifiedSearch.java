package com.springboot.c2.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFilter;
import io.swagger.models.auth.In;

import java.util.List;
import java.util.Map;

public class EpgUnifiedSearch {
    @JSONField(name = "Code")
    private String code;
    @JSONField(name = "Name")
    private String name;
    @JSONField(name = "SeriesFlag")
    private Integer seriesFlag;
    @JSONField(name = "CSPID")
    private String cspId;
    @JSONField(name = "CSPName")
    private String cspName;
    @JSONField(name = "ReleaseYear")
    private Integer releaseYear;
    @JSONField(name = "updateTime")
    private String updateTime;
    @JSONField(name = "createTime")
    private Long createTime;
    @JSONField(name = "LicensingWindowEnd")
    private String licensingWindowEnd;
    @JSONField(name = "OriginalCountry")
    private String originalCountry;
    @JSONField(name = "Gener")
    private String gener;
    @JSONField(name = "Tags")
    private String tags;
    @JSONField(name = "Keyword")
    private String keyword;
    @JSONField(name = "seriesChild")
    private Integer seriesChild;
    @JSONField(name = "keywordScore")
    private Integer keywordScore;
    @JSONField(name = "nameLength")
    private Integer nameLength;
    @JSONField(name = "During")
    private Integer during;
    @JSONField(name = "picture")
    private Map<String, List<Map<String,String>>> picture;
    @JSONField(name = "ContentScore")
    private Integer contentScore;
    @JSONField(name = "PV")
    private Integer pv;
    private Integer type1;
    private Integer type2;
    private Integer type3;
    private Integer type4;
    private Integer type5;
    private Integer type6;
    private Integer type7;
    private Integer type8;
    private Integer type9;
    private String plate;
    private String channel;
    private Integer retrievalFlag;
    private String actorDisplay;
    private String directorDisplay;
    private String language;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSeriesFlag() {
        return seriesFlag;
    }

    public void setSeriesFlag(Integer seriesFlag) {
        this.seriesFlag = seriesFlag;
    }

    public String getCspId() {
        return cspId;
    }

    public void setCspId(String cspId) {
        this.cspId = cspId;
    }

    public String getCspName() {
        return cspName;
    }

    public void setCspName(String cspName) {
        this.cspName = cspName;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getLicensingWindowEnd() {
        return licensingWindowEnd;
    }

    public void setLicensingWindowEnd(String licensingWindowEnd) {
        this.licensingWindowEnd = licensingWindowEnd;
    }

    public String getOriginalCountry() {
        return originalCountry;
    }

    public void setOriginalCountry(String originalCountry) {
        this.originalCountry = originalCountry;
    }

    public String getGener() {
        return gener;
    }

    public void setGener(String gener) {
        this.gener = gener;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getKeywordScore() {
        return keywordScore;
    }

    public void setKeywordScore(Integer keywordScore) {
        this.keywordScore = keywordScore;
    }

    public Integer getSeriesChild() {
        return seriesChild;
    }

    public void setSeriesChild(Integer seriesChild) {
        this.seriesChild = seriesChild;
    }

    public Integer getNameLength() {
        return nameLength;
    }

    public void setNameLength(Integer nameLength) {
        this.nameLength = nameLength;
    }

    public Integer getDuring() {
        return during;
    }

    public void setDuring(Integer during) {
        this.during = during;
    }

    public Map<String, List<Map<String, String>>> getPicture() {
        return picture;
    }

    public void setPicture(Map<String, List<Map<String, String>>> picture) {
        this.picture = picture;
    }

    public Integer getContentScore() {
        return contentScore;
    }

    public void setContentScore(Integer contentScore) {
        this.contentScore = contentScore;
    }

    public Integer getPv() {
        return pv;
    }

    public void setPv(Integer pv) {
        this.pv = pv;
    }

    public Integer getType1() {
        return type1;
    }

    public void setType1(Integer type1) {
        this.type1 = type1;
    }

    public Integer getType2() {
        return type2;
    }

    public void setType2(Integer type2) {
        this.type2 = type2;
    }

    public Integer getType3() {
        return type3;
    }

    public void setType3(Integer type3) {
        this.type3 = type3;
    }

    public Integer getType4() {
        return type4;
    }

    public void setType4(Integer type4) {
        this.type4 = type4;
    }

    public Integer getType5() {
        return type5;
    }

    public void setType5(Integer type5) {
        this.type5 = type5;
    }

    public Integer getType6() {
        return type6;
    }

    public void setType6(Integer type6) {
        this.type6 = type6;
    }

    public Integer getType7() {
        return type7;
    }

    public void setType7(Integer type7) {
        this.type7 = type7;
    }

    public Integer getType8() {
        return type8;
    }

    public void setType8(Integer type8) {
        this.type8 = type8;
    }

    public Integer getType9() {
        return type9;
    }

    public void setType9(Integer type9) {
        this.type9 = type9;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public Integer getRetrievalFlag() {
        return retrievalFlag;
    }

    public void setRetrievalFlag(Integer retrievalFlag) {
        this.retrievalFlag = retrievalFlag;
    }

    public String getActorDisplay() {
        return actorDisplay;
    }

    public void setActorDisplay(String actorDisplay) {
        this.actorDisplay = actorDisplay;
    }

    public String getDirectorDisplay() {
        return directorDisplay;
    }

    public void setDirectorDisplay(String directorDisplay) {
        this.directorDisplay = directorDisplay;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "EpgUnifiedSearch{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", seriesFlag=" + seriesFlag +
                ", cspId='" + cspId + '\'' +
                ", cspName='" + cspName + '\'' +
                ", releaseYear=" + releaseYear +
                ", updateTime='" + updateTime + '\'' +
                ", createTime=" + createTime +
                ", licensingWindowEnd='" + licensingWindowEnd + '\'' +
                ", originalCountry='" + originalCountry + '\'' +
                ", gener='" + gener + '\'' +
                ", tags='" + tags + '\'' +
                ", keyword='" + keyword + '\'' +
                ", seriesChild=" + seriesChild +
                ", keywordScore=" + keywordScore +
                ", nameLength=" + nameLength +
                ", during=" + during +
                ", picture=" + picture +
                ", contentScore=" + contentScore +
                ", pv=" + pv +
                ", type1=" + type1 +
                ", type2=" + type2 +
                ", type3=" + type3 +
                ", type4=" + type4 +
                ", type5=" + type5 +
                ", type6=" + type6 +
                ", type7=" + type7 +
                ", type8=" + type8 +
                ", type9=" + type9 +
                ", plate='" + plate + '\'' +
                ", channel='" + channel + '\'' +
                ", retrievalFlag=" + retrievalFlag +
                ", actorDisplay='" + actorDisplay + '\'' +
                ", directorDisplay='" + directorDisplay + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}
