package test.java.org.weatherstation.meteostation.service.implement;

import main.java.org.weatherstation.forecast.model.Forecast;
import main.java.org.weatherstation.meteostation.service.implement.MeteostationManagerImpl;
import main.java.org.weatherstation.meteostation.service.interfaces.MeteostationMandager;
import main.java.org.weatherstation.radar.model.Radar;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.time.LocalDate;

import static main.java.org.weatherstation.dimension.model.TypeOfDimension.*;
import static org.junit.jupiter.api.Assertions.*;


class __MeteostationImplTest {

    private static final MeteostationMandager meteostationManager = new MeteostationManagerImpl();



    @BeforeAll
    public static void addData() {
        meteostationManager.addRadar("Chazhemto",58.060231, 82.826753, WIND);
        meteostationManager.addRadar("Chazhemto",58.060231, 82.826753, HUMIDITY);
        meteostationManager.addRadar("Chazhemto",58.060231, 82.826753, TEMPERATURE);
        meteostationManager.addRadar("Tomsk", 56.484645, 84.947649, WIND);
        meteostationManager.addRadar("Tomsk", 56.484645, 84.947649, HUMIDITY);
        meteostationManager.addRadar("Tomsk", 56.484645, 84.947649, TEMPERATURE);
        meteostationManager.addRadar("Rostov-On-Don", 47.222109, 39.718813, WIND);
        meteostationManager.addRadar("Rostov-On-Don", 47.222109, 39.718813, HUMIDITY);
        meteostationManager.addRadar("Rostov-On-Don", 47.222109, 39.718813, TEMPERATURE);
        meteostationManager.addRadar("Moscow", 55.755864, 37.617698, WIND);
        meteostationManager.addRadar("Moscow", 55.755864, 37.617698, HUMIDITY);
        meteostationManager.addRadar("Moscow", 55.755864, 37.617698, TEMPERATURE);


        //-WIND-
        meteostationManager.addDimension("Chazhemto_1", LocalDate.now(), 5);
        meteostationManager.addDimension("Chazhemto_1", LocalDate.now(), 2);
        meteostationManager.addDimension("Chazhemto_1", LocalDate.now().minusDays(1), 5);
        meteostationManager.addDimension("Chazhemto_1", LocalDate.now().minusDays(1), 15);
        meteostationManager.addDimension("Chazhemto_1", LocalDate.now().minusDays(2), 3);
        meteostationManager.addDimension("Chazhemto_1", LocalDate.now().minusDays(4), 2);
        meteostationManager.addDimension("Chazhemto_1", LocalDate.now().minusDays(5), 7);
        meteostationManager.addDimension("Chazhemto_1", LocalDate.now().minusDays(3), 10);
        //-HUMIDITY
        meteostationManager.addDimension("Chazhemto_2", LocalDate.now(), 5);
        meteostationManager.addDimension("Chazhemto_2", LocalDate.now(), 2);
        meteostationManager.addDimension("Chazhemto_2", LocalDate.now().minusDays(1), 5);
        meteostationManager.addDimension("Chazhemto_2", LocalDate.now().minusDays(1), 15);
        meteostationManager.addDimension("Chazhemto_2", LocalDate.now().minusDays(2), 3);
        meteostationManager.addDimension("Chazhemto_2", LocalDate.now().minusDays(4), 2);
        meteostationManager.addDimension("Chazhemto_2", LocalDate.now().minusDays(5), 7);
        meteostationManager.addDimension("Chazhemto_2", LocalDate.now().minusDays(3), 10);
        //-TEMPERATURE
        meteostationManager.addDimension("Chazhemto_3", LocalDate.now(), 5);
        meteostationManager.addDimension("Chazhemto_3", LocalDate.now(), 2);
        meteostationManager.addDimension("Chazhemto_3", LocalDate.now().minusDays(1), 5);
        meteostationManager.addDimension("Chazhemto_3", LocalDate.now().minusDays(1), 15);
        meteostationManager.addDimension("Chazhemto_3", LocalDate.now().minusDays(2), 3);
        meteostationManager.addDimension("Chazhemto_3", LocalDate.now().minusDays(4), 2);
        meteostationManager.addDimension("Chazhemto_3", LocalDate.now().minusDays(5), 7);
        meteostationManager.addDimension("Chazhemto_3", LocalDate.now().minusDays(3), 10);
        //-WIND-
        meteostationManager.addDimension("Tomsk_4", LocalDate.now(), 5);
        meteostationManager.addDimension("Tomsk_4", LocalDate.now(), 2);
        meteostationManager.addDimension("Tomsk_4", LocalDate.now().minusDays(1), 5);
        meteostationManager.addDimension("Tomsk_4", LocalDate.now().minusDays(1), 15);
        meteostationManager.addDimension("Tomsk_4", LocalDate.now().minusDays(2), 3);
        meteostationManager.addDimension("Tomsk_4", LocalDate.now().minusDays(4), 2);
        meteostationManager.addDimension("Tomsk_4", LocalDate.now().minusDays(5), 7);
        meteostationManager.addDimension("Tomsk_4", LocalDate.now().minusDays(3), 10);
        //-HUMIDITY
        meteostationManager.addDimension("Tomsk_5", LocalDate.now(), 5);
        meteostationManager.addDimension("Tomsk_5", LocalDate.now(), 2);
        meteostationManager.addDimension("Tomsk_5", LocalDate.now().minusDays(1), 5);
        meteostationManager.addDimension("Tomsk_5", LocalDate.now().minusDays(1), 15);
        meteostationManager.addDimension("Tomsk_5", LocalDate.now().minusDays(2), 3);
        meteostationManager.addDimension("Tomsk_5", LocalDate.now().minusDays(4), 2);
        meteostationManager.addDimension("Tomsk_5", LocalDate.now().minusDays(5), 7);
        meteostationManager.addDimension("Tomsk_5", LocalDate.now().minusDays(3), 10);
        //-TEMPERATURE
        meteostationManager.addDimension("Tomsk_6", LocalDate.now(), 5);
        meteostationManager.addDimension("Tomsk_6", LocalDate.now(), 2);
        meteostationManager.addDimension("Tomsk_6", LocalDate.now().minusDays(1), 5);
        meteostationManager.addDimension("Tomsk_6", LocalDate.now().minusDays(1), 15);
        meteostationManager.addDimension("Tomsk_6", LocalDate.now().minusDays(2), 3);
        meteostationManager.addDimension("Tomsk_6", LocalDate.now().minusDays(4), 2);
        meteostationManager.addDimension("Tomsk_6", LocalDate.now().minusDays(5), 7);
        meteostationManager.addDimension("Tomsk_6", LocalDate.now().minusDays(3), 10);
        //-WIND-
        meteostationManager.addDimension("Rostov-On-Don_7", LocalDate.now(), 5);
        meteostationManager.addDimension("Rostov-On-Don_7", LocalDate.now(), 2);
        meteostationManager.addDimension("Rostov-On-Don_7", LocalDate.now().minusDays(1), 5);
        meteostationManager.addDimension("Rostov-On-Don_7", LocalDate.now().minusDays(1), 15);
        meteostationManager.addDimension("Rostov-On-Don_7", LocalDate.now().minusDays(2), 3);
        meteostationManager.addDimension("Rostov-On-Don_7", LocalDate.now().minusDays(4), 2);
        meteostationManager.addDimension("Rostov-On-Don_7", LocalDate.now().minusDays(5), 7);
        meteostationManager.addDimension("Rostov-On-Don_7", LocalDate.now().minusDays(3), 10);
        //-HUMIDITY
        meteostationManager.addDimension("Rostov-On-Don_8", LocalDate.now(), 5);
        meteostationManager.addDimension("Rostov-On-Don_8", LocalDate.now(), 2);
        meteostationManager.addDimension("Rostov-On-Don_8", LocalDate.now().minusDays(1), 5);
        meteostationManager.addDimension("Rostov-On-Don_8", LocalDate.now().minusDays(1), 15);
        meteostationManager.addDimension("Rostov-On-Don_8", LocalDate.now().minusDays(2), 3);
        meteostationManager.addDimension("Rostov-On-Don_8", LocalDate.now().minusDays(4), 2);
        meteostationManager.addDimension("Rostov-On-Don_8", LocalDate.now().minusDays(5), 7);
        meteostationManager.addDimension("Rostov-On-Don_8", LocalDate.now().minusDays(3), 10);
        //-TEMPERATURE
        meteostationManager.addDimension("Rostov-On-Don_9", LocalDate.now(), 5);
        meteostationManager.addDimension("Rostov-On-Don_9", LocalDate.now(), 2);
        meteostationManager.addDimension("Rostov-On-Don_9", LocalDate.now().minusDays(1), 5);
        meteostationManager.addDimension("Rostov-On-Don_9", LocalDate.now().minusDays(1), 15);
        meteostationManager.addDimension("Rostov-On-Don_9", LocalDate.now().minusDays(2), 3);
        meteostationManager.addDimension("Rostov-On-Don_9", LocalDate.now().minusDays(4), 2);
        meteostationManager.addDimension("Rostov-On-Don_9", LocalDate.now().minusDays(5), 7);
        meteostationManager.addDimension("Rostov-On-Don_9", LocalDate.now().minusDays(3), 10);
        //-WIND-
        meteostationManager.addDimension("Moscow_10", LocalDate.now(), 5);
        meteostationManager.addDimension("Moscow_10", LocalDate.now(), 2);
        meteostationManager.addDimension("Moscow_10", LocalDate.now().minusDays(1), 5);
        meteostationManager.addDimension("Moscow_10", LocalDate.now().minusDays(1), 15);
        meteostationManager.addDimension("Moscow_10", LocalDate.now().minusDays(2), 3);
        meteostationManager.addDimension("Moscow_10", LocalDate.now().minusDays(4), 2);
        meteostationManager.addDimension("Moscow_10", LocalDate.now().minusDays(5), 7);
        meteostationManager.addDimension("Moscow_10", LocalDate.now().minusDays(3), 10);
        //-HUMIDITY
        meteostationManager.addDimension("Moscow_11", LocalDate.now(), 5);
        meteostationManager.addDimension("Moscow_11", LocalDate.now(), 2);
        meteostationManager.addDimension("Moscow_11", LocalDate.now().minusDays(1), 5);
        meteostationManager.addDimension("Moscow_11", LocalDate.now().minusDays(1), 15);
        meteostationManager.addDimension("Moscow_11", LocalDate.now().minusDays(2), 3);
        meteostationManager.addDimension("Moscow_11", LocalDate.now().minusDays(4), 2);
        meteostationManager.addDimension("Moscow_11", LocalDate.now().minusDays(5), 7);
        meteostationManager.addDimension("Moscow_11", LocalDate.now().minusDays(3), 10);
        //-TEMPERATURE
        meteostationManager.addDimension("Moscow_12", LocalDate.now(), 5);
        meteostationManager.addDimension("Moscow_12", LocalDate.now(), 2);
        meteostationManager.addDimension("Moscow_12", LocalDate.now().minusDays(1), 5);
        meteostationManager.addDimension("Moscow_12", LocalDate.now().minusDays(1), 15);
        meteostationManager.addDimension("Moscow_12", LocalDate.now().minusDays(2), 3);
        meteostationManager.addDimension("Moscow_12", LocalDate.now().minusDays(4), 2);
        meteostationManager.addDimension("Moscow_12", LocalDate.now().minusDays(5), 7);
        meteostationManager.addDimension("Moscow_12", LocalDate.now().minusDays(3), 10);
    }


