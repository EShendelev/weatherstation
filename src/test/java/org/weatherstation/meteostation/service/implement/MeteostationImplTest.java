package test.java.org.weatherstation.meteostation.service.implement;

import main.java.org.weatherstation.forecast.model.Forecast;
import main.java.org.weatherstation.meteostation.service.implement.MeteostationImpl;
import main.java.org.weatherstation.meteostation.service.interfaces.Meteostation;
import main.java.org.weatherstation.radar.model.Radar;
import main.java.org.weatherstation.radar.storage.RadarStorage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static main.java.org.weatherstation.dimension.model.TypeOfDimension.*;
import static org.junit.jupiter.api.Assertions.*;


class MeteostationImplTest {

    private static final Meteostation meteostation = new MeteostationImpl();


    @BeforeAll
    public static void addData() {
        meteostation.addRadar("Chazhemto",58.060231, 82.826753, WIND);
        meteostation.addRadar("Chazhemto",58.060231, 82.826753, HUMIDITY);
        meteostation.addRadar("Chazhemto",58.060231, 82.826753, TEMPERATURE);
        meteostation.addRadar("Tomsk", 56.484645, 84.947649, WIND);
        meteostation.addRadar("Tomsk", 56.484645, 84.947649, HUMIDITY);
        meteostation.addRadar("Tomsk", 56.484645, 84.947649, TEMPERATURE);
        meteostation.addRadar("Rostov-On-Don", 47.222109, 39.718813, WIND);
        meteostation.addRadar("Rostov-On-Don", 47.222109, 39.718813, HUMIDITY);
        meteostation.addRadar("Rostov-On-Don", 47.222109, 39.718813, TEMPERATURE);
        meteostation.addRadar("Moscow", 55.755864, 37.617698, WIND);
        meteostation.addRadar("Moscow", 55.755864, 37.617698, HUMIDITY);
        meteostation.addRadar("Moscow", 55.755864, 37.617698, TEMPERATURE);


        //-WIND-
        meteostation.addDimension("Chazhemto_1", LocalDate.now(), 5);
        meteostation.addDimension("Chazhemto_1", LocalDate.now(), 2);
        meteostation.addDimension("Chazhemto_1", LocalDate.now().minusDays(1), 5);
        meteostation.addDimension("Chazhemto_1", LocalDate.now().minusDays(1), 15);
        meteostation.addDimension("Chazhemto_1", LocalDate.now().minusDays(2), 3);
        meteostation.addDimension("Chazhemto_1", LocalDate.now().minusDays(4), 2);
        meteostation.addDimension("Chazhemto_1", LocalDate.now().minusDays(5), 7);
        meteostation.addDimension("Chazhemto_1", LocalDate.now().minusDays(3), 10);
        //-HUMIDITY
        meteostation.addDimension("Chazhemto_2", LocalDate.now(), 5);
        meteostation.addDimension("Chazhemto_2", LocalDate.now(), 2);
        meteostation.addDimension("Chazhemto_2", LocalDate.now().minusDays(1), 5);
        meteostation.addDimension("Chazhemto_2", LocalDate.now().minusDays(1), 15);
        meteostation.addDimension("Chazhemto_2", LocalDate.now().minusDays(2), 3);
        meteostation.addDimension("Chazhemto_2", LocalDate.now().minusDays(4), 2);
        meteostation.addDimension("Chazhemto_2", LocalDate.now().minusDays(5), 7);
        meteostation.addDimension("Chazhemto_2", LocalDate.now().minusDays(3), 10);
        //-TEMPERATURE
        meteostation.addDimension("Chazhemto_3", LocalDate.now(), 5);
        meteostation.addDimension("Chazhemto_3", LocalDate.now(), 2);
        meteostation.addDimension("Chazhemto_3", LocalDate.now().minusDays(1), 5);
        meteostation.addDimension("Chazhemto_3", LocalDate.now().minusDays(1), 15);
        meteostation.addDimension("Chazhemto_3", LocalDate.now().minusDays(2), 3);
        meteostation.addDimension("Chazhemto_3", LocalDate.now().minusDays(4), 2);
        meteostation.addDimension("Chazhemto_3", LocalDate.now().minusDays(5), 7);
        meteostation.addDimension("Chazhemto_3", LocalDate.now().minusDays(3), 10);
        //-WIND-
        meteostation.addDimension("Tomsk_4", LocalDate.now(), 5);
        meteostation.addDimension("Tomsk_4", LocalDate.now(), 2);
        meteostation.addDimension("Tomsk_4", LocalDate.now().minusDays(1), 5);
        meteostation.addDimension("Tomsk_4", LocalDate.now().minusDays(1), 15);
        meteostation.addDimension("Tomsk_4", LocalDate.now().minusDays(2), 3);
        meteostation.addDimension("Tomsk_4", LocalDate.now().minusDays(4), 2);
        meteostation.addDimension("Tomsk_4", LocalDate.now().minusDays(5), 7);
        meteostation.addDimension("Tomsk_4", LocalDate.now().minusDays(3), 10);
        //-HUMIDITY
        meteostation.addDimension("Tomsk_5", LocalDate.now(), 5);
        meteostation.addDimension("Tomsk_5", LocalDate.now(), 2);
        meteostation.addDimension("Tomsk_5", LocalDate.now().minusDays(1), 5);
        meteostation.addDimension("Tomsk_5", LocalDate.now().minusDays(1), 15);
        meteostation.addDimension("Tomsk_5", LocalDate.now().minusDays(2), 3);
        meteostation.addDimension("Tomsk_5", LocalDate.now().minusDays(4), 2);
        meteostation.addDimension("Tomsk_5", LocalDate.now().minusDays(5), 7);
        meteostation.addDimension("Tomsk_5", LocalDate.now().minusDays(3), 10);
        //-TEMPERATURE
        meteostation.addDimension("Tomsk_6", LocalDate.now(), 5);
        meteostation.addDimension("Tomsk_6", LocalDate.now(), 2);
        meteostation.addDimension("Tomsk_6", LocalDate.now().minusDays(1), 5);
        meteostation.addDimension("Tomsk_6", LocalDate.now().minusDays(1), 15);
        meteostation.addDimension("Tomsk_6", LocalDate.now().minusDays(2), 3);
        meteostation.addDimension("Tomsk_6", LocalDate.now().minusDays(4), 2);
        meteostation.addDimension("Tomsk_6", LocalDate.now().minusDays(5), 7);
        meteostation.addDimension("Tomsk_6", LocalDate.now().minusDays(3), 10);
        //-WIND-
        meteostation.addDimension("Rostov-On-Don_7", LocalDate.now(), 5);
        meteostation.addDimension("Rostov-On-Don_7", LocalDate.now(), 2);
        meteostation.addDimension("Rostov-On-Don_7", LocalDate.now().minusDays(1), 5);
        meteostation.addDimension("Rostov-On-Don_7", LocalDate.now().minusDays(1), 15);
        meteostation.addDimension("Rostov-On-Don_7", LocalDate.now().minusDays(2), 3);
        meteostation.addDimension("Rostov-On-Don_7", LocalDate.now().minusDays(4), 2);
        meteostation.addDimension("Rostov-On-Don_7", LocalDate.now().minusDays(5), 7);
        meteostation.addDimension("Rostov-On-Don_7", LocalDate.now().minusDays(3), 10);
        //-HUMIDITY
        meteostation.addDimension("Rostov-On-Don_8", LocalDate.now(), 5);
        meteostation.addDimension("Rostov-On-Don_8", LocalDate.now(), 2);
        meteostation.addDimension("Rostov-On-Don_8", LocalDate.now().minusDays(1), 5);
        meteostation.addDimension("Rostov-On-Don_8", LocalDate.now().minusDays(1), 15);
        meteostation.addDimension("Rostov-On-Don_8", LocalDate.now().minusDays(2), 3);
        meteostation.addDimension("Rostov-On-Don_8", LocalDate.now().minusDays(4), 2);
        meteostation.addDimension("Rostov-On-Don_8", LocalDate.now().minusDays(5), 7);
        meteostation.addDimension("Rostov-On-Don_8", LocalDate.now().minusDays(3), 10);
        //-TEMPERATURE
        meteostation.addDimension("Rostov-On-Don_9", LocalDate.now(), 5);
        meteostation.addDimension("Rostov-On-Don_9", LocalDate.now(), 2);
        meteostation.addDimension("Rostov-On-Don_9", LocalDate.now().minusDays(1), 5);
        meteostation.addDimension("Rostov-On-Don_9", LocalDate.now().minusDays(1), 15);
        meteostation.addDimension("Rostov-On-Don_9", LocalDate.now().minusDays(2), 3);
        meteostation.addDimension("Rostov-On-Don_9", LocalDate.now().minusDays(4), 2);
        meteostation.addDimension("Rostov-On-Don_9", LocalDate.now().minusDays(5), 7);
        meteostation.addDimension("Rostov-On-Don_9", LocalDate.now().minusDays(3), 10);
        //-WIND-
        meteostation.addDimension("Moscow_10", LocalDate.now(), 5);
        meteostation.addDimension("Moscow_10", LocalDate.now(), 2);
        meteostation.addDimension("Moscow_10", LocalDate.now().minusDays(1), 5);
        meteostation.addDimension("Moscow_10", LocalDate.now().minusDays(1), 15);
        meteostation.addDimension("Moscow_10", LocalDate.now().minusDays(2), 3);
        meteostation.addDimension("Moscow_10", LocalDate.now().minusDays(4), 2);
        meteostation.addDimension("Moscow_10", LocalDate.now().minusDays(5), 7);
        meteostation.addDimension("Moscow_10", LocalDate.now().minusDays(3), 10);
        //-HUMIDITY
        meteostation.addDimension("Moscow_11", LocalDate.now(), 5);
        meteostation.addDimension("Moscow_11", LocalDate.now(), 2);
        meteostation.addDimension("Moscow_11", LocalDate.now().minusDays(1), 5);
        meteostation.addDimension("Moscow_11", LocalDate.now().minusDays(1), 15);
        meteostation.addDimension("Moscow_11", LocalDate.now().minusDays(2), 3);
        meteostation.addDimension("Moscow_11", LocalDate.now().minusDays(4), 2);
        meteostation.addDimension("Moscow_11", LocalDate.now().minusDays(5), 7);
        meteostation.addDimension("Moscow_11", LocalDate.now().minusDays(3), 10);
        //-TEMPERATURE
        meteostation.addDimension("Moscow_12", LocalDate.now(), 5);
        meteostation.addDimension("Moscow_12", LocalDate.now(), 2);
        meteostation.addDimension("Moscow_12", LocalDate.now().minusDays(1), 5);
        meteostation.addDimension("Moscow_12", LocalDate.now().minusDays(1), 15);
        meteostation.addDimension("Moscow_12", LocalDate.now().minusDays(2), 3);
        meteostation.addDimension("Moscow_12", LocalDate.now().minusDays(4), 2);
        meteostation.addDimension("Moscow_12", LocalDate.now().minusDays(5), 7);
        meteostation.addDimension("Moscow_12", LocalDate.now().minusDays(3), 10);
    }


