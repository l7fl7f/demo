package com.springboot.c2.entity;


import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Copyright  2018IPTV
 *
 * @Title: MediaVod
 * @Project: iptv
 * @date: 2018-09-02 15:50
 * @author: Dave.Luo
 * @Description: 点播数据类
 */
public class EpgMediaVod {

    private String id;//下发唯一id
    private Integer VODID;//VOD节目编号
    private String metaId;// 0:普通VOD 1:连续剧剧集 99:连续剧单集
    private String type;//电影、电视剧...
    private String mediaId;//c2下发id
    private String mediaCode;//c2下发code
    private String title;//节目名
    private String screenCode;//投屏code(为了支持表示不同屏的同一个内容关系)
    private String orderNumber;//节目订购编号
    private String actorDisplay;//演员名列表(只供显示)
    private String writerDisplay;//作者名列表(只供显示)
    private String description;//节目简介
    private String[] serviceId;//服务编号
    private Integer fatherVodId;//如果该点播内容有和父集绑定，显示该点播内容绑定的父集中的一个，如果没有绑定父集，否则显示为-1
    private Integer isSitcom;//连续剧类型：0：非连续剧父集 1：连续剧父集
    private String price;//影片价格
    private String searchCode;//影片搜索代码
    private String year;//上映年份
    private String releaseTime;//上映时间(YYYYMMDD)
    private long showTime;//上映时间(year + releaseTime 字段合并,作排序用)
    private String licensingWindowStart;//影片有效开始时间(YYYYMMDDHH24MiSS)
    private String licensingWindowEnd;//影片有效结束时间(YYYYMMDDHH24MiSS)
    private long upEpgTime;//同步epg上架时间
    private Integer contentType;//影片类型：0：视频点播 4：音频点播 ....
    private String viewPoint;//看点介绍
    private String keyWords;//关键字
    private String Tags;//关联标签
    private String cpId;//内容提供商ID
    private String cpName;//内容提供商名称
    private String originalName;//原名
    private String sortName;//索引名称 供界面排序
    private String genre;//的默认类别
    private String originalCountry;//国家地区
    private List<String> genreKey;//的默认类别(检索用)
    private List<String> originalCountryKey;//国家地区(检索用)
    private String language;//语言
    private Integer definitionFlag;//高清标识 1：高清 2：标清...
    private String[] areaIds;//区域
    private String score;//评分(100分制)
    private String awards;//获奖说明(多个奖项之间使用分号分隔)
    private String distributor;//发行商(多个发行商之间使用分号分隔)
    private String substitleLang;//字幕支持语言
    private Integer totalSerial;//总集数
    private Integer curSerial;//当前更新集数
    private Integer displayAsNew;//新到天数
    private Integer displayAsLastChance;//剩余天数
    private Integer macrovision;//拷贝保护标志 0:无拷贝保护 1:有拷贝保护
    private Integer playCount;//播放次数（人气）
    private List<Map<String,String>> ExtendInfoList;//扩展字段
    private long createTime;//创建时间
    private List<Map<String,String>> categoryIds;//类别
    private Map<String,List<Map<String,String>>> images;//多海报信息
    private Map<String,List<Map<String,String>>> cast;//演职人员信息
    private String pMediaId;//连续能剧或综艺时对应的剧头ID
    private String pMediaCode;//连续能剧或综艺时对应的剧头code
    private List<String> categoryPids;//对应所有上级栏目的ID

    private String bizDomain;//业务逻辑 0：IPTV业务 （默认） 1：MOBILE业务  2：PC业务 3：IPTV和PC业务
    private String directorDisplay;//导演信息
    /**
     * 保留字段
     */
    private String reserve1;

    /**
     * 保留字段
     */
    private String reserve2;

    /**
     * 保留字段
     */
    private String reserve3;

    /**
     * 保留字段
     */
    private String reserve4;

    /**
     * 保留字段
     */
    private String reserve5;

    public String getReserve1() {
        return reserve1;
    }

    public void setReserve1(String reserve1) {
        this.reserve1 = reserve1;
    }

    public String getReserve2() {
        return reserve2;
    }

    public void setReserve2(String reserve2) {
        this.reserve2 = reserve2;
    }

    public String getReserve3() {
        return reserve3;
    }

    public void setReserve3(String reserve3) {
        this.reserve3 = reserve3;
    }

    public String getReserve4() {
        return reserve4;
    }

    public void setReserve4(String reserve4) {
        this.reserve4 = reserve4;
    }

    public String getReserve5() {
        return reserve5;
    }

