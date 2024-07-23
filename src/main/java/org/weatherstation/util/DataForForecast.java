package main.java.org.weatherstation.util;

import java.util.ArrayList;
import java.util.List;

public class DataForForecast {
    private boolean isAccurate = true;
    private List<Double> windAverageList = new ArrayList<>();
    private List<Double> humidityAverageList = new ArrayList<>();
    private List<Double> temperatureAverageList = new ArrayList<>();

    public DataForForecast() {

    }

    public boolean isAccurate() {
        return isAccurate;
    }

    public void setAccurate(boolean accurate) {
        isAccurate = accurate;
    }

    public void setWindAverageList(List<Double> windAverageList) {
        this.windAverageList = windAverageList;
    }

    public void setHumidityAverageList(List<Double> humidityAverageList) {
        this.humidityAverageList = humidityAverageList;
    }

    public void setTemperatureAverageList(List<Double> temperatureAverageList) {
        this.temperatureAverageList = temperatureAverageList;
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
