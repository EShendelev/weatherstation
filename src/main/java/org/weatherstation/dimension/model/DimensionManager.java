package main.java.org.weatherstation.dimension.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DimensionManager {
    private static final Map<TypeOfDimension, Map<String, List<Dimension>>> dimensionJournal = new HashMap<>();

    public static Map<TypeOfDimension, Map<String, List<Dimension>>> getAllDimensions() {
        return new HashMap<>(dimensionJournal);
    }

    /**
     * Сохраняет измерение в журнал, с группировкой по типу и uid радара
     * @param typeOfDimension
     * @param dimension
     */
    public static void writeDimension(TypeOfDimension typeOfDimension, Dimension dimension) {
        String radarUid = dimension.getRadarUid();
        Map<String, List<Dimension>> dimensionList = dimensionJournal.getOrDefault(typeOfDimension, new HashMap<>());
        List<Dimension> radarDimensionList = dimensionList.getOrDefault(radarUid, new ArrayList<>());
        radarDimensionList.add(dimension);
        dimensionList.put(radarUid, radarDimensionList);
        dimensionJournal.put(typeOfDimension, dimensionList);
    }
}