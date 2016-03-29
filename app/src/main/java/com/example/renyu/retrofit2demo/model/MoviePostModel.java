package com.example.renyu.retrofit2demo.model;

/**
 * Created by renyu on 2016/3/21.
 */
public class MoviePostModel {

    /**
     * query : 虎妈猫爸的最新剧集
     * resource : video_haiou
     */

    private String query;
    private String resource;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }
}
