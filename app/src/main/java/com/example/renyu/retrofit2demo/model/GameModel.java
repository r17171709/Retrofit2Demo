package com.example.renyu.retrofit2demo.model;

/**
 * Created by RG on 2016/4/5.
 */
public class GameModel {
    /**
     * status : 已结束
     * stateUrl : http://sports1.sina.cn/nba/boxscore?matchid=2016040313
     * rightTeam : 湖人
     * statusUrl : http://dp.sina.cn/dpool/cms/jump.php?url=http://sports.sina.com.cn/basketball/nba/2016-04-04/doc-ifxqxcnp8527202.shtml
     * date : 04-04
     * rightScore : 100
     * stateText : 统计
     * leftTeam : 凯尔特人
     * leftScore : 107
     * type : 1
     */

    private String status;
    private String stateUrl;
    private String rightTeam;
    private String statusUrl;
    private String date;
    private String rightScore;
    private String stateText;
    private String leftTeam;
    private String leftScore;
    private int type;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStateUrl() {
        return stateUrl;
    }

    public void setStateUrl(String stateUrl) {
        this.stateUrl = stateUrl;
    }

    public String getRightTeam() {
        return rightTeam;
    }

    public void setRightTeam(String rightTeam) {
        this.rightTeam = rightTeam;
    }

    public String getStatusUrl() {
        return statusUrl;
    }

    public void setStatusUrl(String statusUrl) {
        this.statusUrl = statusUrl;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRightScore() {
        return rightScore;
    }

    public void setRightScore(String rightScore) {
        this.rightScore = rightScore;
    }

    public String getStateText() {
        return stateText;
    }

    public void setStateText(String stateText) {
        this.stateText = stateText;
    }

    public String getLeftTeam() {
        return leftTeam;
    }

    public void setLeftTeam(String leftTeam) {
        this.leftTeam = leftTeam;
    }

    public String getLeftScore() {
        return leftScore;
    }

    public void setLeftScore(String leftScore) {
        this.leftScore = leftScore;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
