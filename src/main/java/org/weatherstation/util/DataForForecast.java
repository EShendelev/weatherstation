package main.java.org.weatherstation.util;

import java.util.ArrayList;
import java.util.List;

public class DataForForecast {
    private boolean isAccurate = true;
    private final List<Double> windAverageList = new ArrayList<>();
    private final List<Double> humidityAverageList = new ArrayList<>();
    private final List<Double> temperatureAverageList = new ArrayList<>();

    public DataForForecast() {

    }

    public boolean isAccurate() {
        return isAccurate;
    }

    public void setAccurate(boolean accurate) {
        isAccurate = accurate;
    }

    public void setWindAverageList(List<Double> windAverageList) {
        this.windAverageList.addAll(windAverageList);
    }

    public void setHumidityAverageList(List<Double> humidityAverageList) {
        this.humidityAverageList.addAll(humidityAverageList);
    }

    public void setTemperatureAverageList(List<Double> temperatureAverageList) {
        this.temperatureAverageList.addAll(temperatureAverageList);
    }

    public List<Double> getWindAverageList() {
        return windAverageList;
    }

    public List<Double> getHumidityAverageList() {
        return humidityAverageList;
    }

    public List<Double> getTemperatureAverageList() {
        return temperatureAverageList;
    }
}
