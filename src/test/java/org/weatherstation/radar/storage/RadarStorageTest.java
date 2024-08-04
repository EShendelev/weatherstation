package test.java.org.weatherstation.radar.storage;

import com.sun.tools.attach.AgentLoadException;
import main.java.org.weatherstation.radar.exceptions.AlreadyExistRadarException;
import main.java.org.weatherstation.radar.model.HumidityRadar;
import main.java.org.weatherstation.radar.model.Radar;
import main.java.org.weatherstation.radar.model.TemperatureRadar;
import main.java.org.weatherstation.radar.storage.RadarStorage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class RadarStorageTest {

    RadarStorage radarStorage = new RadarStorage();


    @Test
    void addRadarWithAlreadyHaveUidTest() {
        Radar radar = new HumidityRadar("Test", 53, 43);
        radarStorage.addRadarByIds("Test", radar);
        Radar radar1 = new TemperatureRadar("Test", 57, 58);
        assertThrows(AlreadyExistRadarException.class, () -> radarStorage.addRadarByIds("Test", radar));
    }
}