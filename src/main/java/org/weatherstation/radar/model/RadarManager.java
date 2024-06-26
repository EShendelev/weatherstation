package main.java.org.weatherstation.radar.model;

import main.java.org.weatherstation.dimension.model.Dimension;
import main.java.org.weatherstation.dimension.model.TypeOfDimension;
import main.java.org.weatherstation.radar.exceptions.AlreadyExistRadarException;
import main.java.org.weatherstation.radar.exceptions.NotServiceableRadarException;
import main.java.org.weatherstation.radar.service.util.RadarMaker;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static main.java.org.weatherstation.radar.storage.RadarStorage.*;

public class RadarManager {

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
        for (String s : faultyRadarIds) {
            radars.add(radarList.get(s));
        }
        return radars;
    }

    public List<String> getFaultyRadarsIds() {
        return new ArrayList<>(faultyRadarIds);
    }

    public void markRadarAsFault(String uid) {
        Radar radar = radarList.get(uid);
        radar.setServiceable(false);
        faultyRadarIds.add(uid);
    }

    public void markRadarAsServiceable(String uid) {
        Radar radar = radarList.get(uid);
        radar.setServiceable(true);
        faultyRadarIds.remove(uid);
    }


    public void addRadar(String prefix, double latitude, double longitude, TypeOfDimension typeOfDimension) {
        Radar radar = RadarMaker.makeRadar(prefix, latitude, longitude, typeOfDimension);
        String uid = radar.getUid();
        if (radarList.containsKey(uid)) {
            throw new AlreadyExistRadarException("Radar with UID " + uid + " already exists");
        }
        List<String> uids = radarJournalByType.getOrDefault(typeOfDimension, new ArrayList<>());
        uids.add(uid);
        radarList.put(uid, radar);
        radarJournalByType.put(typeOfDimension, uids);
    }
}
