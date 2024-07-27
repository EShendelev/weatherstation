package main.java.org.weatherstation.radar.storage;

import main.java.org.weatherstation.dimension.model.TypeOfDimension;
import main.java.org.weatherstation.radar.exceptions.AlreadyExistRadarException;
import main.java.org.weatherstation.radar.exceptions.NotExistRadarException;
import main.java.org.weatherstation.radar.model.Radar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RadarStorage {


    /**
     * radarJournalByType - хранит все UID радоров с разделением по типу измерений
     */
    private final Map<TypeOfDimension, List<String>> radarJournalByType = new HashMap<>();

    /**
     * radarList - хранит объекты радаров по UID
     */
    private final Map<String, Radar> radarByIds = new HashMap<>();

    /**
     * faultyRadarIds - хранит список UID неисправных радаров
     */
    private final List<String> faultyRadarIds = new ArrayList<>();

    public List<String> getFaultyRadarIds() {
        return new ArrayList<>(faultyRadarIds);
    }



    public Map<String, Radar> getRadarByIds() {
        return new HashMap<>(radarByIds);
    }

    public List<String> getRadarJournalByType(TypeOfDimension typeOfDimension) {
        return radarJournalByType.getOrDefault(typeOfDimension, new ArrayList<>());
    }

    public void addRadarInJournalByType(TypeOfDimension typeOfDimension, String uid) {

        List<String> uidList = radarJournalByType.getOrDefault(typeOfDimension, new ArrayList<>());
        uidList.add(uid);
        radarJournalByType.put(typeOfDimension, uidList);
    }

    public Radar getRadarByUid(String uid) {
        if (radarByIds.get(uid) == null) {
            throw new NotExistRadarException("Радар UID " + uid + " не существует");
        }
        return radarByIds.get(uid);
    }

    public void addFaultyRadarIds(String uid) {
        if (radarByIds.get(uid) == null) {
            throw new NotExistRadarException("Радар UID " + uid + " не существует");
        }
        faultyRadarIds.add(uid);
    }

    public void removeFaultyRadarIds(String uid) {
        if (radarByIds.get(uid) == null) {
            throw new NotExistRadarException("Радар UID " + uid + " не существует");
        }
        faultyRadarIds.remove(uid);
    }

    public void addRadarByIds(String uid, Radar radar) {
        if (radarByIds.get(uid) != null) {
            throw new AlreadyExistRadarException("Радар UID " + uid + " уже существует");
        }
        radarByIds.put(uid, radar);
    }
}

