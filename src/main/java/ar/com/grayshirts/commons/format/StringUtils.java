package ar.com.grayshirts.commons.format;

import java.text.Normalizer;
import java.util.Locale;
import java.util.regex.Pattern;

/**
 * Util methods to format strings.
 */
public abstract class StringUtils {

    private static final Pattern NONLATIN =   Pattern.compile("[^\\w-]");
    private static final Pattern WHITESPACE = Pattern.compile("[\\s]");
    private static final Pattern EDGESDHASHES = Pattern.compile("(^-|-$)");

    /**
     * Mask an email address to hide the full address.
     * @param email
     * @return
     */
    public static String maskEmail(String email) {
        try {
            String [] emailArray = email.split("@");
            String username = emailArray[0];
            String usernameEnd = "";
            if (username.contains("."))
                usernameEnd = maskName(username.substring(email.indexOf(".")));
            else if (username.contains("_"))
                usernameEnd = maskName(username.substring(email.indexOf("_")));
            if (username.contains("+")) usernameEnd += username.substring(email.indexOf("+"));
            String domain = emailArray[1].substring(0, emailArray[1].indexOf("."));
            String region = emailArray[1].substring(emailArray[1].indexOf(".") + 1);
            return maskName(username) + usernameEnd + "@" + maskName(domain, 5) + "." + region;
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("String " + email + " is not a valid email.");
        }
    }

    public static String maskName(String name) {
        return maskName(name, 3);
    }

    public static String maskName(String name, int maxUnmask) {
        if (name.length()==0) {
            return "";
        }
        if (name.length()>maxUnmask+1) {
            return name.substring(0, maxUnmask) + "***";
        }
        if (name.length()>4) {
            return name.substring(0, 3) + "***";
        }
        if (name.length()==4) {
            return name.substring(0, 2) + "***";
        }
        return name.substring(0, 1) + "***";
    }

    public static String slugify(String text) {
        String nowhitespace = WHITESPACE.matcher(text).replaceAll("-");
        String normalized = Normalizer.normalize(nowhitespace, Normalizer.Form.NFD);
        String slug = NONLATIN.matcher(normalized).replaceAll("");
        slug = EDGESDHASHES.matcher(slug).replaceAll("");
        return slug.toLowerCase(Locale.ENGLISH);
    }

    public static String html(String text) {
        if (text==null) return "";
        return text.replace("<", "&lt;").replace(">", "&gt;").replace("\n", "<br/>");
    }
}
