package test.java.org.weatherstation.meteostation.service.implement;

import main.java.org.weatherstation.dimension.model.TypeOfDimension;
import main.java.org.weatherstation.forecast.model.Forecast;
import main.java.org.weatherstation.meteostation.service.implement.MeteostationManagerImpl;
import main.java.org.weatherstation.meteostation.service.interfaces.MeteostationMandager;
import main.java.org.weatherstation.radar.exceptions.NotExistRadarException;
import main.java.org.weatherstation.radar.model.Radar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static main.java.org.weatherstation.dimension.model.TypeOfDimension.*;
import static org.junit.jupiter.api.Assertions.*;


class MeteostationManagerTest {

    MeteostationMandager meteostationManager = new MeteostationManagerImpl();
    private static final LocalDate DATE_FOR_TEST = LocalDate.of(2024, 7, 27);



    @BeforeEach
    public void addData() {
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
        meteostationManager.addDimension("Chazhemto_1", DATE_FOR_TEST, 5);
        meteostationManager.addDimension("Chazhemto_1", DATE_FOR_TEST, 2);
        meteostationManager.addDimension("Chazhemto_1", DATE_FOR_TEST.minusDays(1), 5);
        meteostationManager.addDimension("Chazhemto_1", DATE_FOR_TEST.minusDays(2), 15);
        meteostationManager.addDimension("Chazhemto_1", DATE_FOR_TEST.minusDays(3), 3);
        meteostationManager.addDimension("Chazhemto_1", DATE_FOR_TEST.minusDays(4), 2);
        meteostationManager.addDimension("Chazhemto_1", DATE_FOR_TEST.minusDays(5), 7);
        meteostationManager.addDimension("Chazhemto_1", DATE_FOR_TEST.minusDays(5), 10);
        //-HUMIDITY
        meteostationManager.addDimension("Chazhemto_2", DATE_FOR_TEST, 5);
        meteostationManager.addDimension("Chazhemto_2", DATE_FOR_TEST, 2);
        meteostationManager.addDimension("Chazhemto_2", DATE_FOR_TEST.minusDays(1), 5);
        meteostationManager.addDimension("Chazhemto_2", DATE_FOR_TEST.minusDays(2), 15);
        meteostationManager.addDimension("Chazhemto_2", DATE_FOR_TEST.minusDays(3), 3);
        meteostationManager.addDimension("Chazhemto_2", DATE_FOR_TEST.minusDays(4), 2);
        meteostationManager.addDimension("Chazhemto_2", DATE_FOR_TEST.minusDays(5), 7);
        meteostationManager.addDimension("Chazhemto_2", DATE_FOR_TEST.minusDays(5), 10);
        //-TEMPERATURE
        meteostationManager.addDimension("Chazhemto_3", DATE_FOR_TEST, 5);
        meteostationManager.addDimension("Chazhemto_3", DATE_FOR_TEST, 2);
        meteostationManager.addDimension("Chazhemto_3", DATE_FOR_TEST.minusDays(1), 5);
        meteostationManager.addDimension("Chazhemto_3", DATE_FOR_TEST.minusDays(2), 15);
        meteostationManager.addDimension("Chazhemto_3", DATE_FOR_TEST.minusDays(3), 3);
        meteostationManager.addDimension("Chazhemto_3", DATE_FOR_TEST.minusDays(4), 2);
        meteostationManager.addDimension("Chazhemto_3", DATE_FOR_TEST.minusDays(5), 7);
        meteostationManager.addDimension("Chazhemto_3", DATE_FOR_TEST.minusDays(5), 10);
        //-WIND-
        meteostationManager.addDimension("Tomsk_4", DATE_FOR_TEST, 5);
        meteostationManager.addDimension("Tomsk_4", DATE_FOR_TEST, 2);
        meteostationManager.addDimension("Tomsk_4", DATE_FOR_TEST.minusDays(1), 5);
        meteostationManager.addDimension("Tomsk_4", DATE_FOR_TEST.minusDays(2), 15);
        meteostationManager.addDimension("Tomsk_4", DATE_FOR_TEST.minusDays(3), 3);
        meteostationManager.addDimension("Tomsk_4", DATE_FOR_TEST.minusDays(4), 2);
        meteostationManager.addDimension("Tomsk_4", DATE_FOR_TEST.minusDays(5), 7);
        meteostationManager.addDimension("Tomsk_4", DATE_FOR_TEST.minusDays(5), 10);
        //-HUMIDITY
        meteostationManager.addDimension("Tomsk_5", DATE_FOR_TEST, 5);
        meteostationManager.addDimension("Tomsk_5", DATE_FOR_TEST, 2);
        meteostationManager.addDimension("Tomsk_5", DATE_FOR_TEST.minusDays(1), 5);
        meteostationManager.addDimension("Tomsk_5", DATE_FOR_TEST.minusDays(2), 15);
        meteostationManager.addDimension("Tomsk_5", DATE_FOR_TEST.minusDays(3), 3);
        meteostationManager.addDimension("Tomsk_5", DATE_FOR_TEST.minusDays(4), 2);
        meteostationManager.addDimension("Tomsk_5", DATE_FOR_TEST.minusDays(5), 7);
        meteostationManager.addDimension("Tomsk_5", DATE_FOR_TEST.minusDays(5), 10);
        //-TEMPERATURE
        meteostationManager.addDimension("Tomsk_6", DATE_FOR_TEST, 5);
        meteostationManager.addDimension("Tomsk_6", DATE_FOR_TEST, 2);
        meteostationManager.addDimension("Tomsk_6", DATE_FOR_TEST.minusDays(1), 5);
        meteostationManager.addDimension("Tomsk_6", DATE_FOR_TEST.minusDays(2), 15);
        meteostationManager.addDimension("Tomsk_6", DATE_FOR_TEST.minusDays(3), 3);
        meteostationManager.addDimension("Tomsk_6", DATE_FOR_TEST.minusDays(4), 2);
        meteostationManager.addDimension("Tomsk_6", DATE_FOR_TEST.minusDays(5), 7);
        meteostationManager.addDimension("Tomsk_6", DATE_FOR_TEST.minusDays(5), 10);
        //-WIND-
        meteostationManager.addDimension("Rostov-On-Don_7", DATE_FOR_TEST, 5);
        meteostationManager.addDimension("Rostov-On-Don_7", DATE_FOR_TEST, 2);
        meteostationManager.addDimension("Rostov-On-Don_7", DATE_FOR_TEST.minusDays(1), 5);
        meteostationManager.addDimension("Rostov-On-Don_7", DATE_FOR_TEST.minusDays(2), 15);
        meteostationManager.addDimension("Rostov-On-Don_7", DATE_FOR_TEST.minusDays(3), 3);
        meteostationManager.addDimension("Rostov-On-Don_7", DATE_FOR_TEST.minusDays(4), 2);
        meteostationManager.addDimension("Rostov-On-Don_7", DATE_FOR_TEST.minusDays(5), 7);
        meteostationManager.addDimension("Rostov-On-Don_7", DATE_FOR_TEST.minusDays(5), 10);
        //-HUMIDITY
        meteostationManager.addDimension("Rostov-On-Don_8", DATE_FOR_TEST, 5);
        meteostationManager.addDimension("Rostov-On-Don_8", DATE_FOR_TEST, 2);
        meteostationManager.addDimension("Rostov-On-Don_8", DATE_FOR_TEST.minusDays(1), 5);
        meteostationManager.addDimension("Rostov-On-Don_8", DATE_FOR_TEST.minusDays(2), 15);
        meteostationManager.addDimension("Rostov-On-Don_8", DATE_FOR_TEST.minusDays(3), 3);
        meteostationManager.addDimension("Rostov-On-Don_8", DATE_FOR_TEST.minusDays(4), 2);
        meteostationManager.addDimension("Rostov-On-Don_8", DATE_FOR_TEST.minusDays(5), 7);
        meteostationManager.addDimension("Rostov-On-Don_8", DATE_FOR_TEST.minusDays(5), 10);
        //-TEMPERATURE
        meteostationManager.addDimension("Rostov-On-Don_9", DATE_FOR_TEST, 5);
        meteostationManager.addDimension("Rostov-On-Don_9", DATE_FOR_TEST, 2);
        meteostationManager.addDimension("Rostov-On-Don_9", DATE_FOR_TEST.minusDays(1), 5);
        meteostationManager.addDimension("Rostov-On-Don_9", DATE_FOR_TEST.minusDays(2), 15);
        meteostationManager.addDimension("Rostov-On-Don_9", DATE_FOR_TEST.minusDays(5), 7);
        meteostationManager.addDimension("Rostov-On-Don_9", DATE_FOR_TEST.minusDays(5), 10);
        //-WIND-
        meteostationManager.addDimension("Moscow_10", DATE_FOR_TEST, 5);
        meteostationManager.addDimension("Moscow_10", DATE_FOR_TEST, 2);
        meteostationManager.addDimension("Moscow_10", DATE_FOR_TEST.minusDays(1), 5);
        meteostationManager.addDimension("Moscow_10", DATE_FOR_TEST.minusDays(2), 15);
        meteostationManager.addDimension("Moscow_10", DATE_FOR_TEST.minusDays(5), 7);
        meteostationManager.addDimension("Moscow_10", DATE_FOR_TEST.minusDays(5), 10);
        //-HUMIDITY
        meteostationManager.addDimension("Moscow_11", DATE_FOR_TEST, 5);
        meteostationManager.addDimension("Moscow_11", DATE_FOR_TEST, 2);
        meteostationManager.addDimension("Moscow_11", DATE_FOR_TEST.minusDays(1), 5);
        meteostationManager.addDimension("Moscow_11", DATE_FOR_TEST.minusDays(2), 15);
        meteostationManager.addDimension("Moscow_11", DATE_FOR_TEST.minusDays(3), 3);
        meteostationManager.addDimension("Moscow_11", DATE_FOR_TEST.minusDays(4), 2);
        meteostationManager.addDimension("Moscow_11", DATE_FOR_TEST.minusDays(5), 7);
        meteostationManager.addDimension("Moscow_11", DATE_FOR_TEST.minusDays(5), 10);
        //-TEMPERATURE
        meteostationManager.addDimension("Moscow_12", DATE_FOR_TEST, 5);
        meteostationManager.addDimension("Moscow_12", DATE_FOR_TEST, 2);
        meteostationManager.addDimension("Moscow_12", DATE_FOR_TEST.minusDays(1), 5);
        meteostationManager.addDimension("Moscow_12", DATE_FOR_TEST.minusDays(2), 15);
        meteostationManager.addDimension("Moscow_12", DATE_FOR_TEST.minusDays(3), 3);
        meteostationManager.addDimension("Moscow_12", DATE_FOR_TEST.minusDays(4), 2);
        meteostationManager.addDimension("Moscow_12", DATE_FOR_TEST.minusDays(5), 7);
        meteostationManager.addDimension("Moscow_12", DATE_FOR_TEST.minusDays(5), 10);
    }

