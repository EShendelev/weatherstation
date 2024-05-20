package main.java.org.weatherstation.radar.model;


import main.java.org.weatherstation.dimension.model.Dimension;
import main.java.org.weatherstation.dimension.model.TypeOfDimension;

public class WindRadar extends Radar{
    public WindRadar(String uid, String name, double latitude, double longitude) {
        super(uid, name, latitude, longitude);
        typeOfDimension = TypeOfDimension.WIND;
    }


}
