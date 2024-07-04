package DP_Java.Associations.Cinema;

import java.util.Set;

public class Moviebi {
    private int id = 0;
    private String title = null;
    private Set<Actorbi> actors = null;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Actorbi> getActors() {
        return actors;
    }

    public void setActors(Set<Actorbi> actors) {
        this.actors = actors;
    }

    @Override
    public String toString() {
        return "Moviebi{" +
                "id=" + getId() +
                ", title='" + getTitle() + '\'' +
                ", actors=" + getActors() +
                '}';
    }
}
