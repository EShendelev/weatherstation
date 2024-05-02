package main.java.org.weatherstation.dimension.service.util;

public class IdGenerator {
    private static long id;

    public static long getId() {
        return ++id;
    }

}
