package main.java.org.weatherstation.radar.model;


import main.java.org.weatherstation.dimension.model.Dimension;

import java.util.ArrayList;
import java.util.List;

public abstract class Radar {
    private String uid;
    private String name;
    private double latitude;
    private double longitude;
    private boolean isServiceable;
    private List<Dimension> dimensions;

    protected RadarType radarType;

    public Radar(String uid, String name, double latitude, double longitude) {
        this.uid = uid;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.dimensions = new ArrayList<>();
        isServiceable = true;
    }

    public abstract void makeDimension();
    public abstract List<Dimension> getDimensions();
}
