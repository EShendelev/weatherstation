package main.java.org.weatherstation.radar.storage;

import main.java.org.weatherstation.dimension.model.TypeOfDimension;
import main.java.org.weatherstation.radar.model.Radar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RadarStorage {

    /*
    Не верно выбрана схема хранения. Можно сделать обычный класс, с методами записи и получения инфомации
    Сделать обьект общий для всех, но не статик
     */

    /**
     * radarJournalByType - хранит все UID радоров с разделением по типу измерений
     */
    private final Map<TypeOfDimension, List<String>> radarJournalByType = new HashMap<>();

    public Map<String, Radar> getRadarByIds() {
        return new HashMap<>(radarByIds);
    }

    /**
     * radarList - хранит объекты радаров по UID
     */
    private final Map<String, Radar> radarByIds = new HashMap<>();

    public List<String> getFaultyRadarIds() {
        return new ArrayList<>(faultyRadarIds);
    }

    /**
     * faultyRadarIds - хранит список UID неисправных радаров
     */
    private final List<String> faultyRadarIds = new ArrayList<>();

    public List<String> getRadarJournalByType(TypeOfDimension typeOfDimension) {
        return radarJournalByType.getOrDefault(typeOfDimension, new ArrayList<>());
    }

    public void addRadarInJournalByType(TypeOfDimension typeOfDimension, String uid) {
        List<String> uidList = radarJournalByType.getOrDefault(typeOfDimension, new ArrayList<>());

        uidList.add(uid);
        radarJournalByType.put(typeOfDimension, uidList);
    }

    public Radar getRadarByUid(String uid) {
        return radarByIds.get(uid);
    }

    public void addFaultyRadarIds(String uid) {
        faultyRadarIds.add(uid);
    }

    public void removeFaultyRadarIds(String uid) {
        faultyRadarIds.remove(uid);
    }

    public void addRadarByIds(String uid, Radar radar) {
        radarByIds.put(uid, radar);
    }
}

