package main.java.org.weatherstation.radar.service.util;

import main.java.org.weatherstation.dimension.model.TypeOfDimension;
import main.java.org.weatherstation.radar.model.HumidityRadar;
import main.java.org.weatherstation.radar.model.Radar;
import main.java.org.weatherstation.radar.model.TemperatureRadar;
import main.java.org.weatherstation.radar.model.WindRadar;

import static main.java.org.weatherstation.radar.service.util.UidGenerator.getUid;

public class RadarMaker {

    public static Radar makeRadar(String prefix, double latitude, double longitude, TypeOfDimension typeOfDimension) {
        String uid = getUid(prefix);
        Radar radar;
        switch (typeOfDimension) {
            case TEMPERATURE:
                radar = new TemperatureRadar(uid, latitude, longitude);
                break;
            case WIND:
                radar = new WindRadar(uid, latitude, longitude);
                break;
            case HUMIDITY:
                radar = new HumidityRadar(uid, latitude, longitude);
                break;
            default:
                throw new IllegalArgumentException("Unknown dimension type");
        }
        return radar;
    }
}

