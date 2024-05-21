package main.java.org.weatherstation.dimension.model;


import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DimensionManager {
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

    }
}