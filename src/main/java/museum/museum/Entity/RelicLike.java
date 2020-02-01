package museum.museum.Entity;

import java.util.Date;

public class RelicLike extends RelicLikeKey {
    private Date likeTime;

    public Date getLikeTime() {
        return likeTime;
    }

    public void setLikeTime(Date likeTime) {
        this.likeTime = likeTime;
    }
}