    @Test
    void getAllRadarDimensionTest() {
        Radar radarChazhemto1 = RadarStorage.radarList.get("Chazhemto_1");
        Radar radarTomsk5 = RadarStorage.radarList.get("Tomsk_5");
        Radar radarRnD8 = RadarStorage.radarList.get("Rostov-On-Don_8");
        assertEquals(8, radarChazhemto1.getAllRadarDimension().size());
        assertEquals(8, radarTomsk5.getAllRadarDimension().size());
        assertEquals(8, radarRnD8.getAllRadarDimension().size());

    }

    @Test
    void getForecast() {
        meteostation.markRadarAsFault("Moscow_11");
        meteostation.markRadarAsFault("Rostov-On-Don_9");
        Forecast forecast = meteostation.getForecast(LocalDate.now());
        assertFalse(forecast.isAccurate());

        meteostation.markRadarAsServiceable("Moscow_11");
        meteostation.markRadarAsServiceable("Rostov-On-Don_9");
        Forecast forecast1 = meteostation.getForecast(LocalDate.now());
        assertTrue(forecast1.isAccurate());
    }

    @Test
    void markRadarAsFaultTest() {
        meteostation.markRadarAsFault("Moscow_10");
        
    }

    @Test
    void markRadarAsServiceable() {
        meteostation.markRadarAsFault("Moscow_10");
        assertFalse(RadarStorage.radarList.get("Moscow_10").isServiceable());
        meteostation.markRadarAsServiceable("Moscow_10");
        assertTrue(RadarStorage.radarList.get("Moscow_10").isServiceable());
    }

    @Test
    void getAllFaultyRadars() {
        meteostation.markRadarAsFault("Moscow_10");
        meteostation.markRadarAsFault("Moscow_12");
        meteostation.markRadarAsFault("Rostov-On-Don_9");
        meteostation.markRadarAsFault("Tomsk_4");
        assertFalse(RadarStorage.faultyRadarIds.isEmpty());
        assertEquals(4, RadarStorage.faultyRadarIds.size());
    }
}