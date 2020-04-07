package museum.museum.Entity;

public class MedalGet extends MedalGetKey {
    private String name;

    private Boolean accept;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Boolean getAccept() {
        return accept;
    }

    public void setAccept(Boolean accept) {
        this.accept = accept;
    }
}