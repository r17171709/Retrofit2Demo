package com.example.renyu.retrofit2demo.model;

import java.util.List;

/**
 * Created by Clevo on 2016/6/16.
 */
public class BranchInfoModel {
    /**
     * id : 575e53c571d03f50a0bff5e1
     * resource : {"id":"57555fa671d03f099389cfe6","name":null,"alias":null,"title":"精际商务_电话销售","subtitle":"6000~12000元","description":"带薪年假 五险一金 年终奖 餐补","label1":"招聘","label2":"普陀区","largeImgUrl":null,"normalImgUrl":null,"smallImgUrl":null,"thumbImageUrl":"http://img.youlanw.com/o//img/tmp/201603221728083118AO.jpg","imgAlt":null,"resourceType":1,"linkUrl":"","resourceValue":"443410","defaultPositionId":"5732d99c249e8e16883fa793","positionPlatform":"allApp","limitRole":null,"limitWorkingLife":-1,"content":null,"prevContent":null,"isAvalable":true,"divisionList":["310100"],"onlineTime":null,"offlineTime":null,"sorting":347,"createTime":null,"updateTime":1465799621463,"createUserId":null,"updateUserId":277,"onlineTimeString":null,"offlineTimeString":null}
     * provinceId : 9
     * cityId : 73
     * districtId : null
     * provinceNo : null
     * cityNo : 310100
     * districtNo : null
     * provinceName : null
     * cityName : 上海市
     * districtName : null
     * isDelete : false
     * publishTime : 1465799621468
     * sorting : 347
     */

    private String id;
    /**
     * id : 57555fa671d03f099389cfe6
     * name : null
     * alias : null
     * title : 精际商务_电话销售
     * subtitle : 6000~12000元
     * description : 带薪年假 五险一金 年终奖 餐补
     * label1 : 招聘
     * label2 : 普陀区
     * largeImgUrl : null
     * normalImgUrl : null
     * smallImgUrl : null
     * thumbImageUrl : http://img.youlanw.com/o//img/tmp/201603221728083118AO.jpg
     * imgAlt : null
     * resourceType : 1
     * linkUrl :
     * resourceValue : 443410
     * defaultPositionId : 5732d99c249e8e16883fa793
     * positionPlatform : allApp
     * limitRole : null
     * limitWorkingLife : -1
     * content : null
     * prevContent : null
     * isAvalable : true
     * divisionList : ["310100"]
     * onlineTime : null
     * offlineTime : null
     * sorting : 347
     * createTime : null
     * updateTime : 1465799621463
     * createUserId : null
     * updateUserId : 277
     * onlineTimeString : null
     * offlineTimeString : null
     */

    private ResourceBean resource;
    private int provinceId;
    private int cityId;
    private Object districtId;
    private Object provinceNo;
    private String cityNo;
    private Object districtNo;
    private Object provinceName;
    private String cityName;
    private Object districtName;
    private boolean isDelete;
    private long publishTime;
    private int sorting;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ResourceBean getResource() {
        return resource;
    }

    public void setResource(ResourceBean resource) {
        this.resource = resource;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public Object getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Object districtId) {
        this.districtId = districtId;
    }

    public Object getProvinceNo() {
        return provinceNo;
    }

    public void setProvinceNo(Object provinceNo) {
        this.provinceNo = provinceNo;
    }

    public String getCityNo() {
        return cityNo;
    }

    public void setCityNo(String cityNo) {
        this.cityNo = cityNo;
    }

    public Object getDistrictNo() {
        return districtNo;
    }

    public void setDistrictNo(Object districtNo) {
        this.districtNo = districtNo;
    }

    public Object getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(Object provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Object getDistrictName() {
        return districtName;
    }

    public void setDistrictName(Object districtName) {
        this.districtName = districtName;
    }

    public boolean isIsDelete() {
        return isDelete;
    }

    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }

    public long getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(long publishTime) {
        this.publishTime = publishTime;
    }

    public int getSorting() {
        return sorting;
    }

    public void setSorting(int sorting) {
        this.sorting = sorting;
    }

    public static class ResourceBean {
        private String id;
        private Object name;
        private Object alias;
        private String title;
        private String subtitle;
        private String description;
        private String label1;
        private String label2;
        private Object largeImgUrl;
        private Object normalImgUrl;
        private Object smallImgUrl;
        private String thumbImageUrl;
        private Object imgAlt;
        private int resourceType;
        private String linkUrl;
        private String resourceValue;
        private String defaultPositionId;
        private String positionPlatform;
        private Object limitRole;
        private int limitWorkingLife;
        private Object content;
        private Object prevContent;
        private boolean isAvalable;
        private Object onlineTime;
        private Object offlineTime;
        private int sorting;
        private Object createTime;
        private long updateTime;
        private Object createUserId;
        private int updateUserId;
        private Object onlineTimeString;
        private Object offlineTimeString;
        private List<String> divisionList;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Object getName() {
            return name;
        }

