package test.java.org.weatherstation.radar.service.util;

import main.java.org.weatherstation.dimension.model.TypeOfDimension;
import main.java.org.weatherstation.radar.model.Radar;
import main.java.org.weatherstation.radar.service.util.RadarMaker;
import org.junit.jupiter.api.Test;

import static main.java.org.weatherstation.dimension.model.TypeOfDimension.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RadarMakerTest {

    RadarMaker radarMaker = new RadarMaker();

    @Test
    public void createRadarTest() {
        Radar radar1 = radarMaker.makeRadar("Chazhemto",
                58.060231, 82.826753, WIND);
        Radar radar2 = radarMaker.makeRadar("Chazhemto",
                58.060231, 82.826753, TEMPERATURE);
        Radar radar3 = radarMaker.makeRadar("Chazhemto",
                58.060231, 82.826753, HUMIDITY);
        assertEquals("Chazhemto_1", radar1.getUid());
        assertEquals("Chazhemto_2", radar2.getUid());
        assertEquals("Chazhemto_3", radar3.getUid());
        assertEquals(WIND, radar1.getDimensionType());
        assertEquals(TEMPERATURE, radar2.getDimensionType());
        assertEquals(HUMIDITY, radar3.getDimensionType());
    }

    @Test
    public void expectedExceptionCreateTest() {
        assertThrows(IllegalArgumentException.class, () -> radarMaker.makeRadar("Chazhemto",58.060231,
                82.826753, TypeOfDimension.valueOf("SOME_TYPE")));
    }
}