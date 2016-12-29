package ar.com.grayshirts.commons.codec;

import org.apache.commons.lang3.StringUtils;

/**
 * Encodes password with SHA-256 algorithm in hexadecimal format.
 * NOTE: It's has the same methods required for ``PasswordEncoder`` interface
 * (Spring Security), but doesn't implements it to avoid use
 * of heavy components initializations from this tool that aren't used.
 */
public class PasswordEncoder /* implements org.springframework.security.crypto.password.PasswordEncoder */ {

    private String saltCode;

    public PasswordEncoder(String saltCode) {
        this.saltCode = saltCode;
    }

    /**
     * Encode the raw password.
     */
    public String encode(CharSequence rawPassword) {
        if (StringUtils.isEmpty(rawPassword)) {
            throw new IllegalArgumentException("Raw password cannot be null or empty");
        }
        return enc(addSalt(rawPassword));
    }

    /**
     * Checks if the raw password matches the encoded password.
     */
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        if (StringUtils.isEmpty(rawPassword)) {
            throw new IllegalArgumentException("Raw password cannot be null or empty");
        }
        if (StringUtils.isEmpty(encodedPassword)) {
            throw new IllegalArgumentException("Encoded password cannot be null or empty");
        }
        return encodedPassword.equals(encode(rawPassword));
    }

    /**
     * Adds the salt code, override to add a different salt.
     */
    protected CharSequence addSalt(CharSequence rawPassword) {
        if (StringUtils.isNotEmpty(saltCode)) {
            return rawPassword.toString() + saltCode;
        }
        return rawPassword;
    }

    /**
     * Encodes the text. Override to change
     * the SHA-256 encode to another one.
     */
    protected String enc(CharSequence text) {
        return HashEncoderUtils.encodeSha256Hex(text);
    }
}
