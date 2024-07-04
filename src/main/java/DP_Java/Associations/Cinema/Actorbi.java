package DP_Java.Associations.Cinema;

public class Actorbi {
    private int id = 0;
    private String firstName = null;
    private String lastName = null;
    private String shortName = null;
    private Moviebi movie = null;

    public Actorbi() {}

    public Actorbi(int id, String firstName, String lastName, String shortName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.shortName = shortName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public Moviebi getMovie() {
        return movie;
    }

    public void setMovie(Moviebi movie) {
        this.movie = movie;
    }

    @Override
    public String toString() {
        return "Actorbi{" +
                "id=" + getId() +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", shortName='" + getShortName() + '\'' +
                ", movie=" + getMovie().getTitle() +
                '}';
    }
}
