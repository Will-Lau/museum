package museum.museum.Entity;

public class User {
    private String userId;

    private String avatar;

    private Integer qsFinish;

    private Integer qsTotalFinish;

    private Long starlet;

    private Double accuracy;

    private Integer transpondTime;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public Integer getQsFinish() {
        return qsFinish;
    }

    public void setQsFinish(Integer qsFinish) {
        this.qsFinish = qsFinish;
    }

    public Integer getQsTotalFinish() {
        return qsTotalFinish;
    }

    public void setQsTotalFinish(Integer qsTotalFinish) {
        this.qsTotalFinish = qsTotalFinish;
    }

    public Long getStarlet() {
        return starlet;
    }

    public void setStarlet(Long starlet) {
        this.starlet = starlet;
    }

    public Double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(Double accuracy) {
        this.accuracy = accuracy;
    }

    public Integer getTranspondTime() {
        return transpondTime;
    }

    public void setTranspondTime(Integer transpondTime) {
        this.transpondTime = transpondTime;
    }
}