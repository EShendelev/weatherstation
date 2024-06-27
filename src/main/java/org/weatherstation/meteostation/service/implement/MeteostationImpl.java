package main.java.org.weatherstation.meteostation.service.implement;

import main.java.org.weatherstation.dimension.model.Dimension;
import main.java.org.weatherstation.dimension.model.TypeOfDimension;
import main.java.org.weatherstation.forecast.model.Forecast;
import main.java.org.weatherstation.forecast.model.ForecastManager;
import main.java.org.weatherstation.meteostation.service.interfaces.Meteostation;
import main.java.org.weatherstation.radar.model.Radar;

import main.java.org.weatherstation.radar.model.RadarManager;

import java.time.LocalDate;
import java.util.List;

public class MeteostationImpl implements Meteostation {

    private final RadarManager radarManager;
    private final ForecastManager forecastManager;


    public MeteostationImpl() {
        this.radarManager = new RadarManager();
        this.forecastManager = new ForecastManager();
    }

    @Override
    public void addRadar(String prefix, double latitude, double longitude, TypeOfDimension typeOfDimension) {
        radarManager.addRadar(prefix, latitude, longitude, typeOfDimension);
    }

    @Override
    public void addDimension(String radarUid, LocalDate date, double value) {
        radarManager.makeDimension(radarUid, date, value);
    }

    @Override
    public List<Dimension> getAllRadarDimension(String uid) {
        return List.of();
    }

    @Override
    public Forecast getForecast(LocalDate date) {
        return forecastManager.getForecast(date);
    }

    @Override
    public void markRadarAsFault(String uid) {
        radarManager.markRadarAsFault(uid);
    }

    @Override
    public void markRadarAsServiceable(String uid) {
        radarManager.markRadarAsServiceable(uid);
    }

    @Override
    public List<Radar> getAllFaultyRadars() {
        return radarManager.getAllFaultyRadars();
    }
}
