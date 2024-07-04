package DP_Java.JPA;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity @Getter @Setter @NoArgsConstructor @ToString
public class Instrument {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Id int id;
    private String Issue = null;

    public Instrument(String issue) {
        Issue = issue;
    }
}
