package main.java.org.weatherstation.meteostation.service.interfaces;

import main.java.org.weatherstation.dimension.model.Dimension;
import main.java.org.weatherstation.dimension.model.TypeOfDimension;
import main.java.org.weatherstation.forecast.model.Forecast;
import main.java.org.weatherstation.radar.model.Radar;

import javax.xml.crypto.dsig.DigestMethod;
import java.time.LocalDate;
import java.util.List;

public interface Meteostation {

    void addRadar(String name, String prefix, double latitude, double longitude, TypeOfDimension typeOfDimension);

    void addDimension(String radarUid, LocalDate date, Dimension dimension);

    List<Dimension> getAllRadarDimension(String uid);

    Forecast getForecast(LocalDate date);

    void markRadarAsFault(String uid);

    void markRadarAsServiceable(String uid);

    List<Radar> getAlFaultyRadar();
}
