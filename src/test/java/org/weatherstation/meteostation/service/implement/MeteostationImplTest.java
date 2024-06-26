package test.java.org.weatherstation.meteostation.service.implement;

import main.java.org.weatherstation.dimension.model.Dimension;
import main.java.org.weatherstation.meteostation.service.implement.MeteostationImpl;
import main.java.org.weatherstation.meteostation.service.interfaces.Meteostation;
import main.java.org.weatherstation.radar.model.Radar;
import main.java.org.weatherstation.radar.storage.RadarStorage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static main.java.org.weatherstation.dimension.model.TypeOfDimension.*;
import static org.junit.jupiter.api.Assertions.*;


class MeteostationImplTest {

    private static final Meteostation meteostation = new MeteostationImpl();

//    @BeforeAll
//    public static void setUp() {
//        meteostation = new MeteostationImpl();
//    }

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
    void addDimensionTest() {
       Radar radar = RadarStorage.radarList.get("Chazhemto_1");
       List<Dimension> radarDimension =  radar.getAllRadarDimension();
       assertFalse(radarDimension.isEmpty());
    }

    @Test
    void getAllRadarDimension() {

    }

    @Test
    void getForecast() {
    }

    @Test
    void markRadarAsFault() {
    }

    @Test
    void markRadarAsServiceable() {
    }

    @Test
    void getAllFaultyRadars() {
    }
}