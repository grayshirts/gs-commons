package ar.com.grayshirts.commons.format;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtilsTest {

    @Test
    public void testMaskName() {
        assertEquals("mar***", StringUtils.maskName("marianoruiz"));
        assertEquals("m***",   StringUtils.maskName("mr"));
    }

    @Test
    public void testMaskEmail() {
        assertEquals("mar***@grays***.com.ar",      StringUtils.maskEmail("marianoruiz@grayshirts.com.ar"));
        assertEquals("mar***+test@grays***.com.ar", StringUtils.maskEmail("marianoruiz+test@grayshirts.com.ar"));
    }
}
