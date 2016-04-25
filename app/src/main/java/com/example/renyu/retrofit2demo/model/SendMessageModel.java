package com.example.renyu.retrofit2demo.model;

/**
 * Created by RG on 2016/4/25.
 */
public class SendMessageModel {
    /**
     * msg : 发布消息成功
     */

    private DataEntity data;
    /**
     * data : {"msg":"发布消息成功"}
     * msg :
     * result : 1
     */

    private String msg;
    private int result;

    public DataEntity getData() {
        return data;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public static class DataEntity {
        private String msg;

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }
}
