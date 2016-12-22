package ar.com.grayshirts.commons.codec;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class HashEncoderUtilsTest {

    @Test
    public void testncodeMd5Hex() {
        assertEquals("21232f297a57a5a743894a0e4a801fc3", HashEncoderUtils.encodeMd5Hex("admin"));
        assertEquals("fe01ce2a7fbac8fafaed7c982a04e229", HashEncoderUtils.encodeMd5Hex("demo"));
    }

    @Test
    public void testEncodeSha256Hex() {
        assertEquals("8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918", HashEncoderUtils.encodeSha256Hex("admin"));
        assertEquals("2a97516c354b68848cdbd8f54a226a0a55b21ed138e207ad6c5cbb9c00aa5aea", HashEncoderUtils.encodeSha256Hex("demo"));
    }
}