    public void setReserve5(String reserve5) {
        this.reserve5 = reserve5;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getpMediaId() {
        return pMediaId;
    }

    public void setpMediaId(String pMediaId) {
        this.pMediaId = pMediaId;
    }

    public String getpMediaCode() {
        return pMediaCode;
    }

    public void setpMediaCode(String pMediaCode) {
        this.pMediaCode = pMediaCode;
    }

    public Integer getVODID() {
        return VODID;
    }

    public void setVODID(Integer VODID) {
        this.VODID = VODID;
    }

    public String getMetaId() {
        return metaId;
    }

    public void setMetaId(String metaId) {
        this.metaId = metaId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getScreenCode() {
        return screenCode;
    }

    public void setScreenCode(String screenCode) {
        this.screenCode = screenCode;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getActorDisplay() {
        return actorDisplay;
    }

    public void setActorDisplay(String actorDisplay) {
        this.actorDisplay = actorDisplay;
    }

    public String getWriterDisplay() {
        return writerDisplay;
    }

    public void setWriterDisplay(String writerDisplay) {
        this.writerDisplay = writerDisplay;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getServiceId() {
        return serviceId;
    }

    public void setServiceId(String[] serviceId) {
        this.serviceId = serviceId;
    }

    public Integer getFatherVodId() {
        return fatherVodId;
    }

    public void setFatherVodId(Integer fatherVodId) {
        this.fatherVodId = fatherVodId;
    }

    public Integer getIsSitcom() {
        return isSitcom;
    }

    public void setIsSitcom(Integer isSitcom) {
        this.isSitcom = isSitcom;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSearchCode() {
        return searchCode;
    }

    public void setSearchCode(String searchCode) {
        this.searchCode = searchCode;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    public long getShowTime() {
        return showTime;
    }

    public void setShowTime(long showTime) {
        this.showTime = showTime;
    }

    public String getLicensingWindowStart() {
        return licensingWindowStart;
    }

    public void setLicensingWindowStart(String licensingWindowStart) {
        this.licensingWindowStart = licensingWindowStart;
    }

    public String getLicensingWindowEnd() {
        return licensingWindowEnd;
    }

    public void setLicensingWindowEnd(String licensingWindowEnd) {
        this.licensingWindowEnd = licensingWindowEnd;
    }

    public long getUpEpgTime() {
        return upEpgTime;
    }

    public void setUpEpgTime(long upEpgTime) {
        this.upEpgTime = upEpgTime;
    }

    public Integer getContentType() {
        return contentType;
    }

    public void setContentType(Integer contentType) {
        this.contentType = contentType;
    }

    public Map<String, List<Map<String, String>>> getCast() {
        return cast;
    }

    public void setCast(Map<String, List<Map<String, String>>> cast) {
        this.cast = cast;
    }

    public String getViewPoint() {
        return viewPoint;
    }

    public void setViewPoint(String viewPoint) {
        this.viewPoint = viewPoint;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

    public String getTags() {
        return Tags;
    }

    public void setTags(String tags) {
        Tags = tags;
    }

    public String getCpId() {
        return cpId;
    }

    public void setCpId(String cpId) {
        this.cpId = cpId;
    }

    public String getCpName() {
        return cpName;
    }

    public void setCpName(String cpName) {
        this.cpName = cpName;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getOriginalCountry() {
        return originalCountry;
    }

    public void setOriginalCountry(String originalCountry) {
        this.originalCountry = originalCountry;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getDefinitionFlag() {
        return definitionFlag;
    }

    public void setDefinitionFlag(Integer definitionFlag) {
        this.definitionFlag = definitionFlag;
    }

    public String[] getAreaIds() {
        return areaIds;
    }

    public void setAreaIds(String[] areaIds) {
        this.areaIds = areaIds;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    public String getDistributor() {
        return distributor;
    }

    public void setDistributor(String distributor) {
        this.distributor = distributor;
    }

    public String getSubstitleLang() {
        return substitleLang;
    }

    public void setSubstitleLang(String substitleLang) {
        this.substitleLang = substitleLang;
    }

    public Integer getTotalSerial() {
        return totalSerial;
    }

    public void setTotalSerial(Integer totalSerial) {
        this.totalSerial = totalSerial;
    }

    public Integer getCurSerial() {
        return curSerial;
    }

    public void setCurSerial(Integer curSerial) {
        this.curSerial = curSerial;
    }

    public Integer getDisplayAsNew() {
        return displayAsNew;
    }

    public void setDisplayAsNew(Integer displayAsNew) {
        this.displayAsNew = displayAsNew;
    }

    public Integer getDisplayAsLastChance() {
        return displayAsLastChance;
    }

    public void setDisplayAsLastChance(Integer displayAsLastChance) {
        this.displayAsLastChance = displayAsLastChance;
    }

    public Integer getMacrovision() {
        return macrovision;
    }

    public void setMacrovision(Integer macrovision) {
        this.macrovision = macrovision;
    }

    public Integer getPlayCount() {
        return playCount;
    }

    public void setPlayCount(Integer playCount) {
        this.playCount = playCount;
    }

    public List<Map<String, String>> getExtendInfoList() {
        return ExtendInfoList;
    }

    public void setExtendInfoList(List<Map<String, String>> extendInfoList) {
        ExtendInfoList = extendInfoList;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public List<Map<String, String>> getCategoryIds() {
        return categoryIds;
    }

    public void setCategoryIds(List<Map<String, String>> categoryIds) {
        this.categoryIds = categoryIds;
    }

    public Map<String, List<Map<String, String>>> getImages() {
        return images;
    }

    public void setImages(Map<String, List<Map<String, String>>> images) {
        this.images = images;
    }

    public List<String> getCategoryPids() {
        return categoryPids;
    }

    public void setCategoryPids(List<String> categoryPids) {
        this.categoryPids = categoryPids;
    }

    public List<String> getGenreKey() {
        return genreKey;
    }

    public void setGenreKey(List<String> genreKey) {
        this.genreKey = genreKey;
    }

    public List<String> getOriginalCountryKey() {
        return originalCountryKey;
    }

    public void setOriginalCountryKey(List<String> originalCountryKey) {
        this.originalCountryKey = originalCountryKey;
    }

    public String getBizDomain() {
        return bizDomain;
    }

    public void setBizDomain(String bizDomain) {
        this.bizDomain = bizDomain;
    }

    public String getDirectorDisplay() {
        return directorDisplay;
    }

    public void setDirectorDisplay(String directorDisplay) {
        this.directorDisplay = directorDisplay;
    }

    @Override
    public String toString() {
        return "EpgMediaVod{" +
                "id='" + id + '\'' +
                ", VODID=" + VODID +
                ", metaId='" + metaId + '\'' +
                ", type='" + type + '\'' +
                ", mediaId='" + mediaId + '\'' +
                ", mediaCode='" + mediaCode + '\'' +
                ", title='" + title + '\'' +
                ", screenCode='" + screenCode + '\'' +
                ", orderNumber='" + orderNumber + '\'' +
                ", actorDisplay='" + actorDisplay + '\'' +
                ", writerDisplay='" + writerDisplay + '\'' +
                ", description='" + description + '\'' +
                ", serviceId=" + Arrays.toString(serviceId) +
                ", fatherVodId=" + fatherVodId +
                ", isSitcom=" + isSitcom +
                ", price='" + price + '\'' +
                ", searchCode='" + searchCode + '\'' +
                ", year='" + year + '\'' +
                ", releaseTime='" + releaseTime + '\'' +
                ", showTime=" + showTime +
                ", licensingWindowStart='" + licensingWindowStart + '\'' +
                ", licensingWindowEnd='" + licensingWindowEnd + '\'' +
                ", upEpgTime=" + upEpgTime +
                ", contentType=" + contentType +
                ", viewPoint='" + viewPoint + '\'' +
                ", keyWords='" + keyWords + '\'' +
                ", Tags='" + Tags + '\'' +
                ", cpId='" + cpId + '\'' +
                ", cpName='" + cpName + '\'' +
                ", originalName='" + originalName + '\'' +
                ", sortName='" + sortName + '\'' +
                ", genre='" + genre + '\'' +
                ", originalCountry='" + originalCountry + '\'' +
                ", genreKey=" + genreKey +
                ", originalCountryKey=" + originalCountryKey +
                ", language='" + language + '\'' +
                ", definitionFlag=" + definitionFlag +
                ", areaIds=" + Arrays.toString(areaIds) +
                ", score='" + score + '\'' +
                ", awards='" + awards + '\'' +
                ", distributor='" + distributor + '\'' +
                ", substitleLang='" + substitleLang + '\'' +
                ", totalSerial=" + totalSerial +
                ", curSerial=" + curSerial +
                ", displayAsNew=" + displayAsNew +
                ", displayAsLastChance=" + displayAsLastChance +
                ", macrovision=" + macrovision +
                ", playCount=" + playCount +
                ", ExtendInfoList=" + ExtendInfoList +
                ", createTime=" + createTime +
                ", categoryIds=" + categoryIds +
                ", images=" + images +
                ", cast=" + cast +
                ", pMediaId='" + pMediaId + '\'' +
                ", pMediaCode='" + pMediaCode + '\'' +
                ", categoryPids=" + categoryPids +
                ", bizDomain='" + bizDomain + '\'' +
                ", directorDisplay='" + directorDisplay + '\'' +
                ", reserve1='" + reserve1 + '\'' +
                ", reserve2='" + reserve2 + '\'' +
                ", reserve3='" + reserve3 + '\'' +
                ", reserve4='" + reserve4 + '\'' +
                ", reserve5='" + reserve5 + '\'' +
                '}';
    }
}