    @Test
    public void expectedExceptionCreateTest() {
        assertThrows(NotExistRadarException.class, () -> meteostationManager.getRadarById("Abracadabra"));
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
    void getForecastTestWithFaultRadars() {
        meteostationManager.addDimension("Rostov-On-Don_9", DATE_FOR_TEST.minusDays(3), 3);
        meteostationManager.addDimension("Rostov-On-Don_9", DATE_FOR_TEST.minusDays(4), 2);
        meteostationManager.addDimension("Moscow_10", DATE_FOR_TEST.minusDays(3), 3);
        meteostationManager.addDimension("Moscow_10", DATE_FOR_TEST.minusDays(4), 2);

        meteostationManager.markRadarAsFault("Moscow_11");
        meteostationManager.markRadarAsFault("Rostov-On-Don_9");
        Forecast forecast = meteostationManager.getForecast(DATE_FOR_TEST);
        assertFalse(forecast.isAccurate());
        assertEquals(6.125, forecast.getWind());
        assertEquals(6.125, forecast.getTemperature());
        assertEquals(6.125, forecast.getHumidity());
        //посчитать среднее и проверить
    }

    @Test
    void getForecastTest() {
        meteostationManager.addDimension("Rostov-On-Don_9", DATE_FOR_TEST.minusDays(3), 3);
        meteostationManager.addDimension("Rostov-On-Don_9", DATE_FOR_TEST.minusDays(4), 2);
        meteostationManager.addDimension("Moscow_10", DATE_FOR_TEST.minusDays(3), 3);
        meteostationManager.addDimension("Moscow_10", DATE_FOR_TEST.minusDays(4), 2);
        Forecast forecast = meteostationManager.getForecast(DATE_FOR_TEST);
        assertTrue(forecast.isAccurate());
    }

    @Test
    void getForecastWithNotEnoughCountDimension() {
        Forecast forecast = meteostationManager.getForecast(DATE_FOR_TEST);
        assertFalse(forecast.isAccurate());
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