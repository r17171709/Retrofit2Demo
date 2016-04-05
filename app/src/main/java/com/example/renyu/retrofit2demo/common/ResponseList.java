package com.example.renyu.retrofit2demo.common;

import java.util.List;

/**
 * Created by RG on 2016/4/5.
 */
public class ResponseList<T> {
    List<T> games;
    int result;

    public List<T> getData() {
        return games;
    }

    public void setData(List<T> data) {
        this.games = data;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
