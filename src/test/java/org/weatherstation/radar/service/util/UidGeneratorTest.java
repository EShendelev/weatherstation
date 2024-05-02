package test.java.org.weatherstation.radar.service.util;

import main.java.org.weatherstation.radar.service.util.UidGenerator;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UidGeneratorTest {



    @Test
    public void test_Uid_1() {
        String uid = UidGenerator.getUid("Чажемто");
        assertEquals("Чажемто_1", uid);
    }
}