package ar.com.grayshirts.commons.format;

import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

/**
 * Util methods to work with time and dates.
 */
public abstract class TimeUtils {

    // Eg. 2017-01-18T23:30:07.362Z
    private static final DateFormat ISO_FORMATTER = new ISO8601DateFormat();

    /**
     * Convert an ISO date string (eg. "2017-01-18T23:30:07.362Z") to a `Date` object.
     * @param dateAsISO String: the string representation, in the format "yyyy-MM-dd'T'HH:mm:ss.SSSZ". Time are
     *                  optional (eg. "2020-01-18Z").
     * @return the `java.util.Date` representation
     */
    public static Date fromISOString(String dateAsISO) {
        if (dateAsISO.endsWith("+0000")) {
            dateAsISO.replace("+0000", "Z");	// To avoid time zone issues
        } else if (!dateAsISO.endsWith("Z")) {
            dateAsISO += "Z";					// To avoid time zone issues
        }
        synchronized (ISO_FORMATTER) {
            try {
                Date date = ISO_FORMATTER.parse(dateAsISO);
                return date;
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static String toISOString(Date date) {
        synchronized (ISO_FORMATTER) {
            String isoDate = ISO_FORMATTER.format(date);
            return isoDate;
        }
    }
}
