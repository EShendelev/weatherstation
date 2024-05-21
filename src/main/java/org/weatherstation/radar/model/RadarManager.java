package main.java.org.weatherstation.radar.model;

import main.java.org.weatherstation.dimension.model.TypeOfDimension;
import main.java.org.weatherstation.radar.service.util.RadarMaker;

import java.util.HashMap;
import java.util.Map;

public class RadarManager {
    private static final Map<TypeOfDimension, Map<String, Radar>> radarJournal = new HashMap<>();

    public static Map<TypeOfDimension, Map<String, Radar>> getAllRadars() {
        return new HashMap<>(radarJournal);
    }

    public void addRadar(String name, String prefix, double latitude, double longitude, TypeOfDimension typeOfDimension) {
        Radar radar = RadarMaker.makeRadar(name, prefix, latitude, longitude, typeOfDimension);
        Map<String, Radar> radarList = radarJournal.getOrDefault(typeOfDimension, new HashMap<>());
        String uid = radar.getUid();
        radarList.put(uid, radar);
        radarJournal.put(typeOfDimension, radarList);
    }
}
