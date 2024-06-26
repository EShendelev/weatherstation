package test.java.org.weatherstation.radar.service.util;

import main.java.org.weatherstation.radar.service.util.UidGenerator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UidGeneratorTest {



    @Test
    public void test_Uid_1() {
        String uid = UidGenerator.getUid("Чажемто");
        String uid2 = UidGenerator.getUid("Ростов-на-Дону");
        assertEquals("Чажемто_1", uid);
        assertEquals("Ростов-на-Дону_2", uid2);
    }
}