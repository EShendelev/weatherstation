package main.java.org.weatherstation.radar.model;

import main.java.org.weatherstation.dimension.model.Dimension;

import java.util.List;

public class TemperatureRadar extends Radar {
    public TemperatureRadar(String uid, String name, double latitude, double longitude) {
        super(uid, name, latitude, longitude);
        radarType = RadarType.TEMPERATURE;
    }

    @Override
    public void makeDimension() {

    }

    @Override
    public List<Dimension> getDimensions() {
        return List.of();
    }
}