        public void setName(Object name) {
            this.name = name;
        }

        public Object getAlias() {
            return alias;
        }

        public void setAlias(Object alias) {
            this.alias = alias;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSubtitle() {
            return subtitle;
        }

        public void setSubtitle(String subtitle) {
            this.subtitle = subtitle;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getLabel1() {
            return label1;
        }

        public void setLabel1(String label1) {
            this.label1 = label1;
        }

        public String getLabel2() {
            return label2;
        }

        public void setLabel2(String label2) {
            this.label2 = label2;
        }

        public Object getLargeImgUrl() {
            return largeImgUrl;
        }

        public void setLargeImgUrl(Object largeImgUrl) {
            this.largeImgUrl = largeImgUrl;
        }

        public Object getNormalImgUrl() {
            return normalImgUrl;
        }

        public void setNormalImgUrl(Object normalImgUrl) {
            this.normalImgUrl = normalImgUrl;
        }

        public Object getSmallImgUrl() {
            return smallImgUrl;
        }

        public void setSmallImgUrl(Object smallImgUrl) {
            this.smallImgUrl = smallImgUrl;
        }

        public String getThumbImageUrl() {
            return thumbImageUrl;
        }

        public void setThumbImageUrl(String thumbImageUrl) {
            this.thumbImageUrl = thumbImageUrl;
        }

        public Object getImgAlt() {
            return imgAlt;
        }

        public void setImgAlt(Object imgAlt) {
            this.imgAlt = imgAlt;
        }

        public int getResourceType() {
            return resourceType;
        }

        public void setResourceType(int resourceType) {
            this.resourceType = resourceType;
        }

        public String getLinkUrl() {
            return linkUrl;
        }

        public void setLinkUrl(String linkUrl) {
            this.linkUrl = linkUrl;
        }

        public String getResourceValue() {
            return resourceValue;
        }

        public void setResourceValue(String resourceValue) {
            this.resourceValue = resourceValue;
        }

        public String getDefaultPositionId() {
            return defaultPositionId;
        }

        public void setDefaultPositionId(String defaultPositionId) {
            this.defaultPositionId = defaultPositionId;
        }

        public String getPositionPlatform() {
            return positionPlatform;
        }

        public void setPositionPlatform(String positionPlatform) {
            this.positionPlatform = positionPlatform;
        }

        public Object getLimitRole() {
            return limitRole;
        }

        public void setLimitRole(Object limitRole) {
            this.limitRole = limitRole;
        }

        public int getLimitWorkingLife() {
            return limitWorkingLife;
        }

        public void setLimitWorkingLife(int limitWorkingLife) {
            this.limitWorkingLife = limitWorkingLife;
        }

        public Object getContent() {
            return content;
        }

        public void setContent(Object content) {
            this.content = content;
        }

        public Object getPrevContent() {
            return prevContent;
        }

        public void setPrevContent(Object prevContent) {
            this.prevContent = prevContent;
        }

        public boolean isIsAvalable() {
            return isAvalable;
        }

        public void setIsAvalable(boolean isAvalable) {
            this.isAvalable = isAvalable;
        }

        public Object getOnlineTime() {
            return onlineTime;
        }

        public void setOnlineTime(Object onlineTime) {
            this.onlineTime = onlineTime;
        }

        public Object getOfflineTime() {
            return offlineTime;
        }

        public void setOfflineTime(Object offlineTime) {
            this.offlineTime = offlineTime;
        }

        public int getSorting() {
            return sorting;
        }

        public void setSorting(int sorting) {
            this.sorting = sorting;
        }

        public Object getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Object createTime) {
            this.createTime = createTime;
        }

        public long getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(long updateTime) {
            this.updateTime = updateTime;
        }

        public Object getCreateUserId() {
            return createUserId;
        }

        public void setCreateUserId(Object createUserId) {
            this.createUserId = createUserId;
        }

        public int getUpdateUserId() {
            return updateUserId;
        }

        public void setUpdateUserId(int updateUserId) {
            this.updateUserId = updateUserId;
        }

        public Object getOnlineTimeString() {
            return onlineTimeString;
        }

        public void setOnlineTimeString(Object onlineTimeString) {
            this.onlineTimeString = onlineTimeString;
        }

        public Object getOfflineTimeString() {
            return offlineTimeString;
        }

        public void setOfflineTimeString(Object offlineTimeString) {
            this.offlineTimeString = offlineTimeString;
        }

        public List<String> getDivisionList() {
            return divisionList;
        }

        public void setDivisionList(List<String> divisionList) {
            this.divisionList = divisionList;
        }
    }
}
