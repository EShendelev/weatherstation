package test.java.org.weatherstation.dimension.service.util;

import main.java.org.weatherstation.dimension.service.util.IdGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IdGeneratorTest {

    @Test
    public void generationTest(){
        long id = IdGenerator.getId();
        long id1 = IdGenerator.getId();
        assertEquals(1, id);
        assertEquals(2, id1);
    }

}