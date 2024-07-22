package main.java.org.weatherstation.forecast.model;


import main.java.org.weatherstation.dimension.model.TypeOfDimension;
import main.java.org.weatherstation.radar.model.Radar;
import main.java.org.weatherstation.radar.model.RadarManager;


import java.time.LocalDate;
import java.util.*;


public class ForecastManager {

    //плохая практика
    private Set<Boolean> flags;
    private final RadarManager radarManager;
    private static final int MINIMAL_COUNT_OF_RADAR_FOR_FORECAST = 2;

    public ForecastManager(RadarManager radarManager) {
        this.radarManager = radarManager;
    }


    public Forecast getForecast(LocalDate date) {
        flags = new HashSet<>();
        List<Double> windValuesList =
                getAverageValuesOfRadarsByTypeForForecast(TypeOfDimension.WIND, date);
        List<Double> temperatureValuesList =
                getAverageValuesOfRadarsByTypeForForecast(TypeOfDimension.TEMPERATURE, date);
        List<Double> humidityValuesList =
                getAverageValuesOfRadarsByTypeForForecast(TypeOfDimension.HUMIDITY, date);

        boolean isAccurate = !flags.contains(false);

        double wind = average(windValuesList);
        double temperature = average(temperatureValuesList);
        double humidity = average(humidityValuesList);

        return new Forecast(temperature, humidity, wind, isAccurate);
    }

    private List<Double> getAverageValuesOfRadarsByTypeForForecast
            (TypeOfDimension typeOfDimension, LocalDate date) {

        List<String> radarUids = radarManager.getRadarListByType(typeOfDimension);
        boolean flag = true;

        Set<Boolean> accurateFlags = new HashSet<>();
        List<Double> averageValuesList = new ArrayList<>();

        for (String uid : radarUids) {
            Radar radar = radarManager.getRadarByUid(uid);
            if (!radar.isServiceable()) {
                accurateFlags.add(false);
                continue;
            }

            Map<Boolean, Double> averageWithFlag = radar.getAverageValueWithAccurateFlag(date);
            accurateFlags.addAll(averageWithFlag.keySet());
            Double value = averageWithFlag.getOrDefault(true, averageWithFlag.get(false));
            averageValuesList.add(value);
        }

        if (accurateFlags.contains(false) || radarUids.size() < MINIMAL_COUNT_OF_RADAR_FOR_FORECAST) {
            flag = false;
        }
        flags.add(flag);

        return new ArrayList<>(averageValuesList);
    }

    private Double average(List<Double> valuesList) {
        double sum = 0.0;
        int listSize = valuesList.size();
        for (double val : valuesList) {
            sum += val;
        }
        return sum / listSize;
    }
}


