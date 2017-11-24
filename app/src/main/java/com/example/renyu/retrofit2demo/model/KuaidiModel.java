package com.example.renyu.retrofit2demo.model;

import java.util.List;

/**
 * Created by renyu on 2017/11/24.
 */

public class KuaidiModel {
    /**
     * message : ok
     * nu : 3101449726243
     * ischeck : 1
     * condition : F00
     * com : yunda
     * status : 200
     * state : 3
     * data : [{"time":"2017-11-14 23:11:56","ftime":"2017-11-14 23:11:56","context":"[广东顺德区公司勒流振兴分部]快件已被 已签收 签收","location":null},{"time":"2017-11-14 09:36:10","ftime":"2017-11-14 09:36:10","context":"[广东顺德区公司勒流振兴分部]进行派件扫描；派送业务员：陈少平；联系电话：13534421035","location":null},{"time":"2017-11-14 06:40:03","ftime":"2017-11-14 06:40:03","context":"[广东顺德区公司勒流振兴分部]到达目的地网点，快件将很快进行派送","location":null},{"time":"2017-11-14 05:26:31","ftime":"2017-11-14 05:26:31","context":"[广东顺德区公司]进行快件扫描，将发往：广东顺德区公司勒流振兴分部","location":null},{"time":"2017-11-14 05:24:11","ftime":"2017-11-14 05:24:11","context":"[广东佛山分拨中心]从站点发出，本次转运目的地：广东顺德区公司","location":null},{"time":"2017-11-13 23:11:41","ftime":"2017-11-13 23:11:41","context":"[广东广州分拨中心]进行装车扫描，即将发往：广东佛山分拨中心","location":null},{"time":"2017-11-13 22:16:36","ftime":"2017-11-13 22:16:36","context":"[广东广州分拨中心]在分拨中心进行卸车扫描","location":null},{"time":"2017-11-12 23:30:53","ftime":"2017-11-12 23:30:53","context":"[云南昆明分拨中心]进行装车扫描，即将发往：广东广州分拨中心","location":null},{"time":"2017-11-12 23:28:38","ftime":"2017-11-12 23:28:38","context":"[云南昆明分拨中心]在分拨中心进行称重扫描","location":null},{"time":"2017-11-12 11:56:08","ftime":"2017-11-12 11:56:08","context":"[云南富宁县公司]进行揽件扫描","location":null},{"time":"2017-11-10 18:08:10","ftime":"2017-11-10 18:08:10","context":"[云南富宁县公司]进行揽件扫描","location":null}]
     */

    private String message;
    private String nu;
    private String ischeck;
    private String condition;
    private String com;
    private String status;
    private String state;
    private List<DataBean> data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNu() {
        return nu;
    }

    public void setNu(String nu) {
        this.nu = nu;
    }

    public String getIscheck() {
        return ischeck;
    }

    public void setIscheck(String ischeck) {
        this.ischeck = ischeck;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getCom() {
        return com;
    }

    public void setCom(String com) {
        this.com = com;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * time : 2017-11-14 23:11:56
         * ftime : 2017-11-14 23:11:56
         * context : [广东顺德区公司勒流振兴分部]快件已被 已签收 签收
         * location : null
         */

        private String time;
        private String ftime;
        private String context;
        private Object location;

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getFtime() {
            return ftime;
        }

        public void setFtime(String ftime) {
            this.ftime = ftime;
        }

        public String getContext() {
            return context;
        }

        public void setContext(String context) {
            this.context = context;
        }

        public Object getLocation() {
            return location;
        }

        public void setLocation(Object location) {
            this.location = location;
        }
    }
}
