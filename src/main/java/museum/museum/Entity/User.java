package museum.museum.Entity;

public class User {
    private String userId;

    private String avatar;

    private Integer qsFinish;

    private Long starlet;

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

    public Long getStarlet() {
        return starlet;
    }

    public void setStarlet(Long starlet) {
        this.starlet = starlet;
    }
}