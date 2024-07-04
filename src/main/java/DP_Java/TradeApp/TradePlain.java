package DP_Java.TradeApp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Trades")
public class TradePlain {
    @Id
    private long tradeId = -1;
    private double quantity = 0;
    private String security = null;

    public long getTradeId() {
        return tradeId;
    }

    public void setTradeId(long tradeId) {
        this.tradeId = tradeId;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getSecurity() {
        return security;
    }

    public void setSecurity(String security) {
        this.security = security;
    }
}
