package main.java.org.weatherstation.radar.model;

import main.java.org.weatherstation.dimension.model.TypeOfDimension;
import main.java.org.weatherstation.radar.exceptions.AlreadyExistRadarException;
import main.java.org.weatherstation.radar.service.util.RadarMaker;

import java.util.*;

public class RadarManager {
    private final Map<TypeOfDimension, String> radarJournalByType = new HashMap<>();
    private final Map<String, Radar> radarList = new HashMap<>();

    private final List<String> unserviceableRadarsIds = new ArrayList<>();

    public Map<String, Radar> getAllRadars() {
        return new HashMap<>(radarList);
    }



    public List<Radar> getAllUnserviceableRadars() {
        List<Radar> radars = new ArrayList<>();
        for (String s : unserviceableRadarsIds) {
            radars.add(radarList.get(s));
        }
        return radars;
    }

    public List<String> getUnserviceableRadarsIds() {
        return new ArrayList<>(unserviceableRadarsIds);
    }

    public void addUnserviceableRadar(String uid) {
        Radar radar = radarList.get(uid);
        radar.setServiceable(false);
        unserviceableRadarsIds.add(uid);
    }

    public void repairRadar(String uid) {
        Radar radar = radarList.get(uid);
        radar.setServiceable(true);
        unserviceableRadarsIds.remove(uid);
    }


    public void addRadar(String name, String prefix, double latitude, double longitude, TypeOfDimension typeOfDimension) {
        Radar radar = RadarMaker.makeRadar(name, prefix, latitude, longitude, typeOfDimension);
        String uid = radar.getUid();
        if (radarList.containsKey(uid)) {
            throw new AlreadyExistRadarException("Radar with this UID already exists");
        }
        radarList.put(uid, radar);
        radarJournalByType.put(typeOfDimension, uid);
    }
}
