package main.java.org.weatherstation.forecast.model;


import main.java.org.weatherstation.dimension.model.TypeOfDimension;
import main.java.org.weatherstation.radar.model.Radar;


import static main.java.org.weatherstation.radar.storage.RadarStorage.*;

import java.time.LocalDate;
import java.util.*;


public class ForecastManager {

    private Set<Boolean> flags;



    public Forecast getForecast(LocalDate date) {
        flags = new HashSet<>();
        List<Double> windValuesList =
                getAverageValuesOfRadarsByTypeForForecastWithAccurateFlag(TypeOfDimension.WIND, date);
        List<Double> temperatureValuesList =
                getAverageValuesOfRadarsByTypeForForecastWithAccurateFlag(TypeOfDimension.TEMPERATURE, date);
        List<Double> humidityValuesList =
                getAverageValuesOfRadarsByTypeForForecastWithAccurateFlag(TypeOfDimension.HUMIDITY, date);

        boolean isAccurate = !flags.contains(false);
        double wind = average(windValuesList);
        double temperature = average(temperatureValuesList);
        double humidity = average(humidityValuesList);
        return new Forecast(temperature, humidity, wind, isAccurate);
    }

    private List<Double> getAverageValuesOfRadarsByTypeForForecastWithAccurateFlag
            (TypeOfDimension typeOfDimension, LocalDate date) {

        List<String> radarUids = radarJournalByType.get(typeOfDimension);
        boolean flag = true;

        Set<Boolean> accurateFlags = new HashSet<>();
        List<Double> averageValuesList = new ArrayList<>();

        for (String uid : radarUids) {
            Radar radar = radarList.get(uid);
            if (!radar.isServiceable()) {
                continue;
            }
            Map<Boolean, Double> averageWithFlag = radar.getAverageValueWithAccurateFlag(date);
            accurateFlags.addAll(averageWithFlag.keySet());
            Double value = averageWithFlag.getOrDefault(true, averageWithFlag.get(false));
            averageValuesList.add(value);
        }

        if (accurateFlags.contains(false) || radarUids.size() < 2) {
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


