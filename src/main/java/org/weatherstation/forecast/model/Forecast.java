package main.java.org.weatherstation.forecast.model;

public class Forecast {
    private double temperature;
    private double humidity;
    private double wind;
    private boolean isAccurate;

    /**
     * @param temperature
     * @param humidity
     * @param wind
     */
    public Forecast(double temperature, double humidity, double wind, boolean isAccurate) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.wind = wind;
        this.isAccurate = isAccurate;
    }

    @Override
    public String toString() {
        return "Forecast{" +
                "temperature=" + temperature +
                ", humidity=" + humidity +
                ", wind=" + wind +
                ", isAccurate=" + isAccurate +
                '}';
    }

    public boolean isAccurate() {
        return isAccurate;
    }
}
