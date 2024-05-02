package main.java.org.weatherstation.radar.service.interfaces;

import main.java.org.weatherstation.radar.model.Radar;
import main.java.org.weatherstation.radar.model.RadarType;

public interface RadarMaker {
    public Radar makeRadar(String name, String locationName, double latitude, double longitude, RadarType radarType);
}
