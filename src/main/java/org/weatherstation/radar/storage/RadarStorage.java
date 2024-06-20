package main.java.org.weatherstation.radar.storage;

import main.java.org.weatherstation.dimension.model.TypeOfDimension;
import main.java.org.weatherstation.radar.model.Radar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RadarStorage {
    public static Map<TypeOfDimension, String> radarJournalByType = new HashMap<>();
    public static Map<String, Radar> radarList = new HashMap<>();
    public static List<String> faultyRadarIds = new ArrayList<>();
}
