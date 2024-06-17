package main.java.org.weatherstation.radar.model;

import main.java.org.weatherstation.dimension.model.Dimension;
import main.java.org.weatherstation.dimension.model.TypeOfDimension;
import main.java.org.weatherstation.radar.exceptions.AlreadyExistRadarException;
import main.java.org.weatherstation.radar.exceptions.NotServiceableRadarException;
import main.java.org.weatherstation.radar.service.util.RadarMaker;

import java.time.LocalDate;
import java.util.*;

public class RadarManager {
    private final Map<TypeOfDimension, String> radarJournalByType = new HashMap<>();
    private final Map<String, Radar> radarList = new HashMap<>();

    private final List<String> faultyRadarsIds = new ArrayList<>();

    public Map<String, Radar> getAllRadars() {
        return new HashMap<>(radarList);
    }

    public void makeDimension(String radarUid, LocalDate date, double value) {
        Radar radar = radarList.get(radarUid);
        if (!radar.isServiceable()) {
            throw new NotServiceableRadarException("Radar UID " + radarUid + " not serviceable");
        }
        radar.makeDimension(date, value);
    }

    public List<Dimension> getAllRadarDimension(String radarUid) {
        Radar radar = radarList.get(radarUid);
        if (!radar.isServiceable()) {
            throw new NotServiceableRadarException("Radar UID " + radarUid + " not serviceable");
        }
        return radar.getAllRadarDimension();
    }



    public List<Radar> getAllFaultyRadars() {
        List<Radar> radars = new ArrayList<>();
        for (String s : faultyRadarsIds) {
            radars.add(radarList.get(s));
        }
        return radars;
    }

    public List<String> getFaultyRadarsIds() {
        return new ArrayList<>(faultyRadarsIds);
    }

    public void markRadarAsFault(String uid) {
        Radar radar = radarList.get(uid);
        radar.setServiceable(false);
        faultyRadarsIds.add(uid);
    }

    public void markRadarAsServiceable(String uid) {
        Radar radar = radarList.get(uid);
        radar.setServiceable(true);
        faultyRadarsIds.remove(uid);
    }


    public void addRadar(String name, String prefix, double latitude, double longitude, TypeOfDimension typeOfDimension) {
        Radar radar = RadarMaker.makeRadar(name, prefix, latitude, longitude, typeOfDimension);
        String uid = radar.getUid();
        if (radarList.containsKey(uid)) {
            throw new AlreadyExistRadarException("Radar with UID " + uid + " already exists");
        }
        radarList.put(uid, radar);
        radarJournalByType.put(typeOfDimension, uid);
    }
}
