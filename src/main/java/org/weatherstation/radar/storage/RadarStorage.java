package main.java.org.weatherstation.radar.storage;

import main.java.org.weatherstation.dimension.model.TypeOfDimension;
import main.java.org.weatherstation.radar.model.Radar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RadarStorage {
    /**
     * radarJournalByType - хранит все UID радоров с разделением по типу измерений
     */
    public static Map<TypeOfDimension, List<String>> radarJournalByType = new HashMap<>();
    /**
     * radarList - хранит объекты радаров по UID
     */
    public static Map<String, Radar> radarList = new HashMap<>();
    /**
     * faultyRadarIds - хранит список UID неисправных радаров
     */
    public static List<String> faultyRadarIds = new ArrayList<>();
}
