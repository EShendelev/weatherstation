package main.java.org.weatherstation.radar.model;


import main.java.org.weatherstation.dimension.model.Dimension;
import main.java.org.weatherstation.dimension.model.TypeOfDimension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.java.org.weatherstation.radar.exceptions.EmptyDimensionListException;
import main.java.org.weatherstation.radar.exceptions.NotServiceableRadarException;

public abstract class Radar {
    private String uid;
    private String name;
    private double latitude;
    private double longitude;
    private boolean isServiceable;
    private double value;
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


    public void makeDimension() {
        //возможно нужно сделать метод, который снимает текущее значение радара. Т.к. это измерительный прибор
        //и снимает значения в реальном времени. В данный момент пренебрежем этим.
        Dimension dimension = new Dimension(uid, value);
        LocalDate dimensionDate = dimension.getDate();
        List<Dimension> dimensions = dimensionList.getOrDefault(dimensionDate, new ArrayList<>());
        dimensions.add(dimension);
        dimensionList.put(dimensionDate, dimensions);
    }


    public String getUid() {
        return uid;
    }

    public Map<LocalDate, List<Dimension>> getDimensionList() {
        if (!isServiceable) {
            throw new NotServiceableRadarException("Radar "+ uid + " " + name + " is not serviceable");
        }
        if (!dimensionList.isEmpty()) {
            return new HashMap<>(dimensionList);
        } else {
            throw new EmptyDimensionListException("There are not dimensions on radar " + uid + " " + name);
        }
    }

    public void setServiceable(boolean serviceable) {
        isServiceable = serviceable;
    }
}
