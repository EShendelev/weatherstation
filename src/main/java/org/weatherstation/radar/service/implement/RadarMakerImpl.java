package main.java.org.weatherstation.radar.service.implement;

import main.java.org.weatherstation.radar.model.*;
import main.java.org.weatherstation.radar.service.interfaces.RadarMaker;

import static main.java.org.weatherstation.radar.service.util.UidGenerator.getUid;
public class RadarMakerImpl implements RadarMaker {

    @Override
    public Radar makeRadar(String name, String locationName, double latitude, double longitude, RadarType radarType) {
        String uid = getUid(locationName);
        Radar radar = null;
        switch (radarType) {
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
                //исключение
        }
        return radar;
    }
}

