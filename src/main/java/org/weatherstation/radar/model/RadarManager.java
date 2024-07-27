package main.java.org.weatherstation.radar.model;

import main.java.org.weatherstation.dimension.model.Dimension;
import main.java.org.weatherstation.dimension.model.TypeOfDimension;
import main.java.org.weatherstation.radar.exceptions.AlreadyExistRadarException;
import main.java.org.weatherstation.radar.exceptions.NotExistRadarException;
import main.java.org.weatherstation.radar.exceptions.NotServiceableRadarException;
import main.java.org.weatherstation.radar.service.util.RadarMaker;
import main.java.org.weatherstation.radar.storage.RadarStorage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RadarManager {

    public final RadarStorage radarStorage = new RadarStorage();
    public final RadarMaker radarMaker = new RadarMaker();


    public Map<String, Radar> getAllRadars() {
        return new HashMap<>(radarStorage.getRadarByIds());
    }

    public Radar getRadarByUid(String uid) {
        return radarStorage.getRadarByUid(uid);
    }

    public void makeDimension(String radarUid, LocalDate date, double value) {
        Radar radar = getAllRadars().get(radarUid);
        if (!radar.isServiceable()) {
            throw new NotServiceableRadarException("Radar UID " + radarUid + " not serviceable");
        }
        radar.makeDimension(date, value);
    }

    public List<Dimension> getAllRadarDimension(String radarUid) {
        Radar radar = getAllRadars().get(radarUid);
        if (!radar.isServiceable()) {
            throw new NotServiceableRadarException("Radar UID " + radarUid + " not serviceable");
        }
        return radar.getAllRadarDimension();
    }


    public List<Radar> getAllFaultyRadars() {
        List<Radar> radars = new ArrayList<>();
        for (String s : getFaultyRadarsIds()) {
            radars.add(getAllRadars().get(s));
        }
        return radars;
    }

    public List<String> getFaultyRadarsIds() {
        return radarStorage.getFaultyRadarIds();
    }

    public void markRadarAsFault(String uid) {
        if (!getAllRadars().containsKey(uid)) {
            throw new NotExistRadarException("Radar " + uid + " not exist");
        }
        Radar radar = getAllRadars().get(uid);
        radar.setServiceable(false);
        radarStorage.addFaultyRadarIds(uid);
    }

    public void markRadarAsServiceable(String uid) {
        Radar radar = getAllRadars().get(uid);
        radar.setServiceable(true);
        radarStorage.removeFaultyRadarIds(uid);
    }


    public void addRadar(String prefix, double latitude, double longitude, TypeOfDimension typeOfDimension) {
        Radar radar = radarMaker.makeRadar(prefix, latitude, longitude, typeOfDimension);
        String uid = radar.getUid();
        if (getAllRadars().containsKey(uid)) {
            throw new AlreadyExistRadarException("Radar with UID " + uid + " already exists");
        }
        radarStorage.addRadarInJournalByType(typeOfDimension, uid);
        radarStorage.addRadarByIds(uid, radar);
    }

    public List<String> getRadarListByType(TypeOfDimension typeOfDimension) {
        return radarStorage.getRadarJournalByType(typeOfDimension);
    }
}
