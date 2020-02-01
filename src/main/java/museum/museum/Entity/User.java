package museum.museum.Entity;

public class User {
    private String userId;

    private String avatar;

    private Double accuary;

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

    public Double getAccuary() {
        return accuary;
    }

    public void setAccuary(Double accuary) {
        this.accuary = accuary;
    }

    public Long getStarlet() {
        return starlet;
    }

    public void setStarlet(Long starlet) {
        this.starlet = starlet;
    }
}