package ar.com.grayshirts.commons.codec;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.apache.commons.lang3.RandomStringUtils.random;

public class PasswordEncoderTest {

    private PasswordEncoder passwordEncoder = new PasswordEncoder("+sAltCod..e");

    // echo -n "admin+sAltCod..e" | sha256sum
    private static final String ADMIN_ENCODED = "2b4a41990dfed30d46371a60396cc704d48e399c7cd518ff09fbadd4c46e879b";

    private static final String DEMO_ENCODED  = "a36c6f7a6b661b7449284cf78c235ef365ed4acb666f8281d6869f1947094dc2";


    @Test
    public void testEncode() {
        assertEquals(ADMIN_ENCODED, passwordEncoder.encode("admin"));
        assertEquals(DEMO_ENCODED,  passwordEncoder.encode("demo"));
    }

    @Test
    public void testRandomMatches() {
        // 10 times test
        String random = random(6, true, true);
        assertTrue(passwordEncoder.matches(random, passwordEncoder.encode(random)));
        random = random( 7, true, true);
        assertTrue(passwordEncoder.matches(random, passwordEncoder.encode(random)));
        random = random( 8, true, false);
        assertTrue(passwordEncoder.matches(random, passwordEncoder.encode(random)));
        random = random( 9, true, true);
        assertTrue(passwordEncoder.matches(random, passwordEncoder.encode(random)));
        random = random(10, true, false);
        assertTrue(passwordEncoder.matches(random, passwordEncoder.encode(random)));
        random = random(15, true, true);
        assertTrue(passwordEncoder.matches(random, passwordEncoder.encode(random)));
        random = random(17, true, false);
        assertTrue(passwordEncoder.matches(random, passwordEncoder.encode(random)));
        random = random(20, true, true);
        assertTrue(passwordEncoder.matches(random, passwordEncoder.encode(random)));
        random = random(20, true, false);
        assertTrue(passwordEncoder.matches(random, passwordEncoder.encode(random)));
        random = random(22, true, true);
        assertTrue(passwordEncoder.matches(random, passwordEncoder.encode(random)));
    }

    @Test
    public void testNotNullPasswords() {
        try {
            passwordEncoder.matches(null, passwordEncoder.encode("thepassword1"));
            assert false;
        } catch (IllegalArgumentException e) {}
        try {
            passwordEncoder.matches("", passwordEncoder.encode("thepassword1"));
            assert false;
        } catch (IllegalArgumentException e) {}
        try {
            passwordEncoder.matches("XXXXXXXXX", passwordEncoder.encode(null));
            assert false;
        } catch (IllegalArgumentException e) {}
        try {
            passwordEncoder.matches(null, passwordEncoder.encode(null));
            assert false;
        } catch (IllegalArgumentException e) {}
    }

    @Test
    public void testDoesntMatch() {
        assertFalse(passwordEncoder.matches("XXXXXXXXX", passwordEncoder.encode("thepassword1")));
        assertFalse(passwordEncoder.matches(ADMIN_ENCODED, passwordEncoder.encode("isnotadminpass")));
    }

    @Test
    public void testPlainDoesntMatch() {
        assertFalse("Plain password doesn't match plain password",     passwordEncoder.matches("thepassword", "thepassword"));
        assertFalse("Encoded password doesn't match encoded password", passwordEncoder.matches(ADMIN_ENCODED, ADMIN_ENCODED));
    }
}
