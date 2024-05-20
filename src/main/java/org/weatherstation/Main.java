package main.java.org.weatherstation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println(LocalDateTime.now());
        System.out.println("----<>----");
        System.out.println(LocalDate.now());

        Map<Integer, Integer> map = new HashMap<>();
        System.out.println(map.getOrDefault(1, 9292));
    }
}
