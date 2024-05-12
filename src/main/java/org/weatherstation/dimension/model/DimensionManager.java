package main.java.org.weatherstation.dimension.model;

import java.util.HashMap;
import java.util.Map;

public class DimensionManager {
    private static final Map<TypeOfDimension, Map<Long, Dimension>> dimensionJournal = new HashMap<>();

    public static Map<TypeOfDimension, Map<Long, Dimension>> getAllDimensions() {
        return new HashMap<>(dimensionJournal);
    }


    public static void writeDimension(TypeOfDimension typeOfDimension, Dimension dimension) {
        Map<Long, Dimension> dimensionList = dimensionJournal.getOrDefault(typeOfDimension, new HashMap<>());
        Long id = dimension.getId();
        dimensionList.put(id, dimension);
        dimensionJournal.put(typeOfDimension, dimensionList);
    }
}
