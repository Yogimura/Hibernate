package DP_Java.HQL;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Setter @Getter
@Entity
@NamedQueries(
        value = {
                @NamedQuery(name="getAll", query = "from TravelReview"),
                @NamedQuery(name="getById", query = "from TravelReview where id=:id")
        }
)
public class TravelReview implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id = 0;
    private String title = null;
    private Float stars = 0.0f;
    private String review = null;

    @Override
    public String toString() {
        return "TravelReview{" +
                "id=" + getId() +
                ", title='" + getTitle() + '\'' +
                ", stars=" + getStars() +
                ", review='" + getReview() + '\'' +
                '}';
    }
}
