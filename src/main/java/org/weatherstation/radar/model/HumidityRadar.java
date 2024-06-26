package main.java.org.weatherstation.radar.model;


import main.java.org.weatherstation.dimension.model.TypeOfDimension;

public class HumidityRadar extends Radar{
    public HumidityRadar(String uid, double latitude, double longitude) {
        super(uid, latitude, longitude);
        typeOfDimension = TypeOfDimension.HUMIDITY;
    }
}
