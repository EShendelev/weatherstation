package main.java.org.weatherstation.radar.model;


import main.java.org.weatherstation.dimension.model.Dimension;
import main.java.org.weatherstation.dimension.model.TypeOfDimension;

import java.time.LocalDate;
import java.util.*;

public abstract class Radar {
    private String uid;
    private double latitude;
    private double longitude;
    private boolean isServiceable;
    //радар хранит в себе список своих измерений - снести, менеджер хранит записи с радаров
    private final Map<LocalDate, List<Dimension>> dimensionList;

    protected TypeOfDimension typeOfDimension;

    public Radar(String uid, double latitude, double longitude) {
        this.uid = uid;
        this.latitude = latitude;
        this.longitude = longitude;
        isServiceable = true;
        dimensionList = new HashMap<>();
    }

    public List<Dimension> getAllRadarDimension() {
        List<Dimension> dimensions = new ArrayList<>();
        for (LocalDate date : dimensionList.keySet()) {
            dimensions.addAll(dimensionList.get(date));
        }

        dimensions.sort(Comparator.comparing(Dimension::getDate));
        return dimensions;
    }


    public void makeDimension(LocalDate date, double value) {
        Dimension dimension = new Dimension(uid, date, value);
        List<Dimension> dimensions = dimensionList.getOrDefault(date, new ArrayList<>());
          dimensions.add(dimension);
          dimensionList.put(date, dimensions);
                }

    private List<Dimension> getFiveDaysListDimensionForForecast(LocalDate date) {
        List<Dimension> dimensions = new ArrayList<>();
        for (int i = 0; i <= 5; i++) {
            dimensions.addAll(getDimensionListForDay(date.minusDays(i)));
        }
        return dimensions;
    }

    private Boolean determinateIsAccurate(LocalDate date) {
        Boolean res = true;
        for (int i = 0; i <= 5; i++) {
            List<Dimension> dimensionsForDay = dimensionList.get(date.minusDays(i));
            if (dimensionsForDay.isEmpty()) {
                res = false;
                break;
            }
        }
        return res;
    }

    public Map<Boolean, Double> getAverageValueWithAccurateFlag(LocalDate date) {
        Map<Boolean, Double> result = new HashMap<>();
        List<Dimension> dimensions = getFiveDaysListDimensionForForecast(date);
        Boolean isAccurate = determinateIsAccurate(date);
        Integer countOfValue = dimensions.size();
        Double sumOfValues = 0.0;
        for (Dimension dimension : dimensions) {
            sumOfValues += dimension.getValue();
        }
        Double averageValue = sumOfValues / countOfValue;
        result.put(isAccurate, averageValue);
        return result;
    }

    private List<Dimension> getDimensionListForDay(LocalDate date) {
        return new ArrayList<>(dimensionList.get(date));
    }

    public String getUid() {
        return uid;
    }

    public boolean isServiceable() {
        return isServiceable;
    }

    public void setServiceable(boolean serviceable) {
        isServiceable = serviceable;
    }


    public TypeOfDimension getDimensionType() {
        return typeOfDimension;
    }

    @Override
    public String toString() {
        return "Radar{" +
                "uid='" + uid + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", isServiceable=" + isServiceable +
                ", dimensionList=" + dimensionList +
                ", typeOfDimension=" + typeOfDimension +
                '}';
    }
}
