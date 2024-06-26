package main.java.org.weatherstation.radar.model;

import main.java.org.weatherstation.dimension.model.TypeOfDimension;

public class TemperatureRadar extends Radar {
    public TemperatureRadar(String uid, double latitude, double longitude) {
        super(uid, latitude, longitude);
        typeOfDimension = TypeOfDimension.TEMPERATURE;
    }
}
