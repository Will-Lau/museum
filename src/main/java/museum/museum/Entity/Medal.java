package museum.museum.Entity;

public class Medal {
    private Long medalId;

    private String name;

    private Long star;

    public Long getMedalId() {
        return medalId;
    }

    public void setMedalId(Long medalId) {
        this.medalId = medalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Long getStar() {
        return star;
    }

    public void setStar(Long star) {
        this.star = star;
    }
}