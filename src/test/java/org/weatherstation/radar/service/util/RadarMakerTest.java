package test.java.org.weatherstation.radar.service.util;

import main.java.org.weatherstation.dimension.model.TypeOfDimension;
import main.java.org.weatherstation.radar.model.Radar;
import main.java.org.weatherstation.radar.service.util.RadarMaker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static main.java.org.weatherstation.dimension.model.TypeOfDimension.*;

import static org.junit.jupiter.api.Assertions.*;

class RadarMakerTest {
    static Radar radar1;
    static Radar radar2;
    static Radar radar3;
    @BeforeAll
    public static void init() {
        radar1 = RadarMaker.makeRadar("Chazhemto",
                58.060231, 82.826753, WIND);
        radar2 = RadarMaker.makeRadar("Chazhemto",
                58.060231, 82.826753, TEMPERATURE);
        radar3 = RadarMaker.makeRadar("Chazhemto",
                58.060231, 82.826753, HUMIDITY);
    }

    @Test
    public void radar1UidTest() {
        assertEquals("Chazhemto_1", radar1.getUid());
    }

    @Test
    public void radar2UidTest() {
        assertEquals("Chazhemto_2", radar2.getUid());
    }

    @Test
    public void radar3UidTest() {
        assertEquals("Chazhemto_3", radar3.getUid());
    }

    @Test
    public void radar1TypeTest() {
        assertEquals(WIND, radar1.getDimensionType());
    }

    @Test
    public void radar2TypeTest() {
        assertEquals(TEMPERATURE, radar2.getDimensionType());
    }

    @Test
    public void radar3TypeTest() {
        assertEquals(HUMIDITY, radar3.getDimensionType());
    }
}