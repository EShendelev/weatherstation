package main.java.org.weatherstation.meteostation.service.implement;

import main.java.org.weatherstation.dimension.model.Dimension;
import main.java.org.weatherstation.dimension.model.DimensionManager;
import main.java.org.weatherstation.dimension.model.TypeOfDimension;
import main.java.org.weatherstation.forecast.model.Forecast;
import main.java.org.weatherstation.meteostation.service.interfaces.Meteostation;
import main.java.org.weatherstation.radar.model.Radar;
import main.java.org.weatherstation.radar.model.RadarManager;

import java.time.LocalDate;
import java.util.List;

public class MeteostationImpl implements Meteostation {

    private RadarManager radarManager;
    private DimensionManager dimensionManager;

    public MeteostationImpl() {
        this.radarManager = new RadarManager();
        this.dimensionManager = new DimensionManager();
    }

    @Override
    public void addRadar(String name, String prefix, double latitude, double longitude, TypeOfDimension typeOfDimension) {
        radarManager.addRadar(name, prefix, latitude, longitude, typeOfDimension);
    }

    @Override
    public void addDimension(String radarUid, LocalDate date, Dimension dimension) {
        dimensionManager.addDimension(radarUid, date, dimension);
    }

    @Override
    public List<Dimension> getAllRadarDimension(String uid) {
        return List.of();
    }

    @Override
    public Forecast getForecast(LocalDate date) {
        return null;
    }

    @Override
    public void markRadarAsFault(String uid) {

    }

    @Override
    public void markRadarAsServiceable(String uid) {

    }

    @Override
    public List<Radar> getAlFaultyRadar() {
        return List.of();
    }
}
