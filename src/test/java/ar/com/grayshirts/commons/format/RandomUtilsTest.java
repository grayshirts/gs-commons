package ar.com.grayshirts.commons.format;

import org.junit.Test;
import static org.junit.Assert.*;

public class RandomUtilsTest {

    @Test
    public void testRandomHex() {
        assertNotNull(RandomUtils.randomHex(10));
        assertEquals(RandomUtils.randomHex(10).length(), 10);
        assertNotEquals(RandomUtils.randomHex(16), RandomUtils.randomHex(16));
        assertNotEquals(RandomUtils.randomHex(32), RandomUtils.randomHex(32));
        assertNotEquals(RandomUtils.randomHex(32), RandomUtils.randomHex(32));
    }

    @Test
    public void testRandomBase64() {
        assertNotNull(RandomUtils.randomBase64(4));
        assertEquals(RandomUtils.randomBase64(8).length(), 8);
        assertNotEquals(RandomUtils.randomBase64(16), RandomUtils.randomBase64(16));
        assertNotEquals(RandomUtils.randomBase64(20), RandomUtils.randomBase64(20));
        assertNotEquals(RandomUtils.randomBase64(32), RandomUtils.randomBase64(32));
    }
}
