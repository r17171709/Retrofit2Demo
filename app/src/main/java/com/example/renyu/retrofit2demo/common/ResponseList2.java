package com.example.renyu.retrofit2demo.common;

import java.util.List;

/**
 * Created by Clevo on 2016/6/16.
 */
public class ResponseList2<T> {
    List<T> data;
    String status;
    String msg;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