    @Test
    void getAllRadarDimensionTest() {
        Radar radarChazhemto1 = meteostationManager.getRadarById("Chazhemto_1");
        Radar radarTomsk5 = meteostationManager.getRadarById("Tomsk_5");
        Radar radarRnD8 = meteostationManager.getRadarById("Rostov-On-Don_8");
        assertEquals(8, radarChazhemto1.getAllRadarDimension().size());
        assertEquals(8, radarTomsk5.getAllRadarDimension().size());
        assertEquals(8, radarRnD8.getAllRadarDimension().size());

    }

    @Test
    void getForecast() {
        meteostationManager.markRadarAsFault("Moscow_11");
        meteostationManager.markRadarAsFault("Rostov-On-Don_9");
        Forecast forecast = meteostationManager.getForecast(LocalDate.now());
        assertFalse(forecast.isAccurate());
        //посчитать среднее и проверить

        meteostationManager.markRadarAsServiceable("Moscow_11");
        meteostationManager.markRadarAsServiceable("Rostov-On-Don_9");
        Forecast forecast1 = meteostationManager.getForecast(LocalDate.now());
        assertTrue(forecast1.isAccurate());


    }

    @Test
    void markRadarAsFaultTest() {
        meteostationManager.markRadarAsFault("Moscow_10");
        
    }

    @Test
    void markRadarAsServiceable() {
        meteostationManager.markRadarAsFault("Moscow_10");
        assertFalse(meteostationManager.getRadarById("Moscow_10").isServiceable());
        meteostationManager.markRadarAsServiceable("Moscow_10");
        assertTrue(meteostationManager.getRadarById("Moscow_10").isServiceable());
    }

    @Test
    void getAllFaultyRadars() {
        meteostationManager.markRadarAsFault("Moscow_10");
        meteostationManager.markRadarAsFault("Moscow_12");
        meteostationManager.markRadarAsFault("Rostov-On-Don_9");
        meteostationManager.markRadarAsFault("Tomsk_4");
        assertFalse(meteostationManager.getAllFaultyRadars().isEmpty());
        assertEquals(4, meteostationManager.getAllFaultyRadars().size());
    }
}