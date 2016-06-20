package com.example.renyu.retrofit2demo.model;

/**
 * Created by renyu on 16/1/23.
 */
public class UpdateModel {
    /**
     * content : 1.优化刷牙游戏体验。
     2.调整固件升级流程入口。
     3.优化注册流程,移除注册必须选头像逻辑。
     4.修复部分已知BUG
     * title : 发现新版本
     * url : http://7xs0hd.com1.z0.glb.clouddn.com/iite_brush.apk?v=20160615
     * version : 6
     */

    private DataBean data;
    /**
     * data : {"content":"1.优化刷牙游戏体验。\r\n2.调整固件升级流程入口。\r\n3.优化注册流程,移除注册必须选头像逻辑。\r\n4.修复部分已知BUG","title":"发现新版本","url":"http://7xs0hd.com1.z0.glb.clouddn.com/iite_brush.apk?v=20160615","version":"6"}
     * result : 1
     */

    private int result;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public static class DataBean {
        private String content;
        private String title;
        private String url;
        private String version;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }
    }
}
