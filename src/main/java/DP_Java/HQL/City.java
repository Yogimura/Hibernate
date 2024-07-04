package DP_Java.HQL;

public record City(String name, Float stars) {
    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", stars=" + stars +
                '}';
    }
}
