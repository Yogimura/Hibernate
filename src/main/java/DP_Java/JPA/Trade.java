package DP_Java.JPA;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TRADE")
public class Trade {
    @Id
    @Column(name = "TRADE_ID")
    private int id = 0;
}
