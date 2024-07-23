package main.java.org.weatherstation.forecast.model;


import main.java.org.weatherstation.dimension.model.TypeOfDimension;
import main.java.org.weatherstation.radar.model.Radar;
import main.java.org.weatherstation.radar.model.RadarManager;
import main.java.org.weatherstation.util.DataForForecast;


import java.time.LocalDate;
import java.util.*;


public class ForecastManager {

    private final RadarManager radarManager;
    private static final int MINIMAL_COUNT_OF_RADAR_FOR_FORECAST = 2;
    private static final int COUNT_OF_PARAMETER = 3;

    public ForecastManager(RadarManager radarManager) {
        this.radarManager = radarManager;
    }


    public Forecast getForecast(LocalDate date) {

        DataForForecast dataForForecast = getDataForForecast(date);

        double wind = average(dataForForecast.getWindAverageList());
        double temperature = average(dataForForecast.getTemperatureAverageList());
        double humidity = average(dataForForecast.getHumidityAverageList());
        boolean isAccurate = dataForForecast.isAccurate();

        return new Forecast(temperature, humidity, wind, isAccurate);
    }



    private DataForForecast getDataForForecast
            (LocalDate date) {
        DataForForecast avgWithAccurateFlag = new DataForForecast();
        Set<Boolean> accurateFlags = new HashSet<>();
        boolean flag = true;

        for (TypeOfDimension typeOfDimension : TypeOfDimension.values()) {
            List<String> radarUids = radarManager.getRadarListByType(typeOfDimension);
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
            // при добавлении нового типа измерения, добавить case
            switch (typeOfDimension) {
                case WIND:
                    avgWithAccurateFlag.setWindAverageList(averageValuesList);
                case HUMIDITY:
                    avgWithAccurateFlag.setHumidityAverageList(averageValuesList);
                case TEMPERATURE:
                    avgWithAccurateFlag.setTemperatureAverageList(averageValuesList);
            }
        }
        avgWithAccurateFlag.setAccurate(flag);

        return avgWithAccurateFlag;
    }

    private double average(List<Double> valuesList) {
        double sum = 0.0;
        int listSize = valuesList.size();
        for (double val : valuesList) {
            sum += val;
        }
        return sum / listSize;
    }
}


