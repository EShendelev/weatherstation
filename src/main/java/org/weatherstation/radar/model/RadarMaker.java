package main.java.org.weatherstation.radar.model;

import main.java.org.weatherstation.dimension.model.TypeOfDimension;

import static main.java.org.weatherstation.radar.service.util.UidGenerator.getUid;

public class RadarMaker {

    public static Radar makeRadar(String name, String locationName, double latitude, double longitude, TypeOfDimension typeOfDimension) {
        String uid = getUid(locationName);
        Radar radar = null;
        switch (typeOfDimension) {
            case TEMPERATURE:
                radar = new TemperatureRadar(uid, name, latitude, longitude);
                break;
            case WIND:
                radar = new WindRadar(uid, name, latitude, longitude);
                break;
            case HUMIDITY:
                radar = new HumidityRadar(uid, name, latitude, longitude);
                break;
            default:
                throw new IllegalArgumentException("Unknown dimension type");
        }
        return radar;
    }
}

