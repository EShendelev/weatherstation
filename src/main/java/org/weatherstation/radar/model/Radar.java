package main.java.org.weatherstation.radar.model;


import main.java.org.weatherstation.dimension.model.Dimension;
import main.java.org.weatherstation.dimension.model.TypeOfDimension;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import main.java.org.weatherstation.dimension.model.DimensionManager;

public abstract class Radar {
    private String uid;
    private String name;
    private double latitude;
    private double longitude;
    private boolean isServiceable;
    private double value;

    protected TypeOfDimension typeOfDimension;

    public Radar(String uid, String name, double latitude, double longitude) {
        this.uid = uid;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        isServiceable = true;
    }


    public void getDimension() {
        //возможно нужно сделать метод, который снимает текущее значение радара. Т.к. это измерительный прибор
        //и снимает значения в реальном времени. В данный момент пренебрежем этим.
        Dimension dimension = new Dimension(uid, value);
        //в журнал должен записывать сам менеджер
        DimensionManager.writeDimension(typeOfDimension, dimension);
    }


    public String getUid() {
        return uid;
    }
}
