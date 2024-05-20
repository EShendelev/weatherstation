package main.java.org.weatherstation.radar.model;

import main.java.org.weatherstation.dimension.model.Dimension;
import main.java.org.weatherstation.dimension.model.TypeOfDimension;

public class TemperatureRadar extends Radar {
    public TemperatureRadar(String uid, String name, double latitude, double longitude) {
        super(uid, name, latitude, longitude);
        typeOfDimension = TypeOfDimension.TEMPERATURE;
    }
}
