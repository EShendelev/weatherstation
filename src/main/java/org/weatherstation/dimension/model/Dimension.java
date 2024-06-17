package main.java.org.weatherstation.dimension.model;

import main.java.org.weatherstation.dimension.service.util.IdGenerator;

import java.time.LocalDate;

public class Dimension {
    private String radarUid;
    private long id;
    private final LocalDate date;
    private double value;

    public Dimension(String radarUid, LocalDate date, double value) {
        this.radarUid = radarUid;
        id = IdGenerator.getId();
        this.date = date;
        this.value = value;
    }

    public LocalDate getDate() {
        return date;
    }
}
