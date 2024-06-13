package main.java.org.weatherstation.dimension.service;


import main.java.org.weatherstation.dimension.model.Dimension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DimensionManager {
    //хранит список по UID радара и дате измерения.
    private static final Map<String, Map<LocalDate, List<Dimension>>> dimensionJournal = new HashMap<>();

    public static Map<String, Map<LocalDate, List<Dimension>>> getAllDimensions() {
        return new HashMap<>(dimensionJournal);
    }

    /**
     *
     * @param radarUid
     * @param date
     * @param dimension
     */
    public void addDimension(String radarUid, LocalDate date, Dimension dimension) {
        Map<LocalDate, List<Dimension>> dimensionMap = dimensionJournal.getOrDefault(radarUid,
                new HashMap<>());
        List<Dimension> dimensions = dimensionMap.getOrDefault(date, new ArrayList<>());
        dimensions.add(dimension);
        dimensionMap.put(date, dimensions);
        dimensionJournal.put(radarUid, dimensionMap);
    }
}