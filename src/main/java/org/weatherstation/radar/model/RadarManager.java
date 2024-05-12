package main.java.org.weatherstation.radar.model;

import main.java.org.weatherstation.dimension.model.TypeOfDimension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RadarManager {
    private static final Map<TypeOfDimension, Map<String, Radar>> radarJournal = new HashMap<>();

    public static Map<TypeOfDimension, Map<String, Radar>> getAllRadars() {
        return new HashMap<>(radarJournal);
    }

    public static void writeRadar(TypeOfDimension typeOfDimension, Radar radar) {
        Map<String, Radar> radarList = radarJournal.getOrDefault(typeOfDimension, new HashMap<>());
        String uid = radar.getUid();
        radarList.put(uid, radar);
        radarJournal.put(typeOfDimension, radarList);
    }
}
