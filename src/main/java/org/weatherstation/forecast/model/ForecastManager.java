package main.java.org.weatherstation.forecast.model;


import main.java.org.weatherstation.dimension.model.TypeOfDimension;
import main.java.org.weatherstation.radar.model.Radar;
import main.java.org.weatherstation.radar.model.RadarManager;
import main.java.org.weatherstation.util.DataForForecast;


import java.time.LocalDate;
import java.util.*;
import java.util.function.Consumer;

public class ForecastManager {

    private final RadarManager radarManager;
    private static final int MINIMAL_COUNT_OF_RADAR_FOR_FORECAST = 2;

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
        Map<TypeOfDimension, Consumer<List<Double>>> setterByType = new HashMap<>();

        DataForForecast dataForForecast = new DataForForecast();
        setterByType.put(TypeOfDimension.WIND, dataForForecast::setWindAverageList);
        setterByType.put(TypeOfDimension.HUMIDITY, dataForForecast::setHumidityAverageList);
        setterByType.put(TypeOfDimension.TEMPERATURE, dataForForecast::setTemperatureAverageList);

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

            setterByType.get(typeOfDimension).accept(averageValuesList);
        }
        dataForForecast.setAccurate(flag);

        return dataForForecast;
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


