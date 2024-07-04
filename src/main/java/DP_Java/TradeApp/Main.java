package DP_Java.TradeApp;

public class Main {
    public static void main(String[] args) {
        TradePlain trade1 = new TradePlain();
        TradePlain trade2 = trade1;

        System.out.println(trade1==trade2);
        System.out.println(trade1.equals(trade2));
    }
}
