package main.java.org.weatherstation.radar.service.util;


public class UidGenerator {

    private static int id;
    public static String getUid(String prefix) {
        return prefix + "_" + (++id);
    }
}
