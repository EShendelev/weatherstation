package main.java.org.weatherstation.dimension.model;

import main.java.org.weatherstation.dimension.service.util.IdGenerator;

import java.time.LocalDate;

public class Dimension {
    private long id;
    private LocalDate date;
    private double value;

    public Dimension(double value) {
        id = IdGenerator.getId();
        date = LocalDate.now();
        this.value = value;

    }

    public Long getId() {
        return id;
    }
}
