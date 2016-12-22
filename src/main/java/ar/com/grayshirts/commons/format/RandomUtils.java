package ar.com.grayshirts.commons.format;

import com.google.common.base.Charsets;
import com.google.common.io.BaseEncoding;
import org.apache.commons.lang3.RandomStringUtils;
import java.util.UUID;

/**
 * Random string generators.
 */
public abstract class RandomUtils {

    /**
     * Returns a random hexadecimal string whose length is the number of characters specified.
     * @param length the length of random hexadecimal string to create. It's must be
     *               greater than 1 and equals or less than 32.
     * @return an hexadecimal number, in lower case
     */
    public static String randomHex(int length) {
        if (length<1 || length>32) throw new IllegalArgumentException("length must be equals or greater than 1 and equals or less than 32.");
        return UUID.randomUUID().toString().replace("-", "").substring(0, length);
    }


    /**
     * Creates a random base64 string whose length is the number of characters specified.
     *
     * @param length the length of random Base64 string to create. It's must be
     *               multiply of 4.
     * @return a base64 string, compatible with URL and file name formats
     */
    public static String randomBase64(int length) {
        if (length==0 || length%4!=0) throw new IllegalArgumentException("length must be multiply of 4.");
        return BaseEncoding.base64Url().encode(
            RandomStringUtils.randomAscii((length/4) * 3).getBytes(Charsets.US_ASCII));
    }
}
