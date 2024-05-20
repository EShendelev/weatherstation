package main.java.org.weatherstation.dimension.model;


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

    }
}