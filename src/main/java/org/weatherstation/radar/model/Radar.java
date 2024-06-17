package main.java.org.weatherstation.radar.model;



import main.java.org.weatherstation.dimension.model.Dimension;
import main.java.org.weatherstation.dimension.model.TypeOfDimension;

import java.time.LocalDate;
import java.util.*;

import main.java.org.weatherstation.radar.exceptions.EmptyDimensionListException;
import main.java.org.weatherstation.radar.exceptions.NotServiceableRadarException;

public abstract class Radar {
    private String uid;
    private String name;
    private double latitude;
    private double longitude;
    private boolean isServiceable;
    //радар хранит в себе список своих измерений - снести, менеджер хранит записи с радаров
    private final Map<LocalDate, List<Dimension>> dimensionList;

    protected TypeOfDimension typeOfDimension;

    public Radar(String uid, String name, double latitude, double longitude) {
        this.uid = uid;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        isServiceable = true;
        dimensionList = new HashMap<>();
    }

    public List<Dimension> getAllRadarDimension() {
        List<Dimension> dimensions = new ArrayList<>();

        for (LocalDate date : dimensionList.keySet()) {
            dimensions.addAll(dimensionList.get(date));
        }

        dimensions.sort(Comparator.comparing(Dimension::getDate));
        return dimensions;
    }


    public void makeDimension(LocalDate date, double value) {
        Dimension dimension = new Dimension(uid, date, value);
        List<Dimension> dimensions = dimensionList.getOrDefault(date, new ArrayList<>());
        dimensions.add(dimension);
        dimensionList.put(date, dimensions);
    }


    public String getUid() {
        return uid;
    }

    public boolean isServiceable() {
        return isServiceable;
    }

    public void setServiceable(boolean serviceable) {
        isServiceable = serviceable;
    }


}
