package main.java.org.weatherstation.radar.model;


import main.java.org.weatherstation.dimension.model.Dimension;

import java.util.List;

public class WindRadar extends Radar{
    public WindRadar(String uid, String name, double latitude, double longitude) {
        super(uid, name, latitude, longitude);
        radarType = RadarType.WIND;
    }

    @Override
    public void makeDimension() {
    }

    @Override
    public List<Dimension> getDimensions() {
        return List.of();
    }
}
