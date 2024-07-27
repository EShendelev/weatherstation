package main.java.org.weatherstation.radar.service.util;


public class UidGenerator {

    private int id;

    public String getUid(String prefix) {
        return prefix + "_" + (++id);
    }
}
